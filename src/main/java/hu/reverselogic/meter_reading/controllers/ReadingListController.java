package hu.reverselogic.meter_reading.controllers;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.info.BuildProperties;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import hu.reverselogic.meter_reading.datas.CustomUserDetails;
import hu.reverselogic.meter_reading.datas.ReadingData;
import hu.reverselogic.meter_reading.entities.Meter;
import hu.reverselogic.meter_reading.entities.Reading;
import hu.reverselogic.meter_reading.services.MeterService;
import hu.reverselogic.meter_reading.services.ReadingService;

@Controller
public class ReadingListController{

    @Autowired
    private ReadingService readingService;
    @Autowired
    private MeterService meterService;
    @Autowired
    private BuildProperties buildProperties;

    public String listreadings(Model model)
    {
        model.addAttribute("readinglist", readingService.ListAll());
        return "readinglist";
    }
    
    @GetMapping({"/readinglist/{id}", "readinglist"})
    public String listMetersReadings(@PathVariable String id, Model model)
    {
        CustomUserDetails userDetails = (CustomUserDetails)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        List<Meter> users_meters = meterService.ListAllByID(userDetails.getID());
        Long meter_id = Long.parseLong(id);
        for (Meter um : users_meters) {
            if(um.getId() == meter_id)
            {
                List<Reading> meters = readingService.ListAllByID(meter_id);
                model.addAttribute("readinglist", meters);
                model.addAttribute("meterid", id);
                model.addAttribute("username", userDetails.getName());
                model.addAttribute("version", buildProperties.getVersion());
                DateTimeFormatter dateformat = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                model.addAttribute("today", dateformat.format(LocalDate.now()));
                LocalDate begofmonth = LocalDate.now().withDayOfMonth(1);
                model.addAttribute("begofmonth", dateformat.format(begofmonth));
                if(meters.size() > 0){
                    Reading max = meters.get(0);
                    for (Reading read : meters) {
                        if(read.getReadingDate().compareTo(max.getReadingDate()) > 0)
                        {
                            max = read;
                        }
                    }
                    model.addAttribute("lastreadingvalue", max.getMeterActualValue());
                }
                return "readinglist";
            }
        }
        return "error";
        
    }

    @RequestMapping(value = "/readinglist/new", method = RequestMethod.POST)
    public String newReading(@Valid ReadingData readingData, BindingResult bindingResult, @RequestParam("file") MultipartFile file) throws IOException, NoSuchAlgorithmException
    {
        if(bindingResult.hasErrors()){
            return "redirect:/readinglist/";
        }

        Long meterid = readingService.newReading(readingData, file);
        return "redirect:/readinglist/" + meterid;
    }
    
}
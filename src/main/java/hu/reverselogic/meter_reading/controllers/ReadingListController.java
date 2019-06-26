package hu.reverselogic.meter_reading.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import hu.reverselogic.meter_reading.datas.ReadingData;
import hu.reverselogic.meter_reading.services.ReadingService;

@Controller
public class ReadingListController{

    private ReadingService readingService;

    @Autowired
    public void setReadingService(ReadingService readingService)
    {
        this.readingService = readingService;
    }

    public String listreadings(Model model)
    {
        model.addAttribute("readinglist", readingService.ListAll());
        return "readinglist";
    }
    
    @GetMapping({"/readinglist/{id}", "readinglist"})
    public String listMetersReadings(@PathVariable String id, Model model)
    {
        model.addAttribute("readinglist", readingService.ListAllByID(Long.parseLong(id)));
        model.addAttribute("meterid", id);
        return "readinglist";
    }

    @RequestMapping(value = "/readinglist/new", method = RequestMethod.POST)
    public String newReading(@Valid ReadingData readingData, BindingResult bindingResult)
    {
        if(bindingResult.hasErrors()){
            return "redirect:/readinglist/";
        }

        Long meterid = readingService.newReading(readingData);
        return "redirect:/readinglist/" + meterid;
    }
    
}
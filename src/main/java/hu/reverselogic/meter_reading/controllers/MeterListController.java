package hu.reverselogic.meter_reading.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.info.BuildProperties;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import hu.reverselogic.meter_reading.datas.CustomUserDetails;
import hu.reverselogic.meter_reading.entities.Meter;
import hu.reverselogic.meter_reading.services.MeterService;

@Controller
public class MeterListController{

    @Autowired
    private MeterService meterService;
    @Autowired
    private BuildProperties buildProperties;

    public String listmeters(Model model)
    {
        model.addAttribute("meterlist", meterService.ListAll());
        return "meterlist";
    }

    @GetMapping("/meterlist")
    public String listUserMeters(Model model)
    {
        CustomUserDetails userDetails = (CustomUserDetails)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        List<Meter> meters = meterService.ListAllByID(userDetails.getID());
        model.addAttribute("meterlist", meters);
        model.addAttribute("username", userDetails.getName());
        model.addAttribute("version", buildProperties.getVersion());
        return "meterlist";
    }
    
    
}
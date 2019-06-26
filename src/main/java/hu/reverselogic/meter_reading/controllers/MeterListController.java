package hu.reverselogic.meter_reading.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import hu.reverselogic.meter_reading.services.MeterService;

@Controller
public class MeterListController{

    private MeterService meterService;

    @Autowired
    public void setMeterService(MeterService meterService)
    {
        this.meterService = meterService;
    }

    public String listmeters(Model model)
    {
        model.addAttribute("meterlist", meterService.ListAll());
        return "meterlist";
    }

    @GetMapping("/meterlist/{id}")
    public String listUserMeters(@PathVariable String id, Model model)
    {
        model.addAttribute("meterlist", meterService.ListAllByID(Long.parseLong(id)));
        return "meterlist";
    }
    
    
}
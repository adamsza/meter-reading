package hu.reverselogic.meter_reading.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.info.BuildProperties;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController{
    @Autowired
    private BuildProperties buildProperties;

    @GetMapping("/")
    public String getIndex()
    {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        if (!(auth instanceof AnonymousAuthenticationToken)) {
            return "redirect:/meterlist";
        }
        else return "redirect:/login";
    }

    @GetMapping("/login")
    public String getLogin(Model model)
    {
        model.addAttribute("version", buildProperties.getVersion());
        return "login";
    }
    
}
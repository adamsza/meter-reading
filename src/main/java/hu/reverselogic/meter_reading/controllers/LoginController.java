package hu.reverselogic.meter_reading.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import hu.reverselogic.meter_reading.datas.LoginData;
import hu.reverselogic.meter_reading.entities.User;
import hu.reverselogic.meter_reading.services.LoginService;

@Controller
public class LoginController{

    private LoginService loginService;

    @Autowired
    public void setMeterService(LoginService loginService)
    {
        this.loginService = loginService;
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(@Valid LoginData loginData, BindingResult bindingResult)
    {
        if(bindingResult.hasErrors()){
            return "/index";
        }

        User user = loginService.getUser(loginData);
        if(user != null) return "redirect:/meterlist/" + user.getID();
        else return "/index";
    }
}
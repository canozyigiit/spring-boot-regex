package com.can.springbootregex.controller;


import com.can.springbootregex.service.RegexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RegexController {
    private final RegexService regexService;

    @Autowired
    public RegexController(RegexService regexService) {
        this.regexService = regexService;
    }

    @PostMapping("/getdate")
    public String getDate(@RequestParam String text) {
        return regexService.getDate(text);
    }

    @PostMapping( "/getphonenumber")
    public String getPhoneNumber(@RequestParam String s) {
        return regexService.getPhoneNumber(s);
    }

    @PostMapping("/getEmail")
    public String getEmail(@RequestParam String text) {
        return regexService.getEmail(text);
    }
    @PostMapping("/getHashtag")
    public String getHashtag(@RequestParam String text) {
        return regexService.getHashtag(text);
    }
}

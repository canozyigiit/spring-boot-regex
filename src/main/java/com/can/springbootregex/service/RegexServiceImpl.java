package com.can.springbootregex.service;


import org.springframework.stereotype.Service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class RegexServiceImpl implements RegexService {
    public String getDate(String text) {
        String foundedText = "";
        Pattern pattern = Pattern.compile("(([0-9]{2}))([\\/\\-\\.])(([0-9]{2}))([\\/\\-\\.])(([0-9]{2,4}))");
        Matcher matcher = pattern.matcher(text);
        boolean found = false;

        while (matcher.find()) {
            foundedText += matcher.group() + " ";

            found = true;
        }
        System.out.println(foundedText + "");
        if (!found) {
            return "No match found.";
        }
        return foundedText;
    }

    @Override
    public String getPhoneNumber(String text) {
        String foundedText = "";
        Pattern pattern = Pattern.compile("((\\+\\d{2})?[ ]?\\(?(\\d{3})\\)?[ -.]?(\\d{3})[ -.]?(\\d{4}))");
        Matcher matcher = pattern.matcher(text);
        boolean found = false;

        while (matcher.find()) {
            foundedText += matcher.group() + " ";

            found = true;
        }
        System.out.println(foundedText + "");
        if (!found) {
            return "No match found.";
        }
        return foundedText;
    }

    @Override
    public String getEmail(String text) {
        String foundedText = "";
        Pattern pattern = Pattern.compile("(([a-zA-Z0-9])+\\@([a-zA-Z0-9])+\\.[a-zA-Z]{2,})");
        Matcher matcher = pattern.matcher(text);
        boolean found = false;

        while (matcher.find()) {
            foundedText += matcher.group() + " ";

            found = true;
        }
        System.out.println(foundedText + "");
        if (!found) {
            return "No match found.";
        }
        return foundedText;
    }

    @Override
    public String getHashtag(String text) {
        String foundedText = "";
        Pattern pattern = Pattern.compile("(#[a-zA-Z0-9işüğçöı]+)");
        Matcher matcher = pattern.matcher(text);
        boolean found = false;

        while (matcher.find()) {
            foundedText += matcher.group() + " ";

            found = true;
        }
        System.out.println(foundedText + "");
        if (!found) {
            return "No match found.";
        }
        return foundedText;
    }
}

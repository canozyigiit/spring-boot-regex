package com.can.springbootregex.service;


import org.springframework.stereotype.Service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class RegexServiceImpl implements RegexService {
    public String getDate(String text) {
        String foundedText = "";
        Pattern pattern = Pattern.compile("((?<day>([0-9]{2}))([\\/\\-\\.])(?<month>([0-9]{2}))([\\/\\-\\.])(?<year>([0-9]{2,4})))");
        Matcher matcher = pattern.matcher(text);
        boolean found = false;

        while (matcher.find()) {
            foundedText += "gün : "+matcher.group("day")+ " ay : "+matcher.group("month") + " yıl : "+matcher.group("year") + " ";
            found = true;
        }
        if (!found) {
            return "No match found.";
        }
        return foundedText;
    }

    @Override
    public String getPhoneNumber(String text) {
        String foundedText = "";
        Pattern pattern = Pattern.compile("((?<areaCode>\\+\\d{2})?[ -.]?\\(?(?<operator>\\d{3})\\)?[ -.]?(?<main>\\d{3})[ -.]?(?<number>\\d{4}))");
        Matcher matcher = pattern.matcher(text);

        boolean found = false;

        while (matcher.find()) {
            foundedText += "areaCode : "+matcher.group("areaCode")+ " operator : "+matcher.group("operator") + " main : "+matcher.group("main") + " number : "+matcher.group("number")+ " ";

            found = true;
        }
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
        if (!found) {
            return "No match found.";
        }
        return foundedText;
    }

    @Override
    public String getURL(String s) {
        String foundedText = "";
        Pattern pattern = Pattern.compile("(https?:?\\/\\/)?(www)?\\.?[a-zA-Z0-9]+\\.[a-zA-Z]{2,}");
        Matcher matcher = pattern.matcher(s);
        boolean found = false;

        while (matcher.find()) {
            foundedText += matcher.group() + " ";

            found = true;
        }
        if (!found) {
            return "No match found.";
        }
        return foundedText;
    }
}

package com.example.javasp131;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.format.TextStyle;
import java.util.Locale;

@RestController
public class DayOfWeekController
{
    @GetMapping("/day-of-week")
    public String getDayOfWeek(@RequestParam(value = "lang", defaultValue = "uk") String lang)
    {
        String dayOfWeek;
        try
        {
            Locale locale = new Locale(lang);
            dayOfWeek = LocalDate.now()
                    .getDayOfWeek()
                    .getDisplayName(TextStyle.FULL, locale);
        }
        catch (Exception e)
        {
            return "Incorrect. Use uk, en, it, de etc.";
        }
        return "Today: " + dayOfWeek + " (" + lang.toUpperCase() + ")";
    }
}

package me.ssagan.dayofweek.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class DayOfWeekController {
    final Map<String, String> dayOfWeekDictionary = new HashMap<String, String>();
    {
        dayOfWeekDictionary.put("monday", "понедельник");
        dayOfWeekDictionary.put("tuesday", "вторник");
        dayOfWeekDictionary.put("wednesday", "среда");
        dayOfWeekDictionary.put("thursday", "четверг");
        dayOfWeekDictionary.put("friday", "пятница");
        dayOfWeekDictionary.put("saturday", "суббота");
        dayOfWeekDictionary.put("sunday", "воскрееснье");
    }

    @GetMapping("/dayOfWeek")
    public String dayOfWeek(@RequestParam(value = "name", defaultValue = "monday") String name) {
        if (!dayOfWeekDictionary.containsKey(name.toLowerCase()))
            throw new RuntimeException("Wrong day of week:" + name);
        return "Сегодня " + dayOfWeekDictionary.get(name.toLowerCase());
    }
}

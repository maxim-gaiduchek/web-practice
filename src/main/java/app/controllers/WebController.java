package app.controllers;

import app.model.ResultsCalculator;
import app.model.UserRecord;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.HashMap;
import java.util.Map;

@Controller
public class WebController {

    private final Map<String, UserRecord> records = new HashMap<>();

    @RequestMapping("/")
    private String form(Model model) {
        model.addAttribute("record", new UserRecord());

        return "form";
    }

    @RequestMapping(value = "/results", method = RequestMethod.GET)
    private String results(Model model) {
        model.addAttribute("results", new ResultsCalculator(records.values()));

        return "results";
    }

    @RequestMapping(value = "/results", method = RequestMethod.POST)
    private String results(@ModelAttribute UserRecord record, Model model) {
        records.put(record.getName() + " " + record.getSurname(), record);

        System.out.println(record);
        System.out.println(records);

        return results(model);
    }

    // TODO: 07.02.2021 ip address check, enums
}

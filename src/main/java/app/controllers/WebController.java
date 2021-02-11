package app.controllers;

import app.datasource.JpaService;
import app.model.Answer;
import app.model.Statistics;
import app.model.UserRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@Controller
public class WebController {

    @Autowired
    private JpaService service;

    private final Map<String, UserRecord> records = new HashMap<>();

    @RequestMapping("/")
    private String form(Model model) {
        model.addAttribute("record", new UserRecord());

        return "form";
    }

    @RequestMapping(value = "/results", method = RequestMethod.GET)
    private String results(Model model) {
        model.addAttribute("statistics", new Statistics(service));

        return "results";
    }

    @RequestMapping(value = "/results", method = RequestMethod.POST)
    private String results(@ModelAttribute UserRecord record, HttpServletRequest servletRequest, Model model) {
        service.saveAnswer(new Answer(servletRequest, record));

        return results(model);
    }

    // TODO: 07.02.2021 ip address check, enums
}

package org.dainn.sumnumberweb.controllers;

import org.dainn.functions.MyBigNumber;
import org.dainn.functions.SumResult;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {

    @GetMapping("/")
    public String showForm() {
        return "index";
    }

    @PostMapping("/sum")
    public String calculate(@RequestParam String stn1,
                            @RequestParam String stn2,
                            Model model) {
        MyBigNumber mbn = new MyBigNumber();
        SumResult result = mbn.sumWithSteps(stn1, stn2);
        model.addAttribute("stn1", stn1);
        model.addAttribute("stn2", stn2);
        model.addAttribute("sum", result.getSum());
        model.addAttribute("steps", result.getSteps());
        return "index";
    }
}

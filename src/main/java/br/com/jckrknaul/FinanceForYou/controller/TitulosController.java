package br.com.jckrknaul.FinanceForYou.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TitulosController {
    private final String PAGE_INDEX = "index";

    @RequestMapping("/")
    public String start() {
        return PAGE_INDEX;
    }
}

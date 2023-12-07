package com.example.mandelnyamsite.controllers;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class HomeController {

    @PreAuthorize("hasAnyAuthority('admin','employee')")
    @GetMapping("/index")
    public String indexIndex() {
        return "index";
    }

    @PreAuthorize("hasAnyAuthority('user','admin','employee')")
    @GetMapping("/site/MainPage")
    public String mainIndex() {
        return "site/MainPage";
    }

    @PreAuthorize("hasAnyAuthority('user','admin','employee')")
    @GetMapping("/site/LogIn")
    public String logInIndex() {
        return "site/LogIn";
    }

    @PreAuthorize("hasAnyAuthority('user','admin','employee')")
    @GetMapping("/site/LogUp")
    public String logUpIndex() {
        return "site/LogUp";
    }

    @PreAuthorize("hasAnyAuthority('user','admin','employee')")
    @GetMapping("/site/Cart")
    public String cartIndex() {
        return "site/Cart";
    }

    @PreAuthorize("hasAnyAuthority('user','admin','employee')")
    @GetMapping("/site/Favorite")
    public String favoriteIndex() {
        return "site/Favorite";
    }

    @PreAuthorize("hasAnyAuthority('user','admin','employee')")
    @GetMapping("/site/Bread")
    public String breadIndex() {
        return "site/Bread";
    }

    @PreAuthorize("hasAnyAuthority('user','admin','employee')")
    @GetMapping("/site/Meat")
    public String meatIndex() {
        return "site/Meat";
    }

    @PreAuthorize("hasAnyAuthority('user','admin','employee')")
    @GetMapping("/site/Vegetables")
    public String vegetablesIndex() {
        return "site/Vegetables";
    }

    @PreAuthorize("hasAnyAuthority('user','admin','employee')")
    @GetMapping("/site/Fruits")
    public String fruitsIndex() {
        return "site/Fruits";
    }

    @PreAuthorize("hasAnyAuthority('user','admin','employee')")
    @GetMapping("/site/Drinks")
    public String drinksIndex() {
        return "site/Drinks";
    }

    @PreAuthorize("hasAnyAuthority('user','admin','employee')")
    @GetMapping("/site/Snacks")
    public String snacksIndex() {
        return "site/Snacks";
    }

    @PreAuthorize("hasAnyAuthority('user','admin','employee')")
    @GetMapping("/site/Sale")
    public String saleIndex() {
        return "site/Sale";
    }

    @PreAuthorize("hasAnyAuthority('user','admin','employee')")
    @GetMapping("/site/Contacts")
    public String contactsIndex() {
        return "site/Contacts";
    }

    @PreAuthorize("hasAnyAuthority('user','admin','employee')")
    @GetMapping("/site/History")
    public String historyIndex() {
        return "site/History";
    }

    @PreAuthorize("hasAnyAuthority('user','admin','employee')")
    @GetMapping("/site/Jobs")
    public String jobsIndex() {
        return "site/Jobs";
    }



}


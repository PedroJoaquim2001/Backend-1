package com.SpringTest.Teste.controller;

import com.SpringTest.Teste.services.CultureService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/culture")
public class CultureController {
    final CultureService cultureService;

    public CultureController(CultureService cultureService) {this.cultureService = cultureService;}
}

package com.SpringTest.Teste.controller;

import com.SpringTest.Teste.controller.dto.AdminsDto;
import com.SpringTest.Teste.models.Admins;
import com.SpringTest.Teste.repositories.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AdminsSearch {
    @Autowired
    private AdminRepository adminRepository;
    @RequestMapping("/searchid")
    public List<AdminsDto> list(String nameSearch){
        if(nameSearch == null){
            List<Admins> admins = adminRepository.findAll();
            System.out.println("Admin not found");
            return AdminsDto.convert(admins);
        }else{
            List<Admins> admins = adminRepository.findByName(nameSearch);
            return AdminsDto.convert(admins);
        }

    }

}

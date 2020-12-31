package com.mymail.project.mailproject.controller;


import com.mymail.project.mailproject.model.MailEntity;
import com.mymail.project.mailproject.model.MailRequestDTO;
import com.mymail.project.mailproject.model.MailResponseDTO;
import com.mymail.project.mailproject.service.MailSenderService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value="/mail")
@AllArgsConstructor
public class MailController {

    MailSenderService mailSenderService;

    @PostMapping("/send")
    public MailResponseDTO sendMail(@RequestBody MailRequestDTO requestBody){
        return mailSenderService.sendMail(requestBody);
    }

    @GetMapping("/alive")
    public String isAlive(){
        return "Estou vivo";
    }
}

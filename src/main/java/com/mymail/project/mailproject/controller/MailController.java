package com.mymail.project.mailproject.controller;


import com.mymail.project.mailproject.model.MailRequestDTO;
import com.mymail.project.mailproject.model.MailResponseDTO;
import com.mymail.project.mailproject.service.IMailSenderService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value="/mail")
@AllArgsConstructor
public class MailController {


    IMailSenderService mailSenderServiceImpl;

    @PostMapping("/send")
    public MailResponseDTO sendMail(@RequestBody MailRequestDTO requestBody){
        return mailSenderServiceImpl.sendMail(requestBody);
    }

    @GetMapping("/alive")
    public String isAlive(){
        return "I'm alive !";
    }


    @GetMapping("/emails/{destination}")
    public List<MailResponseDTO> getEmailsTo(@PathVariable(value="destination") String destination){

        return mailSenderServiceImpl.getMailsByMailTo(destination);
    }

    @GetMapping("/emails/{destination}/{sender}")
    public List<MailResponseDTO> getEmailsFromAndTo(@PathVariable String destination,@PathVariable String sender){

        return mailSenderServiceImpl.getMailsByMailToFromTo(destination, sender);
    }
}

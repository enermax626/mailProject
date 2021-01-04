package com.mymail.project.mailproject.controller;


import com.mymail.project.mailproject.model.MailRequestDTO;
import com.mymail.project.mailproject.model.MailResponseDTO;
import com.mymail.project.mailproject.service.IMailSenderService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@AllArgsConstructor
@Controller
@RequestMapping(value="/interface")
public class InterfaceController {

    IMailSenderService mailSenderServiceImpl;

    @GetMapping("/home")
    public String mailForm(Model model) {
        model.addAttribute("mailRequest",new MailRequestDTO());
        return "mailform";
    }

    @PostMapping("/home")
    public String sendMail(@ModelAttribute MailRequestDTO mail, Model model) {

        MailResponseDTO response = mailSenderServiceImpl.sendMail(mail);
        if(response == null)
            return "error";

        model.addAttribute("mailResponseDto",response);
        return "mailresponse";
    }

}

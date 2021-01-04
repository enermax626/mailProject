package com.mymail.project.mailproject.service;

import com.mymail.project.mailproject.model.MailEntity;
import com.mymail.project.mailproject.model.MailRequestDTO;
import com.mymail.project.mailproject.model.MailResponseDTO;
import com.mymail.project.mailproject.repository.MailRepository;

import java.util.List;

public interface IMailSenderService {

    MailResponseDTO sendMail(MailRequestDTO request);

    MailEntity getMailEntity(MailRequestDTO mailRequest);

    MailResponseDTO getMailDTO(MailEntity mail);

    List<MailResponseDTO> getMailsByMailTo(String to);

    List<MailResponseDTO> getMailsByMailToFromTo(String to, String from);

    public static boolean isValidMail(String mail){
        return mail.contains("@") && mail.contains(".");
    }
}

package com.mymail.project.mailproject.service.impl;

import com.mymail.project.mailproject.model.MailEntity;
import com.mymail.project.mailproject.model.MailPK;
import com.mymail.project.mailproject.model.MailRequestDTO;
import com.mymail.project.mailproject.model.MailResponseDTO;
import com.mymail.project.mailproject.repository.MailRepository;
import com.mymail.project.mailproject.service.IMailSenderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class MailSenderServiceImpl implements IMailSenderService {

    @Autowired
    MailRepository mailRepository;
    @Autowired
    private JavaMailSender mailSender;




    public MailResponseDTO sendMail(MailRequestDTO request){

        if(!IMailSenderService.isValidMail(request.getMailTo()))
            return null;

        MailEntity mail = this.getMailEntity(request);

        try {
            SimpleMailMessage message = new SimpleMailMessage();
            message.setTo(mail.getId().getMailTo());
            message.setSubject("Mail Application message");
            message.setText(mail.getBody());
            mailSender.send(message);
        } catch (MailException m){
            System.out.println("Erro no envio do e-mail, enviando log de erro..");
            return null;
        }
        MailEntity mailResponse = mailRepository.save(mail);
        return this.getMailDTO(mailResponse);
    }

    public List<MailResponseDTO> getMailsByMailTo(String to){
        if(!IMailSenderService.isValidMail(to))
            return Collections.EMPTY_LIST;

        List<MailEntity> mails = mailRepository.findAllByIdMailTo(to);
        return mails.stream().map(this::getMailDTO).collect(Collectors.toList());

    }

    public List<MailResponseDTO> getMailsByMailToFromTo(String to, String from){
        if(!IMailSenderService.isValidMail(to) || !IMailSenderService.isValidMail(from))
            return Collections.EMPTY_LIST;

        List<MailEntity> mails = mailRepository.findAllByIdMailToAndIdMailFrom(to,from);
        return mails.stream().map(this::getMailDTO).collect(Collectors.toList());

    }


    public MailEntity getMailEntity(MailRequestDTO mailRequest){
        MailEntity mail = new MailEntity();
        MailPK mailPk = new MailPK();
        Integer randomId = (((int)(Math.random() * (40000 - 1 + 1) + 1)));
        mailPk.setId(randomId.toString());
        mailPk.setMailFrom("mymailapplication626@gmail.com");
        mailPk.setMailTo(mailRequest.getMailTo());
        mailPk.setTimestamp(new Date());
        mail.setId(mailPk);
        mail.setBody(mailRequest.getBody());
        return mail;
    }

    public MailResponseDTO getMailDTO(MailEntity mail){
        MailResponseDTO mailDto = new MailResponseDTO();
        mailDto.setBody(mail.getBody());
        mailDto.setMailTo(mail.getId().getMailTo());
        mailDto.setId(mail.getId().getId());
        mailDto.setTimestamp(mail.getId().getTimestamp());
        mailDto.setMailFrom(mail.getId().getMailFrom());

        return mailDto;

    }




}

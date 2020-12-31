package com.mymail.project.mailproject.service;

import com.mymail.project.mailproject.model.MailEntity;
import com.mymail.project.mailproject.model.MailPK;
import com.mymail.project.mailproject.model.MailRequestDTO;
import com.mymail.project.mailproject.model.MailResponseDTO;
import com.mymail.project.mailproject.repository.MailRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Time;
import java.time.LocalDateTime;
import java.util.Date;

@Service
@AllArgsConstructor
public class MailSenderService {

    private MailRepository mailRepository;

    public MailResponseDTO sendMail(MailRequestDTO request){
        MailPK mpk = new MailPK(request.getTo(),"murilomail626@gmail.com",new Date(),request.getId());
        MailEntity mail = new MailEntity(mpk, request.getBody());
        MailEntity mailResponse = mailRepository.save(mail);

        return new MailResponseDTO(mailResponse.getId().getTo(),mailResponse.getId().getFrom(),mailResponse.getId().getTimestamp(),mailResponse.getId().getId(),mailResponse.getBody());
    }

}

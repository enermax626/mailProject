package com.mymail.project.mailproject.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MailResponseDTO {
    private String mailTo;
    private String mailFrom;
    private Date timestamp;
    private String id;
    private String body;
}

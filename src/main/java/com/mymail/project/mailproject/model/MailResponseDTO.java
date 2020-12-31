package com.mymail.project.mailproject.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.Date;

@Data
@AllArgsConstructor
public class MailResponseDTO {
    private String to;
    private String from;
    private Date timestamp;
    private String id;
    private String body;
}

package com.mymail.project.mailproject.model;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.Date;

@Data
public class MailRequestDTO {
    private String to;
    private String id;
    private String body;
}

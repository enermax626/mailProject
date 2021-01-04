package com.mymail.project.mailproject.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Date;

@Data
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class MailPK implements Serializable {
    private String mailTo;
    private String mailFrom;
    private Date timestamp;
    private String id;


}

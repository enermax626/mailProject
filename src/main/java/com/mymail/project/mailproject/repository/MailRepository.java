package com.mymail.project.mailproject.repository;

import com.mymail.project.mailproject.model.MailEntity;
import com.mymail.project.mailproject.model.MailPK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MailRepository extends JpaRepository<MailEntity, MailPK> {

    public MailEntity save(MailPK mailpk);

    public List<MailEntity> get(String to);

    public List<MailEntity> get(String to, String from);
}

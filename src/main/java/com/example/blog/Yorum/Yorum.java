package com.example.blog.Yorum;

import com.example.blog.Blog.Blog;
import com.example.blog.ortak.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import java.util.Date;


@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@SequenceGenerator(initialValue = 1, name = "idGenerator", sequenceName = "yorumSequence")
public class Yorum extends BaseEntity {

    private String ad;
    private String soyad;
    private String metin;
    private Date tarih;
    private String eposta;

    @ManyToOne
    private Blog blog;



}

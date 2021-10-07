package com.example.blog.Yorum;

import com.example.blog.ortak.BaseDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class YorumDTO extends BaseDTO {

    private String ad;
    private String soyad;
    private Date tarih;
    private String eposta;
    private String metin;
}

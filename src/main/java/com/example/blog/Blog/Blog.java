package com.example.blog.Blog;
import com.example.blog.Etiket.Etiket;
import com.example.blog.Kategori.Kategori;
import com.example.blog.Resim.Resim;
import com.example.blog.Yorum.Yorum;
import com.example.blog.ortak.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@SequenceGenerator(initialValue = 1, name = "idGenerator", sequenceName = "blogSequence" ,allocationSize = 1)
public class Blog extends BaseEntity {

    private String baslik;
    private String icerik;
    private Date tarih;

    @OneToMany
    private List<Yorum> yorum;

    @ManyToMany
    private List<Kategori> kategori;

    @ManyToMany
    private List<Etiket> etiket;

    @ManyToOne
    private Resim resim;


}

package com.example.blog.Kategori;

import com.example.blog.Blog.Blog;
import com.example.blog.ortak.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import java.util.List;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@SequenceGenerator(initialValue = 1, name = "idGenerator", sequenceName = "kategoriSequence")
public class Kategori extends BaseEntity {

    private String kategoriAd;

    @ManyToMany(mappedBy = "kategori")
    private List<Blog> blog;




}

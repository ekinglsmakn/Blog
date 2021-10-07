package com.example.blog.Resim;
import com.example.blog.Blog.Blog;
import com.example.blog.ortak.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import java.util.List;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@SequenceGenerator(initialValue = 1, name = "idGenerator", sequenceName = "blogSequence" ,allocationSize = 1)
public class Resim extends BaseEntity {

    private  String Yol;

    @OneToMany
    private List<Blog> blog;

}

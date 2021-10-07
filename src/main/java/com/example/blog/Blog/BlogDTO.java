package com.example.blog.Blog;

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
public class BlogDTO extends BaseDTO {

    private String baslik;
    private String icerik;
    private Date tarih;

   // private List<KategoriDTO> kategori; //Blog Entitisine  veri girilirken mutlaka kategoriye de girilmelidir.(öyle ayarladık)

}

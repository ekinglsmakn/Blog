package com.example.blog.Blog;
import java.util.List;

public interface IBlogService {

  BlogDTO kaydet(BlogDTO blogDTO);
  BlogDTO duzenle(BlogDTO blogDTO);
  String sil(Long id);
  List<BlogDTO> tumunuGetir();
  BlogDTO idyeGoreGetir(Long id);

}

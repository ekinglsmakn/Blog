package com.example.blog.Yorum;


import java.util.List;

public interface IYorumService {

    YorumDTO kaydet(YorumDTO yorumDTO);
    YorumDTO duzenle(YorumDTO yorumDTO);
    String sil(Long id);
    List<YorumDTO> tumunuGetir();
    YorumDTO idyeGoreGetir(Long id);

}

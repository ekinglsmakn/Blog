package com.example.blog.Resim;
import java.util.List;

public interface IResimService {

    ResimDTO kaydet(ResimDTO resimDTO);
    ResimDTO duzenle(ResimDTO resimDTO);
    String sil(Long id);
    List<ResimDTO> tumunuGetir();
    ResimDTO idyeGoreGetir(Long id);

}

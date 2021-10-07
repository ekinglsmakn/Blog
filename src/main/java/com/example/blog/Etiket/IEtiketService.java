package com.example.blog.Etiket;

import java.util.List;

public interface IEtiketService {
    EtiketDTO kaydet(EtiketDTO etiketDTO);
    EtiketDTO duzenle(EtiketDTO etiketDTO);
    String sil(Long id);
    List<EtiketDTO> tumunuGetir();
    EtiketDTO idyeGoreGetir(Long id);
}

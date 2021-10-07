package com.example.blog.Kategori;

import java.util.List;

public interface IKategoriService {

    KategoriDTO kaydet(KategoriDTO kategoriDTO);
    KategoriDTO duzenle(KategoriDTO kategoriDTO);
    String sil(Long id);
    List<KategoriDTO> tumunuGetir( );

    KategoriDTO idyeGoreGetir(Long id);

}

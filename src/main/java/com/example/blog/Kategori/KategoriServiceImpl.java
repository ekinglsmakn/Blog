package com.example.blog.Kategori;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Service(value = "kategori")
public class KategoriServiceImpl implements IKategoriService{

    private IKategoriRepo kategoriRepo;
    private ModelMapper modelMapper;

    @Autowired
    public KategoriServiceImpl(IKategoriRepo kategoriRepo, ModelMapper modelMapper){ //Constructor

        this.kategoriRepo=kategoriRepo;
        this.modelMapper=modelMapper;
    }

    /*Kaydet metodu DTO cinsinden değer alır. Geriye yine DTO döndürür.
     *Ancak aradaki dönüşüm işlemlerini yapabilmek için modelmapper.map kullanırız.
     */

    @Transactional(rollbackFor = Exception.class)
    @Override
    public KategoriDTO kaydet(KategoriDTO kategoriDTO) {

        //DTO cinsinden alınan değer entity'ye atanabilmek için Kategori.class metodu ile maplenir.
        Kategori kategori = modelMapper.map(kategoriDTO,Kategori.class);

        return modelMapper.map(kategoriRepo.save(kategori),KategoriDTO.class);
        //kategoriRepoya kaydedebilmek için Entity'ye çevirmek gerekir.
        //Kaydedildikten sonra yine DTO'ya çevrilmelidir.ç
        //En son değer kategoriRepo-->BaseEntityRepo yolu üzerinden veri tabanına gider.

    }
    @Transactional(rollbackFor = Exception.class)
    @Override
    public KategoriDTO duzenle(KategoriDTO kategoriDTO) {

        Kategori kategori = kategoriRepo.getOne(kategoriDTO.getId());
        kategori.setKategoriAd(kategoriDTO.getKategoriAd());
        return modelMapper.map(kategoriRepo.save(kategori), KategoriDTO.class);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public String sil(Long id) {

        kategoriRepo.deleteById(id);

        if(kategoriRepo==null){
            return "Silme işlemi başarili";
        }
        else{
            return "Silme işlemi başarısız";
        }

    }


    @Transactional(readOnly = true)
    @Override
    public List<KategoriDTO> tumunuGetir() {

        return modelMapper.map(kategoriRepo.findAll(), new TypeToken<List<KategoriDTO>>(){}.getType());
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public KategoriDTO idyeGoreGetir(Long id) {


        return modelMapper.map(kategoriRepo.getOne(id), KategoriDTO.class);

    }
}

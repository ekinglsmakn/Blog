package com.example.blog.Etiket;
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
@Service(value = "etiket")
public class EtiketServiceImpl implements IEtiketService{

    private IEtiketRepo etiketRepo;
    private ModelMapper modelMapper;

    @Autowired
    public EtiketServiceImpl(IEtiketRepo etiketRepo, ModelMapper modelMapper){

        this.etiketRepo=etiketRepo;
        this.modelMapper=modelMapper;

    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public EtiketDTO kaydet(EtiketDTO etiketDTO) {
        Etiket etiket= modelMapper.map(etiketDTO, Etiket.class);
        return modelMapper.map(etiketRepo.save(etiket), EtiketDTO.class);

    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public EtiketDTO duzenle(EtiketDTO etiketDTO) {

        Etiket etiket = etiketRepo.getOne(etiketDTO.getId()); //güncelleyeceğimiz verinin id'sini alıp veri tabanıyla karşılaştırdık
        etiket.setAd( etiketDTO.getAd() ); //başlığı değiştirdik
        return modelMapper.map(etiketRepo.save(etiket),EtiketDTO.class); //save edip mapledik
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public String sil(Long id) { //id'ye göre silme işlemi olduğu için DTO cinsinden yazmadık

        etiketRepo.deleteById(id);

        if(etiketRepo==null){
            return "Silme işlemi başarili";
        }
        else{
            return "Silme işlemi başarısız";
        }

    }
    @Transactional(readOnly = true)
    @Override
    public List<EtiketDTO> tumunuGetir(){ //id'ye göre tüm bilgileri getirir.

        return modelMapper.map(etiketRepo.findAll(), new TypeToken<List<EtiketDTO>>(){}.getType());

    }
    @Transactional(rollbackFor = Exception.class)
    @Override
    public EtiketDTO idyeGoreGetir(Long id) {

        return modelMapper.map(etiketRepo.getOne(id), EtiketDTO.class);

    }

}

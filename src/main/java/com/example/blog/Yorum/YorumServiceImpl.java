package com.example.blog.Yorum;
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
@Service(value = "yorum")
public class YorumServiceImpl implements IYorumService{

    private IYorumRepo yorumRepo;
    private ModelMapper modelMapper;

    @Autowired
    public YorumServiceImpl(IYorumRepo yorumRepo, ModelMapper modelMapper){

        this.yorumRepo=yorumRepo;
        this.modelMapper=modelMapper;

    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public YorumDTO kaydet(YorumDTO yorumDTO) {
        Yorum yorum= modelMapper.map(yorumDTO, Yorum.class);
        return modelMapper.map(  yorumRepo.save( yorum ), YorumDTO.class  );

    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public YorumDTO duzenle(YorumDTO yorumDTO) {

        Yorum yorum = yorumRepo.getOne(yorumDTO.getId()); //güncelleyeceğimiz verinin id'sini alıp veri tabanıyla karşılaştırdık
        yorum.setAd( yorumDTO.getAd() ); //başlığı değiştirdik
        yorum.setSoyad( yorumDTO.getSoyad() );
        yorum.setTarih( yorumDTO.getTarih() );
        yorum.setMetin( yorumDTO.getMetin() );

        return modelMapper.map(yorumRepo.save(yorum),YorumDTO.class); //save edip mapledik
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public String sil(Long id) { //id'ye göre silme işlemi olduğu için DTO cinsinden yazmadık

        yorumRepo.deleteById(id);

        if(yorumRepo==null){
            return "Silme işlemi başarili";
        }
        else{
            return "Silme işlemi başarısız";
        }

    }
    @Transactional(readOnly = true)
    @Override
    public List<YorumDTO> tumunuGetir(){ //id'ye göre tüm bilgileri getirir.

        return modelMapper.map(yorumRepo.findAll(), new TypeToken<List<YorumDTO>>(){}.getType());

    }
    @Transactional(rollbackFor = Exception.class)
    @Override
    public YorumDTO idyeGoreGetir(Long id) {

        return modelMapper.map(yorumRepo.getOne(id), YorumDTO.class);

    }

}

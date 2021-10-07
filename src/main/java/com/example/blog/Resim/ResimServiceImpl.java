package com.example.blog.Resim;

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
@Service(value = "resim")
public class ResimServiceImpl implements IResimService{
    private IResimRepo iResimRepo;
    private ModelMapper modelMapper;

    @Autowired
    public ResimServiceImpl(IResimRepo iResimRepo, ModelMapper modelMapper){
        this.iResimRepo=iResimRepo;
        this.modelMapper=modelMapper;
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public ResimDTO kaydet(ResimDTO resimDTO) {

        Resim resim = modelMapper.map(resimDTO,Resim.class);
        return modelMapper.map(iResimRepo.save(resim),ResimDTO.class);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public ResimDTO duzenle(ResimDTO resimDTO) {
        Resim resim = iResimRepo.getOne(resimDTO.getId());
        resim.setYol(resimDTO.getYol());

        return modelMapper.map(iResimRepo.save(resim),ResimDTO.class);

    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public String sil(Long id) {
       iResimRepo.deleteById(id);
        if(iResimRepo.getOne(id)==null){
            return "Silme işlemi başarili";
        }
        else{
            return "Silme işlemi başarısız";
        }
    }

    @Transactional(readOnly = true)
    @Override
    public List<ResimDTO> tumunuGetir() {
        return modelMapper.map(iResimRepo.findAll(), new TypeToken<List<ResimDTO>>(){}.getType());
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public ResimDTO idyeGoreGetir(Long id) {

        return modelMapper.map(iResimRepo.getOne(id),ResimDTO.class);

//
    }
}

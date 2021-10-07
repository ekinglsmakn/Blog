package com.example.blog.Blog;

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
@Service(value = "blog")
public class BlogServiceImpl implements IBlogService{

    private IBlogRepo blogRepo;
    private ModelMapper modelMapper;

    @Autowired
    public BlogServiceImpl(IBlogRepo blogRepo, ModelMapper modelMapper){
        this.modelMapper=modelMapper;
        this.blogRepo=blogRepo;

    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public BlogDTO kaydet(BlogDTO blogDTO) {

        Blog blog= modelMapper.map(blogDTO, Blog.class);
        return modelMapper.map(  blogRepo.save( blog ), BlogDTO.class  );

    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public BlogDTO duzenle(BlogDTO blogDTO) {

        Blog blog = blogRepo.getOne(blogDTO.getId()); //güncelleyeceğimiz verinin id'sini alıp veri tabanıyla karşılaştırdık
        blog.setBaslik( blogDTO.getBaslik()); //başlığı değiştirdik
        blog.setIcerik( blogDTO.getIcerik());
        blog.setTarih( blogDTO.getTarih());

        return modelMapper.map(blogRepo.save(blog),BlogDTO.class); //save edip mapledik
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public String sil(Long id) { //id'ye göre silme işlemi olduğu için DTO cinsinden yazmadık

        blogRepo.deleteById(id);

        if(blogRepo.getOne(id)==null){
            return "Silme işlemi başarili";
        }
        else{
            return "Silme işlemi başarısız";
        }

    }
    @Transactional(readOnly = true)
    @Override
    public List<BlogDTO> tumunuGetir(){ //id'ye göre tüm bilgileri getirir.

        return modelMapper.map(blogRepo.findAll(), new TypeToken<List<BlogDTO>>(){}.getType());

    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public BlogDTO idyeGoreGetir(Long id) {

        return modelMapper.map(blogRepo.getOne(id), BlogDTO.class);

    }

}

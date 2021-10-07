package com.example.blog.Blog;
import com.example.blog.ortak.BaseResponse;
import com.example.blog.ortak.Util;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/api/blog")
@RestController
public class BlogController {
    private IBlogService blogService;

    public BlogController(IBlogService blogService){ //kontroller

        this.blogService=blogService;
    }

    @RequestMapping(value="/kaydet",method = RequestMethod.POST)
    public BaseResponse kaydet(@RequestBody BlogDTO blogDTO ){

      try{
        return Util.islemSonucGetir(blogService.kaydet(blogDTO));
      }
      catch (Exception e){
        return Util.islemSonucGetir(e);
      }
    }

    @RequestMapping(value="/duzenle",method = RequestMethod.PUT) //guncellemede PUT kullanılır
    public BaseResponse duzenle(@RequestBody BlogDTO blogDTO ){

        try{
            return Util.islemSonucGetir(blogService.duzenle(blogDTO));
        }
        catch (Exception e){
            return Util.islemSonucGetir(e);
        }
    }

    @RequestMapping(value="/sil/{id}",method = RequestMethod.DELETE)
    public BaseResponse sil(@PathVariable Long id){

        try{
            return Util.islemSonucGetir(blogService.sil(id));
        }
        catch (Exception e){
            return Util.islemSonucGetir(e);
        }
    }

    @RequestMapping(value="/tumunuGetir",method = RequestMethod.GET)
    public BaseResponse tumunuGetir(){

        try{
            return Util.islemSonucGetir(blogService.tumunuGetir());
        }
        catch (Exception e){
            return Util.islemSonucGetir(e);
        }
    }

    @RequestMapping(value="/idyeGoreGetir/{id}",method = RequestMethod.GET)
    public BaseResponse idyeGoreGetir(@PathVariable Long id){

        try{
            return Util.islemSonucGetir(blogService.idyeGoreGetir(id));
        }
        catch (Exception e){
            return Util.islemSonucGetir(e);
        }

    }

}

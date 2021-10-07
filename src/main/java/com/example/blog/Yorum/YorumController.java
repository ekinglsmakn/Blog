package com.example.blog.Yorum;
import com.example.blog.ortak.BaseResponse;
import com.example.blog.ortak.Util;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/api/yorum")
@RestController
public class YorumController {

    private IYorumService yorumService;

    public YorumController(IYorumService yorumService){ //kontroller

        this.yorumService=yorumService;
    }

    @RequestMapping(value="/kaydet",method = RequestMethod.POST)
    public BaseResponse kaydet(@RequestBody YorumDTO yorumDTO ){

        try{
            return Util.islemSonucGetir(yorumService.kaydet(yorumDTO));
        }
        catch (Exception e){
            return Util.islemSonucGetir(e);
        }
    }

    @RequestMapping(value="/duzenle",method = RequestMethod.PUT) //guncellemede PUT kullanılır
    public BaseResponse duzenle(@RequestBody YorumDTO yorumDTO ){

        try{
            return Util.islemSonucGetir(yorumService.duzenle(yorumDTO));
        }
        catch (Exception e){
            return Util.islemSonucGetir(e);
        }
    }

    @RequestMapping(value="/sil/{id}",method = RequestMethod.DELETE)
    public BaseResponse sil(@PathVariable Long id){

        try{
            return Util.islemSonucGetir(yorumService.sil(id));
        }
        catch (Exception e){
            return Util.islemSonucGetir(e);
        }
    }

    @RequestMapping(value="/tumunuGetir",method = RequestMethod.GET)
    public BaseResponse tumunuGetir(){

        try{
            return Util.islemSonucGetir(yorumService.tumunuGetir());
        }
        catch (Exception e){
            return Util.islemSonucGetir(e);
        }
    }

    @RequestMapping(value="/idyeGoreGetir/{id}",method = RequestMethod.GET)
    public BaseResponse idyeGoreGetir(@PathVariable Long id){

        try{
            return Util.islemSonucGetir(yorumService.idyeGoreGetir(id));
        }
        catch (Exception e){
            return Util.islemSonucGetir(e);
        }

    }
}

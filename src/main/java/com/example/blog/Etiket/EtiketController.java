package com.example.blog.Etiket;
import com.example.blog.ortak.BaseResponse;
import com.example.blog.ortak.Util;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/api/etiket")
@RestController
public class EtiketController {

    private IEtiketService etiketService;

    public EtiketController(IEtiketService etiketService){ //kontroller

        this.etiketService=etiketService;
    }

    @RequestMapping(value="/kaydet",method = RequestMethod.POST)
    public BaseResponse kaydet(@RequestBody EtiketDTO etiketDTO ){

        try{
            return Util.islemSonucGetir(etiketService.kaydet(etiketDTO));
        }
        catch (Exception e){
            return Util.islemSonucGetir(e);
        }
    }

    @RequestMapping(value="/duzenle",method = RequestMethod.PUT) //guncellemede PUT kullanılır
    public BaseResponse duzenle(@RequestBody EtiketDTO etiketDTO){

        try{
            return Util.islemSonucGetir(etiketService.duzenle(etiketDTO));
        }
        catch (Exception e){
            return Util.islemSonucGetir(e);
        }
    }

    @RequestMapping(value="/sil/{id}",method = RequestMethod.DELETE)
    public BaseResponse sil(@PathVariable Long id){

        try{
            return Util.islemSonucGetir(etiketService.sil(id));
        }
        catch (Exception e){
            return Util.islemSonucGetir(e);
        }
    }

    @RequestMapping(value="/tumunuGetir",method = RequestMethod.GET)
    public BaseResponse tumunuGetir(){

        try{
            return Util.islemSonucGetir(etiketService.tumunuGetir());
        }
        catch (Exception e){
            return Util.islemSonucGetir(e);
        }
    }
    @RequestMapping(value="/idyeGoreGetir/{id}",method = RequestMethod.GET)
    public BaseResponse idyeGoreGetir(@PathVariable Long id){

        try{
            return Util.islemSonucGetir(etiketService.idyeGoreGetir(id));
        }
        catch (Exception e){
            return Util.islemSonucGetir(e);
        }

    }
}

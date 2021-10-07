package com.example.blog.Resim;

import com.example.blog.ortak.BaseResponse;
import com.example.blog.ortak.Util;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/api/resim")
@RestController
public class ResimController {
    private IResimService resimService;

    public ResimController(IResimService resimService){
        this.resimService=resimService;
    }

    @RequestMapping(value="/kaydet",method = RequestMethod.POST)
    public BaseResponse kaydet(@RequestBody ResimDTO resimDTO){
        try{
            return Util.islemSonucGetir(resimService.kaydet(resimDTO));
        }
        catch (Exception e){
            return Util.islemSonucGetir(e);
        }
    }

    @RequestMapping(value="/duzenle",method = RequestMethod.PUT)
    public BaseResponse duzenle(@RequestBody ResimDTO resimDTO){
        try{
            return Util.islemSonucGetir(resimService.duzenle(resimDTO));
        }
        catch (Exception e){
            return Util.islemSonucGetir(e);
        }
    }

    @RequestMapping(value="/sil/{id}",method = RequestMethod.DELETE)
    public BaseResponse sil(@PathVariable Long id){
        try{
            return Util.islemSonucGetir(resimService.sil(id));
        }
        catch (Exception e){
            return Util.islemSonucGetir(e);
        }
    }


    @RequestMapping(value="/tumunuGetir",method = RequestMethod.GET)
    public BaseResponse tumunuGetir(){
        try{
            return Util.islemSonucGetir(resimService.tumunuGetir());
        }
        catch (Exception e){
            return Util.islemSonucGetir(e);
        }
    }

    @RequestMapping(value="/idyeGoreGetir/{id}",method = RequestMethod.GET)
    public BaseResponse idyeGoreGetir(@PathVariable Long id){
        try{
            return Util.islemSonucGetir(resimService.idyeGoreGetir(id));
        }
        catch (Exception e){
            return Util.islemSonucGetir(e);
        }
    }

}

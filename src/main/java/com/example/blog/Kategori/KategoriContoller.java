package com.example.blog.Kategori;
import com.example.blog.ortak.BaseResponse;
import com.example.blog.ortak.Util;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/api/kategori")
@RestController
public class KategoriContoller {

    private IKategoriService kategoriService;

    public KategoriContoller(IKategoriService kategoriService){ //kontroller

        this.kategoriService=kategoriService;
    }

    @RequestMapping(value="/kaydet",method = RequestMethod.POST)
    public BaseResponse kaydet(@RequestBody KategoriDTO kategoriDTO ){

        try{
            return Util.islemSonucGetir(kategoriService.kaydet(kategoriDTO));
        }
        catch (Exception e){
            return Util.islemSonucGetir(e);
        }
    }

    @RequestMapping(value="/duzenle",method = RequestMethod.PUT) //guncellemede PUT kullanılır
    public BaseResponse duzenle(@RequestBody KategoriDTO kategoriDTO ){

        try{
            return Util.islemSonucGetir(kategoriService.duzenle(kategoriDTO));
        }
        catch (Exception e){
            return Util.islemSonucGetir(e);
        }
    }

    @RequestMapping(value="/sil/{id}",method = RequestMethod.DELETE)
    public BaseResponse sil(@PathVariable Long id){

        try{
            return Util.islemSonucGetir(kategoriService.sil(id));
        }
        catch (Exception e){
            return Util.islemSonucGetir(e);
        }
    }

    @RequestMapping(value="/tumunuGetir",method = RequestMethod.GET)
    public BaseResponse tumunuGetir(){

        try{
            return Util.islemSonucGetir(kategoriService.tumunuGetir());
        }
        catch (Exception e){
            return Util.islemSonucGetir(e);
        }
    }
    @RequestMapping(value="/idyeGoreGetir/{id}",method = RequestMethod.GET)
    public BaseResponse idyeGoreGetir(@PathVariable Long id){

        try{
            return Util.islemSonucGetir(kategoriService.idyeGoreGetir(id));
        }
        catch (Exception e){
            return Util.islemSonucGetir(e);
        }

    }
}

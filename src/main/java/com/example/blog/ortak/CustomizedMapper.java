/*
Bu doküman'ın tüm kullanım hakları Peerlog Bilişim A.Ş. ye aittir.
İzinsiz incelenmesi, çoğaltılması, dağıtılması yasaktır.
emre.basakcioglu tarafından 04/02/2020 tarihinde sevgiyle oluşturuldu.
İlk paket adı: tr.com.peerlog.gdpr.config
*/
package com.example.blog.ortak;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.lang.reflect.Type;

@Component
public class CustomizedMapper extends ModelMapper {


    @Override
    public <D> D map(Object source, Type destinationType) {
        if (source == null) {
            return null;
        } else {
            return super.map(source, destinationType);
        }
    }

    @Override
    public <D> D map(Object source, Class<D> destinationType) {
        if (source == null) {
            return null;
        } else {
            return super.map(source, destinationType);
        }
    }

}

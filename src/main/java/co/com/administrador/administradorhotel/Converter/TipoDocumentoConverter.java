package co.com.administrador.administradorhotel.Converter;

import co.com.administrador.administradorhotel.Domain.TipoDocumento;
import co.com.administrador.administradorhotel.Entity.TipoDocumentoEntity;
import org.springframework.stereotype.Component;


import java.util.ArrayList;

import java.util.List;
import java.util.Optional;
@Component
public class TipoDocumentoConverter {

    public TipoDocumento entityToModel(TipoDocumentoEntity tipoDocumentoEntity){
        TipoDocumento tipoDocumento = new TipoDocumento();
        tipoDocumento.setId(tipoDocumentoEntity.getId());
        tipoDocumento.setNombre(tipoDocumentoEntity.getNombre());
        return tipoDocumento;
    }

    public TipoDocumentoEntity modelToEntity(TipoDocumento tipoDocumento){
        TipoDocumentoEntity tipoDocumentoEntity = new TipoDocumentoEntity();
        tipoDocumentoEntity.setId(tipoDocumento.getId());
        tipoDocumentoEntity.setNombre(tipoDocumento.getNombre());
        return tipoDocumentoEntity;
    }

    public List<TipoDocumento> entityToModel(List<TipoDocumentoEntity> tipoDocumentoEntity) {
        List<TipoDocumento> tiposDocumento = new ArrayList<>(tipoDocumentoEntity.size());
        tipoDocumentoEntity.forEach(entity -> {
            tiposDocumento.add(entityToModel(entity));
        });
        return tiposDocumento;
    }

    public TipoDocumento entityToModel(Optional<TipoDocumentoEntity> tipoDocumentoEntity) {
        TipoDocumento tipoDocumento = null;
        if (tipoDocumentoEntity.isPresent()) {
            tipoDocumento = new TipoDocumento();
            tipoDocumento.setId(tipoDocumentoEntity.get().getId());
            tipoDocumento.setNombre(tipoDocumentoEntity.get().getNombre());

            return tipoDocumento;
        }
        return tipoDocumento;
    }
}

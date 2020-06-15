package co.com.administrador.administradorhotel.Service.tipodocumento.impl;

import co.com.administrador.administradorhotel.Converter.TipoDocumentoConverter;
import co.com.administrador.administradorhotel.Domain.TipoDocumento;
import co.com.administrador.administradorhotel.Repository.TipoDocumentoRepository;
import co.com.administrador.administradorhotel.Service.tipodocumento.TipoDocumentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class TipoDocumentoServiceImpl implements TipoDocumentoService {

    @Autowired
    private TipoDocumentoRepository tipoDocumentoRepository;
    @Autowired
    private TipoDocumentoConverter tipoDocumentoConverter;
    @Override
    public List<TipoDocumento> findAll() {
        return tipoDocumentoConverter.entityToModel(tipoDocumentoRepository.findAll());
    }
}

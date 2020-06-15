package co.com.administrador.administradorhotel.Controller;

import co.com.administrador.administradorhotel.Domain.TipoDocumento;
import co.com.administrador.administradorhotel.Service.tipodocumento.TipoDocumentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/tipodocumentos")
public class TipoDocumentoController {

    @Autowired
    private TipoDocumentoService tipoDocumentoService;
    @GetMapping("/tipoDocumento")
    public List<TipoDocumento> findAll(){
        return tipoDocumentoService.findAll();
    }
}

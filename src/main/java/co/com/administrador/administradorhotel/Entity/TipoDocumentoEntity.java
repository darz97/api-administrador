package co.com.administrador.administradorhotel.Entity;

import co.com.administrador.administradorhotel.Domain.TipoDocumento;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name="tipodocumento")
public class TipoDocumentoEntity extends TipoDocumento {
    @Id
    @Column (name="id")
    private Long id;
    @Column (name="nombre")
    private String nombre;



}

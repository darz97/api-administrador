package co.com.administrador.administradorhotel.Entity;

import co.com.administrador.administradorhotel.Domain.Empleado;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name ="empleado")
public class EmpleadoEntity extends Empleado {
    @Id
    @Column(name="numeroDocumento")
    private String numeroDocumento;
    @Column(name="nombre")
    private String nombre;
    @Column(name="apellido")
    private String apellido;
    @Column(name="correo")
    private String correo;
    @ManyToOne(cascade={CascadeType.PERSIST})
    @JoinColumn(name="idtipodocumento")

    private TipoDocumentoEntity tipoDocumentoEntity;
    @ManyToOne(cascade={CascadeType.PERSIST})
    @JoinColumn(name="idcargo")
    private CargoEntity cargoEntity;
    @Column(name="estado_contrato")
    private String estadoContrato;


    public TipoDocumentoEntity getTipoDocumentoEntity() {
        if(tipoDocumentoEntity == null){
            tipoDocumentoEntity = new TipoDocumentoEntity();
        }
        return tipoDocumentoEntity;
    }

    public CargoEntity getCargoEntity() {
        if(cargoEntity == null){
            cargoEntity = new CargoEntity();
        }
        return cargoEntity;
    }
}

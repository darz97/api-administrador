package co.com.administrador.administradorhotel.Domain;

import lombok.Data;

@Data
public class Empleado {
    private String numeroDocumento;
    private String nombre;
    private String apellido;
    private String correo;
    private TipoDocumento tipoDocumento;
    private Cargo cargo;
    private String estadoContrato;

    public TipoDocumento getTipoDocumento() {
        if(tipoDocumento == null){
            tipoDocumento = new TipoDocumento();
        }
        return tipoDocumento;
    }



    public Cargo getCargo() {

        if(cargo == null){
            cargo = new Cargo();
        }
        return cargo;
    }

}

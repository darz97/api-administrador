package co.com.administrador.administradorhotel.Entity;

import co.com.administrador.administradorhotel.Domain.Cargo;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name="cargo")
public class CargoEntity extends Cargo {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;

    @Column(name="nombre")
    private String nombre;

    @Column (name ="descripcion")
    private String descripcion;

}

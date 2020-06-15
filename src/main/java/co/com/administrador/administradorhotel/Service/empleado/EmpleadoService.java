package co.com.administrador.administradorhotel.Service.empleado;

import co.com.administrador.administradorhotel.Domain.Empleado;

import java.util.List;

public interface EmpleadoService  {
    Empleado findById(String numeroDocumento);

    List<Empleado> findAll();

    void delete(String numeroDocumento);

    void update(Empleado empleado, String numeroDocumento);

    void insert(Empleado empleado);
}

package co.com.administrador.administradorhotel.Converter;

import co.com.administrador.administradorhotel.Domain.Empleado;

import co.com.administrador.administradorhotel.Entity.EmpleadoEntity;
import org.springframework.stereotype.Component;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
@Component
public class EmpleadoConverter {

    public Empleado entityToModel(EmpleadoEntity empleadoEntity){
        Empleado empleado = new Empleado();
        empleado.setNumeroDocumento(empleadoEntity.getNumeroDocumento());
        empleado.setNombre(empleadoEntity.getNombre());
        empleado.setApellido(empleadoEntity.getApellido());
        empleado.setCorreo(empleadoEntity.getCorreo());
        empleado.getTipoDocumento().setId(empleadoEntity.getTipoDocumentoEntity().getId());
        empleado.getTipoDocumento().setNombre(empleadoEntity.getTipoDocumentoEntity().getNombre());
        empleado.getCargo().setId(empleadoEntity.getCargoEntity().getId());
        empleado.getCargo().setNombre(empleadoEntity.getCargoEntity().getNombre());
        empleado.setEstadoContrato(empleadoEntity.getEstadoContrato());
        return empleado;
    }

    public EmpleadoEntity modelToEntity(Empleado empleado){
        EmpleadoEntity empleadoEntity = new EmpleadoEntity();
        empleadoEntity.setNumeroDocumento(empleado.getNumeroDocumento());
        empleadoEntity.setNombre(empleado.getNombre());
        empleadoEntity.setApellido(empleado.getApellido());
        empleadoEntity.setCorreo(empleado.getCorreo());
        empleadoEntity.getTipoDocumentoEntity().setId(empleado.getTipoDocumento().getId());
        empleadoEntity.getTipoDocumentoEntity().setNombre(empleado.getTipoDocumento().getNombre());
        empleadoEntity.getCargoEntity().setId(empleado.getCargo().getId());
        empleadoEntity.getCargoEntity().setNombre(empleado.getCargo().getNombre());
        empleadoEntity.setEstadoContrato(empleado.getEstadoContrato());
        return empleadoEntity;
    }

    public List<Empleado> entityToModel(List<EmpleadoEntity> empleadoEntity) {
        List<Empleado> empleado = new ArrayList<>(empleadoEntity.size());
        empleadoEntity.forEach(entity -> {
            empleado.add(entityToModel(entity));
        });
        return empleado;
    }

    public Empleado entityToModel(Optional<EmpleadoEntity> empleadoEntity) {
        Empleado empleado = null;
        if (empleadoEntity.isPresent()) {
            empleado = new Empleado();
            empleado.setNumeroDocumento(empleadoEntity.get().getNumeroDocumento());
            empleado.setNombre(empleadoEntity.get().getNombre());
            empleado.setApellido(empleadoEntity.get().getApellido());
            empleado.setCorreo(empleadoEntity.get().getCorreo());
            empleado.getTipoDocumento().setId(empleado.getTipoDocumento().getId());
            empleado.getTipoDocumento().setNombre(empleado.getTipoDocumento().getNombre());
            empleado.getCargo().setId(empleado.getCargo().getId());
            empleado.getCargo().setNombre(empleado.getCargo().getNombre());
            empleado.setEstadoContrato(empleadoEntity.get().getEstadoContrato());

            return empleado;
        }
        return empleado;
    }



}

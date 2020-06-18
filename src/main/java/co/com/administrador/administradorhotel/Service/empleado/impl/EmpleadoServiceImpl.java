package co.com.administrador.administradorhotel.Service.empleado.impl;

import co.com.administrador.administradorhotel.Converter.EmpleadoConverter;
import co.com.administrador.administradorhotel.Domain.Empleado;
import co.com.administrador.administradorhotel.Repository.EmpleadoRepository;
import co.com.administrador.administradorhotel.Service.empleado.EmpleadoService;
import co.com.administrador.administradorhotel.constantes.Constantes;
import co.com.administrador.administradorhotel.exception.NoExisteException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmpleadoServiceImpl implements EmpleadoService {
    private static final String EMPLEADO_NO_EXISTE = "El empleado consultado no existe";
    @Autowired
    private EmpleadoRepository empleadoRepository;

    @Autowired
    private EmpleadoConverter empleadoConverter;

    @Override
    public Empleado findById(String numeroDocumento) {
        Empleado empleado = empleadoConverter.entityToModel(empleadoRepository.findById(numeroDocumento).orElse(null));
        empleadoExiste(empleado);
        return empleado;
    }

    private void empleadoExiste(Empleado empleado) {
        if (empleado == null){
            throw  new NoExisteException(EMPLEADO_NO_EXISTE);
        }
    }

    @Override
    public List<Empleado> findAll() {
        return empleadoConverter.entityToModel(empleadoRepository.findAll());
    }

    @Override
    public void delete(String numeroDocumento) {
        empleadoRepository.deleteById(numeroDocumento);

    }

    @Override
    public void update(Empleado empleado, String numeroDocumento) {
        Empleado empleadoConsultado = findById(numeroDocumento);
        empleadoConsultado.setNombre(empleado.getNombre());
        empleadoConsultado.setApellido(empleado.getApellido());
        empleadoConsultado.setCorreo(empleado.getCorreo());
        empleadoConsultado.getTipoDocumento().setId(empleado.getTipoDocumento().getId());
        empleadoConsultado.getCargo().setId(empleado.getCargo().getId());
        empleadoRepository.save(empleadoConverter.modelToEntity(empleadoConsultado));

    }

    @Override
    public void updateEstadoInactivo(String numeroDocumento) {
        Empleado empleadoConsultado = findById(numeroDocumento);
        empleadoConsultado.setEstadoContrato(Constantes.estadoContrato.INACTIVO);
        empleadoRepository.save(empleadoConverter.modelToEntity(empleadoConsultado));
    }

    @Override
    public void insert(Empleado empleado) {
        empleado.setEstadoContrato(Constantes.estadoContrato.ACTIVO);
        empleadoRepository.save(empleadoConverter.modelToEntity(empleado));


    }

    @Override
    public void vincular(String numeroDocumento) {
        Empleado empleadoConsultado = findById(numeroDocumento);
        empleadoConsultado.setEstadoContrato(Constantes.estadoContrato.ACTIVO);
        empleadoRepository.save(empleadoConverter.modelToEntity(empleadoConsultado));
    }
}

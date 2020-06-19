package co.com.administrador.administradorhotel.Service.cargo.impl;

import co.com.administrador.administradorhotel.Converter.CargoConverter;
import co.com.administrador.administradorhotel.Domain.Cargo;
import co.com.administrador.administradorhotel.Repository.CargoRepository;
import co.com.administrador.administradorhotel.Service.cargo.CargoService;
import co.com.administrador.administradorhotel.exception.CargoExiste;
import co.com.administrador.administradorhotel.exception.NoExisteException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CargoServiceImpl implements CargoService {

    @Autowired
    private CargoRepository cargoRepository;

    @Autowired
    private CargoConverter cargoConverter;

    private static final String CARGO_NO_EXISTE ="El cargo consultado no existe";

    @Override
    public Cargo findById(Long id) {
       Cargo cargo =  cargoConverter.entityToModel(cargoRepository.findById(id).orElse(null));
       cargoExiste(cargo);
        return cargo;
    }

    private void cargoExiste(Cargo cargo) {
        if (cargo == null){
            throw  new NoExisteException(CARGO_NO_EXISTE);
        }
    }

    @Override
    public void insert(Cargo cargo) {
        Cargo cargoExiste =  cargoConverter.entityToModel(cargoRepository.findByNombre(cargo.getNombre()).orElse(null));
        if(!cargo.getNombre().equals(cargoExiste.getNombre())){
            cargoRepository.save(cargoConverter.modelToEntity(cargo));
        }
        else{
            throw new CargoExiste("El Cargo ya existe");
        }

    }

    @Override
    public void update(Cargo cargo, Long id) {
        Cargo cargoConsultado = findById(id);
        cargoConsultado.setNombre(cargo.getNombre());
        cargoRepository.save(cargoConverter.modelToEntity(cargoConsultado));

    }

    @Override
    public void delete(Long id) {
        cargoRepository.deleteById(id);
    }

    @Override
    public List<Cargo> findAll() {
        return cargoConverter.entityToModel(cargoRepository.findAll());
    }
}

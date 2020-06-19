package co.com.administrador.administradorhotel.Converter;

import co.com.administrador.administradorhotel.Domain.Cargo;

import co.com.administrador.administradorhotel.Entity.CargoEntity;
import co.com.administrador.administradorhotel.Entity.TipoDocumentoEntity;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class CargoConverter {


    public Cargo entityToModel(CargoEntity cargoEntity){
        Cargo cargo = new Cargo();
        if (cargoEntity != null){
            cargo.setId(cargoEntity.getId());
            cargo.setNombre(cargoEntity.getNombre());
        }
        return cargo;
    }

    public CargoEntity modelToEntity(Cargo cargo){
        CargoEntity cargoEntity = new CargoEntity();
        cargoEntity.setId(cargo.getId());
        cargoEntity.setNombre(cargo.getNombre());
        return cargoEntity;
    }

    public List<Cargo> entityToModel(List<CargoEntity> cargoEntity) {
        List<Cargo> Cargo = new ArrayList<>(cargoEntity.size());
        cargoEntity.forEach(entity -> {
            Cargo.add(entityToModel(entity));
        });
        return Cargo;
    }

    public Cargo entityToModel(Optional<CargoEntity> cargoEntity) {
        Cargo cargo = null;
        if (cargoEntity.isPresent()) {
            cargo = new Cargo();
            cargo.setId(cargoEntity.get().getId());
            cargo.setNombre(cargoEntity.get().getNombre());

            return cargo;
        }
        return cargo;
    }
}

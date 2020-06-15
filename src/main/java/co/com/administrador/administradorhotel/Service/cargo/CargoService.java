package co.com.administrador.administradorhotel.Service.cargo;

import co.com.administrador.administradorhotel.Domain.Cargo;

import java.util.List;

public interface CargoService {
    Cargo findById(Long id);

    void insert(Cargo cargo);

    void update(Cargo cargo, Long id);

    void delete(Long id);

    List<Cargo> findAll();
}

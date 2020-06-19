package co.com.administrador.administradorhotel.Repository;

import co.com.administrador.administradorhotel.Entity.CargoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CargoRepository extends JpaRepository<CargoEntity,Long> {

    Optional<CargoEntity> findByNombre(String nombre);
}

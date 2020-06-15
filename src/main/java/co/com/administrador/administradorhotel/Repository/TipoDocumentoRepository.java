package co.com.administrador.administradorhotel.Repository;

import co.com.administrador.administradorhotel.Entity.TipoDocumentoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TipoDocumentoRepository extends JpaRepository<TipoDocumentoEntity,Long> {
}

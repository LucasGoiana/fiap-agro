package br.com.fiap.agro.api.repository;

import br.com.fiap.agro.api.dto.LocaltionDTO;
import br.com.fiap.agro.api.entity.LocationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface LocationRepository extends JpaRepository<LocationEntity, Long> {
    @Query(nativeQuery = true, value = "SELECT * FROM tb_location s WHERE s.id_drone = :id_drone ORDER BY id DESC LIMIT 1")
    Optional<LocationEntity> findByIdDrone(@Param("id_drone")String idDrone);
}

package br.com.fiap.agro.api.dto;

import br.com.fiap.agro.api.entity.LocationEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class LocaltionDTO {
    private Long id;
    private String idDrone;
    private String latitude;
    private String longitude;

    public LocaltionDTO(LocationEntity locationEntity) {
        this.id = locationEntity.getId();
        this.idDrone = locationEntity.getIdDrone();
        this.latitude = locationEntity.getLatitude();
        this.longitude = locationEntity.getLongitude();
    }
}

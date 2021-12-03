package br.com.fiap.agro.api.entity;

import br.com.fiap.agro.api.dto.LocaltionDTO;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name="tb_location")
public class LocationEntity {

        @Id
        @GeneratedValue(strategy= GenerationType.IDENTITY)
        @Column(name="id")
        private Long id;

        @Column(name="id_drone")
        private String idDrone;
        private String latitude;
        private String longitude;

        public LocationEntity( LocaltionDTO localtionDTO){
            this.id = localtionDTO.getId();
            this.latitude = localtionDTO.getLatitude();
            this.longitude = localtionDTO.getLongitude();
        }
}

package br.com.fiap.agro.api.service;

import br.com.fiap.agro.api.dto.LocaltionDTO;
import br.com.fiap.agro.api.entity.LocationEntity;
import br.com.fiap.agro.api.repository.LocationRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class LocationServiceImpl implements LocationService {
    private final LocationRepository locationRepository;

    public LocationServiceImpl(LocationRepository locationRepository) {
        this.locationRepository = locationRepository;
    }

    @Override
    public LocaltionDTO makeTracking(LocaltionDTO localtionDTO) {
        LocationEntity locationEntity = new LocationEntity();
        locationEntity.setIdDrone(localtionDTO.getIdDrone());
        locationEntity.setLongitude(localtionDTO.getLongitude());
        locationEntity.setLatitude(localtionDTO.getLatitude());
        locationEntity = locationRepository.save(locationEntity);
        return new LocaltionDTO(locationEntity);

    }

    @Override
    public LocaltionDTO getTracking(String idDrone) {
        var alunos = locationRepository.findByIdDrone(idDrone).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,"Localização não encontrada!"));
        return new LocaltionDTO(alunos);

    }
}

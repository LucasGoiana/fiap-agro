package br.com.fiap.agro.api.service;

import br.com.fiap.agro.api.dto.LocaltionDTO;

public interface LocationService {
    LocaltionDTO makeTracking(LocaltionDTO localtionDTO);
    LocaltionDTO getTracking(String idDrone);
}

package mx.uam.integracion.autos.autos.service;

import mx.uam.integracion.autos.autos.dto.AutoDTO;

public interface AutosService {

    AutoDTO createAuto(AutoDTO autoDTO);

    AutoDTO getAutoById(String id);

    AutoDTO updateAuto(String id, AutoDTO autoDTO);

    AutoDTO[] getAllAutos();

    boolean deleteAuto(String id);
}

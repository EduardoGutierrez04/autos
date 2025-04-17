package mx.uam.integracion.autos.autos.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Service;

import mx.uam.integracion.autos.autos.dto.AutoDTO;
import mx.uam.integracion.autos.autos.entity.Autos;
import mx.uam.integracion.autos.autos.repository.AutosRepository;
import mx.uam.integracion.autos.autos.service.AutosService;

@Service
public class AutosServiceimpl implements AutosService {

    private final AutosRepository autosRepository;

    public AutosServiceimpl(AutosRepository autosRepository) {
        this.autosRepository = autosRepository;
    }

    @Override
    public AutoDTO createAuto(AutoDTO autoDTO) {
        Autos auto = new Autos(
            UUID.randomUUID().toString(),
            autoDTO.getMarca(),
            autoDTO.getModelo(),
            autoDTO.getAño()
        );

        Autos savedAuto = autosRepository.save(auto);

        autoDTO.setId(savedAuto.getId());
        return autoDTO;
    }

    @Override
    public AutoDTO getAutoById(String id) {
        Optional<Autos> autoOptional = autosRepository.findById(id);
        if (autoOptional.isPresent()) {
            Autos auto = autoOptional.get();
            AutoDTO autoDTO = new AutoDTO();
            autoDTO.setId(auto.getId());
            autoDTO.setMarca(auto.getMarca());
            autoDTO.setModelo(auto.getModelo());
            autoDTO.setAño(auto.getAño());
            return autoDTO;
        } else {
            return null;
        }
    }

    @Override
    public AutoDTO updateAuto(String id, AutoDTO autoDTO) {
        Optional<Autos> autoOptional = autosRepository.findById(id);
        if (autoOptional.isPresent()) {
            Autos autoToUpdate = autoOptional.get();
            autoToUpdate.setMarca(autoDTO.getMarca());
            autoToUpdate.setModelo(autoDTO.getModelo());
            autoToUpdate.setAño(autoDTO.getAño());

            Autos updatedAuto = autosRepository.save(autoToUpdate);

            autoDTO.setId(updatedAuto.getId());
            return autoDTO;
        } else {
            return null;
        }
    }

    @Override
    public boolean deleteAuto(String id) {
        Optional<Autos> autoOptional = autosRepository.findById(id);
        if (autoOptional.isPresent()) {
            autosRepository.delete(autoOptional.get());
            return true;
        } else {
            return false;
        }
    }

    @Override
    public AutoDTO[] getAllAutos() {
        List<Autos> autosList = autosRepository.findAll();
        AutoDTO[] autoDTOs = new AutoDTO[autosList.size()];
        for (int i = 0; i < autosList.size(); i++) {
            Autos auto = autosList.get(i);
            AutoDTO autoDTO = new AutoDTO();
            autoDTO.setId(auto.getId());
            autoDTO.setMarca(auto.getMarca());
            autoDTO.setModelo(auto.getModelo());
            autoDTO.setAño(auto.getAño());
            autoDTOs[i] = autoDTO;
        }
        return autoDTOs;
    }
}

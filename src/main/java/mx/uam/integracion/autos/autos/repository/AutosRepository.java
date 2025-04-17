package mx.uam.integracion.autos.autos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import mx.uam.integracion.autos.autos.entity.Autos;

@Repository
public interface AutosRepository extends JpaRepository<Autos, String> {
   
}

package com.tp.apirest.repositories;

import com.tp.apirest.entities.Persona;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonaRepository extends BaseRepository<Persona, Long> {
    List<Persona> findByNombreContainingOrApellidoContaining(String nombre, String apellido);

    Page<Persona> findByNombreContainingOrApellidoContaining(String nombre, String apellido, Pageable pageable);

    //ANOTACION JPQL PARAMETROS INDEXADOS
    @Query(value= "SELECT p FROM Persona p WHERE p.nombre LIKE %:filtro% OR p.apellido LIKE %:filtro%") //?1 PARAMETRO INDEXADO, EL 1 ES LA CANTIDAD DE PARAMETROS QUE LE PASAMOS AL METODO
    List<Persona> search(@Param("filtro") String filtro); //SI USARA 2 TENDRIA QUE PONER STRING FILTRO 2


    @Query(value= "SELECT p FROM Persona p WHERE p.nombre LIKE %:filtro% OR p.apellido LIKE %:filtro%") //?1 PARAMETRO INDEXADO, EL 1 ES LA CANTIDAD DE PARAMETROS QUE LE PASAMOS AL METODO
    Page<Persona> search(@Param("filtro") String filtro, Pageable pageable); //SI USARA 2 TENDRIA QUE PONER STRING FILTRO 2

    //ANOTACION JPQL PARAMETROS NOMBRADOS
   // @Query(value= "SELECT p FROM Persona p WHERE p.nombre LIKE '%:filtro%' OR p.apellido LIKE '%:filtro%'")
    //List<Persona> search(@Param("filtro") String filtro);

    //ANOTACIN QUERY NATIVO
     @Query (
              value= "SELECT * FROM persona WHERE persona.nombre LIKE %:filtro% OR persona.apellido LIKE %:filtro%",
             nativeQuery = true
     )
     List<Persona> searchNativo(@Param("filtro") String filtro);

    @Query (
            value= "SELECT * FROM persona WHERE persona.nombre LIKE %:filtro% OR persona.apellido LIKE %:filtro%",
            countQuery = "SELECT count(*) FROM persona", //LO AGREGO PORQUE LA PAGINACIÓN NO SERA AUTOMATICA EN LA PAGINACION NATIVA
            nativeQuery = true
    )
    Page<Persona> searchNativo(@Param("filtro") String filtro, Pageable pageable);
}
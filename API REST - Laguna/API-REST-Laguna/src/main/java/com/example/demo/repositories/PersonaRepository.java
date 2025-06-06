package com.example.demo.repositories;

import com.example.demo.entities.Persona;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.awt.print.Pageable;
import java.util.List;

@Repository
public interface PersonaRepository extends BaseRepository<Persona, Long> {
    //metodo de query
    List<Persona> findByNombreContainingOrApellidoContaining(String nombre, String apellido);

    //Page<Persona> findByNombreContainingOrApellidoContaining(String nombre, String apellido, Pageable pageable);

    boolean existsById(int dni);

    @Query(value = "SELECT p FROM Persona p WHERE p.nombre LIKE '%?1%' OR p.apellido LIKE '%?1%'")
    List<Persona> search(String Filtro);

//    @Query(value = "SELECT p FROM Persona p WHERE p.nombre LIKE '%?1%' OR p.apellido LIKE '%?1%'")
//    Page<Persona> search(String Filtro, Pageable pageable);

    @Query(
            value = "SELECT p FROM Persona WHERE persona.nombre LIKE '%?1%' OR persona.apellido LIKE '%?1%'",
            nativeQuery = true
    )
    List<Persona> searchNativo(String Filtro);

//    @Query(
//            value = "SELECT p FROM Persona WHERE persona.nombre LIKE '%?1%' OR persona.apellido LIKE '%?1%'",
//            countQuery = "SELECT count(*) FROM persona",
//            nativeQuery = true
//    )
//    Page<Persona> searchNativo(String Filtro, Pageable pageable);
}

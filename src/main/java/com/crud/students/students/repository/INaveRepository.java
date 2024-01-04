package com.crud.students.students.repository;

import com.crud.students.students.model.Nave;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface INaveRepository extends JpaRepository<Nave,Long> {
    Optional<Nave> findByNombre(String nombre);
}

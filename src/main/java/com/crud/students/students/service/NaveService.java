package com.crud.students.students.service;

import com.crud.students.students.exception.NaveAlreadyExistException;
import com.crud.students.students.exception.NaveNotFoundException;
import com.crud.students.students.model.Nave;
import com.crud.students.students.repository.INaveRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class NaveService implements INaveService {
    private final INaveRepository naveRepository;

    @Override
    public List<Nave> obtenerNaves() {
        return naveRepository.findAll();
    }

    @Override
    public Nave agregarNave(Nave nave) {
        if (naveAlreadyExist(nave.getNombre())) {
            throw new NaveAlreadyExistException(nave.getNombre() + "Ya existe una nave con ese nombre!");
        }

        return naveRepository.save(nave);
    }


    @Override
    public Nave actualizarNave(Nave nave, Long id) {
        return naveRepository.findById(id).map(st -> {
            st.setCategoria(nave.getCategoria());
            st.setNombre(nave.getNombre());
            st.setPais(nave.getPais());
            st.setColor(nave.getColor());
            return naveRepository.save(st);
        }).orElseThrow(() -> new NaveNotFoundException("Sorry,Esta Nave no ha sido encontrada"));
    }

    @Override
    public Nave obtenerNaveById(Long id) {
        return naveRepository.findById(id).orElseThrow(() -> new NaveNotFoundException("Sorry,No se encontró una nave con este id: " + id));
    }

    @Override
    public void deleteNave(Long id) {
        if (!naveRepository.existsById(id)) {
            throw new NaveNotFoundException("Sorry, No se encontró la nave");
        }
    naveRepository.deleteById(id);
    }

    private boolean naveAlreadyExist(String nombre) {
        return naveRepository.findByNombre(nombre).isPresent();
    }




}

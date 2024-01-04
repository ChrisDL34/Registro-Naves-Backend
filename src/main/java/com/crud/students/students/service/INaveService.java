package com.crud.students.students.service;

import com.crud.students.students.model.Nave;

import java.util.List;

public interface INaveService {

    public List<Nave> obtenerNaves();
    public Nave agregarNave(Nave nave);
    public Nave actualizarNave(Nave nave,Long id);
    public Nave obtenerNaveById(Long id);
    public void deleteNave(Long id);
}

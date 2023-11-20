package com.monitorando.services;

import java.util.List;

import com.monitorando.model.Turmas;


public interface TurmasServices {

    List<Turmas> getAllTurmas();

    Turmas getTurmasById(Integer cod_turma);

    Turmas saveTurmas(Turmas turmas);

    Turmas updateTurmas(Integer cod_turma, Turmas turmasAtualizadas);

    void deleteTurmas(Integer cod_turma);
}

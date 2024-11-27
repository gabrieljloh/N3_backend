package com.example.backendFinal.services;

import com.example.backendFinal.mappers.MaquinasMapper;
import com.example.backendFinal.repositories.FuncionariosRepository;
import com.example.backendFinal.repositories.MaquinasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MaquinasService {
    @Autowired
    private MaquinasRepository maquinasRepository;
    @Autowired
    private MaquinasMapper maquinasMapper;
    @Autowired
    private FuncionariosRepository funcionariosRepository;



}

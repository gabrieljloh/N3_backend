package com.example.backendFinal.services;

import com.example.backendFinal.mappers.OrdensMapper;
import com.example.backendFinal.repositories.FuncionariosRepository;
import com.example.backendFinal.repositories.MaquinasRepository;
import com.example.backendFinal.repositories.OrdensRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrdensService {
    @Autowired
    private OrdensRepository ordensRepository;
    @Autowired
    private OrdensMapper ordensMapper;
    @Autowired
    private FuncionariosRepository funcionariosRepository;
    @Autowired
    private MaquinasRepository maquinasRepository;


}

package com.example.backendFinal.services;

import com.example.backendFinal.mappers.FuncionariosMapper;
import com.example.backendFinal.repositories.FuncionariosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FuncionariosService {
    @Autowired
    private FuncionariosRepository funcionariosRepository;
    @Autowired
    private FuncionariosMapper funcionariosMapper;




}

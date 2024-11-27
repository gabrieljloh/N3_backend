package com.example.backendFinal.models;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "maquinas")
public class MaquinasModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    private String nome;
    private String modelo;
    private String fabricante;
    @OneToOne
    @JoinColumn(name = "operador_id")
    private FuncionariosModel operador;
    private String status;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getFabricante() {
        return fabricante;
    }

    public void setFabricante(String fabricante) {
        this.fabricante = fabricante;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public FuncionariosModel getOperador() {
        return operador;
    }

    public void setOperador(FuncionariosModel operador) {
        this.operador = operador;
    }
}
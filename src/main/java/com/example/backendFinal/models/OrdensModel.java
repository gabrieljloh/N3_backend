package com.example.backendFinal.models;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "ordens")
public class OrdensModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    @OneToOne
    @JoinColumn(name = "maquina_id")
    private MaquinasModel maquina;
    private String descricao;
    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "funcionario_id")
    private FuncionariosModel funcionarioResp;
    private String status;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public MaquinasModel getMaquina() {
        return maquina;
    }

    public void setMaquina(MaquinasModel maquina) {
        this.maquina = maquina;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public FuncionariosModel getFuncionarioResp() {
        return funcionarioResp;
    }

    public void setFuncionarioResp(FuncionariosModel funcionarioResp) {
        this.funcionarioResp = funcionarioResp;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
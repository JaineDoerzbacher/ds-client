package com.ds.client.dtos;

import com.ds.client.entities.Client;

import java.io.Serializable;
import java.time.Instant;

public class ClientDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;
    private String name;
    private String cpf;
    private Double income;
    private Instant birthDate;
    private Integer children;

    public ClientDTO() {
    }

    public ClientDTO(Long id, String name, String cpf, Double income, Instant birthDate, Integer children) {
        this.id = id;
        this.name = name;
        this.cpf = cpf;
        this.income = income;
        this.birthDate = birthDate;
        this.children = children;
    }

    public ClientDTO(Client entity) {
        this.id = entity.getId();
        this.name = entity.getName();
        this.cpf = entity.getCpf();
        this.income = entity.getIncome();
        this.birthDate = entity.getBirthDate();
        this.children = entity.getChildren();
    }

    public Long getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public String getCpf() {
        return this.cpf;
    }

    public Double getIncome() {
        return this.income;
    }

    public Instant getBirthDate() {
        return this.birthDate;
    }

    public Integer getChildren() {
        return this.children;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public void setIncome(Double income) {
        this.income = income;
    }

    public void setBirthDate(Instant birthDate) {
        this.birthDate = birthDate;
    }

    public void setChildren(Integer children) {
        this.children = children;
    }
    
}

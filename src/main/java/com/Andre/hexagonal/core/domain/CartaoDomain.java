package com.Andre.hexagonal.core.domain;

import java.time.LocalDate;


public class CartaoDomain {

    private Long id;
    private String numero;
    private LocalDate dataExpiracao;
    private String cvv;
    private double limite;
    private double avaiableLimite;
    private LocalDate ultimaAlteracaoLimite;
    private Integer dataVencimentoFatura;
    private ClienteDomain cliente;


    public CartaoDomain(Long id, String numero, LocalDate dataExpiracao, String cvv, double limite,
                        double avaiableLimite, LocalDate ultimaAlteracaoLimite, Integer dataVencimentoFatura, ClienteDomain cliente) {
        this.id = id;
        this.numero = numero;
        this.dataExpiracao = dataExpiracao;
        this.cvv = cvv;
        this.limite = limite;
        this.avaiableLimite = avaiableLimite;
        this.ultimaAlteracaoLimite = ultimaAlteracaoLimite;
        this.dataVencimentoFatura = dataVencimentoFatura;
        this.cliente = cliente;
    }

    public CartaoDomain(String numeroCartao, LocalDate dataExpiracao, String cvv, double limiteCredito,
                        ClienteDomain cliente, LocalDate ultimaAlteracaoLimite, Integer dataVencimentoFatura) {
        this.numero = numeroCartao;
        this.dataExpiracao = dataExpiracao;
        this.cvv = cvv;
        this.limite = limiteCredito;
        this.ultimaAlteracaoLimite = ultimaAlteracaoLimite;
        this.dataVencimentoFatura = dataVencimentoFatura;
        this.cliente = cliente;
    }

    public CartaoDomain (Integer dataVencimentoFatura) {
        this.dataVencimentoFatura = dataVencimentoFatura;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public LocalDate getDataExpiracao() {
        return dataExpiracao;
    }

    public void setDataExpiracao(LocalDate dataExpiracao) {
        this.dataExpiracao = dataExpiracao;
    }

    public String getCvv() {
        return cvv;
    }

    public void setCvv(String cvv) {
        this.cvv = cvv;
    }

    public double getAvaiableLimite() {
        return avaiableLimite;
    }

    public void setAvaiableLimite(double avaiableLimite) {
        this.avaiableLimite = avaiableLimite;
    }

    public LocalDate getUltimaAlteracaoLimite() {
        return ultimaAlteracaoLimite;
    }

    public void setUltimaAlteracaoLimite(LocalDate ultimaAlteracaoLimite) {
        this.ultimaAlteracaoLimite = ultimaAlteracaoLimite;
    }

    public Integer getDataVencimentoFatura() {
        return dataVencimentoFatura;
    }

    public void setDataVencimentoFatura(Integer dataVencimentoFatura) {
        this.dataVencimentoFatura = dataVencimentoFatura;
    }

    public ClienteDomain getCliente() {
        return cliente;
    }

    public void setCliente(ClienteDomain cliente) {
        this.cliente = cliente;
    }

    public double getLimite() {
        return limite;
    }

    public void setLimite(double limite) {
        this.limite = limite;
    }
}

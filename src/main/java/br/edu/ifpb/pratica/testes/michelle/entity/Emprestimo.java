/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.pratica.testes.michelle.entity;

import java.time.LocalDate;

/**
 *
 * @author miolivc
 */
public class Emprestimo {
    private int id;
    private Filme filme;
    private LocalDate date;
    private LocalDate devolucao;
    private FilmeSituacao situacao;

    public Emprestimo() {
        this.date = LocalDate.now();
        this.situacao = FilmeSituacao.EMPRESTADO;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Filme getFilme() {
        return filme;
    }

    public void setFilme(Filme filme) {
        this.filme = filme;
    }

    public FilmeSituacao getSituacao() {
        return situacao;
    }

    public void setSituacao(FilmeSituacao situacao) {
        this.situacao = situacao;
    }

    public LocalDate getDevolucao() {
        return devolucao;
    }

    public void setDevolucao(LocalDate devolucao) {
        this.devolucao = devolucao;
    }
    
    @Override
    public String toString() {
        return "Emprestimo{" + "filme=" + filme + ", date=" + date + ", situacao=" + situacao + '}';
    }
    
}

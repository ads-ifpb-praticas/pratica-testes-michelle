/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.pratica.testes.michelle.persistence.model;

import br.edu.ifpb.pratica.testes.michelle.entity.Emprestimo;

/**
 *
 * @author miolivc
 */
public interface EmprestimoDAO {
    
    void add(Emprestimo emprestimo);
    Emprestimo get(int id);
    void update(Emprestimo emprestimo);
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.pratica.testes.michelle.persistence.model;

import br.edu.ifpb.pratica.testes.michelle.entity.Emprestimo;
import java.util.List;

/**
 *
 * @author miolivc
 */
public interface EmprestimoDAO {

    boolean isLocked(int id);
    void add(Emprestimo emprestimo);
    List<Emprestimo> list();
    Emprestimo get(int id);
    void update(Emprestimo emprestimo);
    
}

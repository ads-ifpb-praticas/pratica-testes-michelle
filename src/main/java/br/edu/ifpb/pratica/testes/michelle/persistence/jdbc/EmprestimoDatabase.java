/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.pratica.testes.michelle.persistence.jdbc;

import br.edu.ifpb.pratica.testes.michelle.entity.Emprestimo;
import br.edu.ifpb.pratica.testes.michelle.factory.ConnectionFactory;
import br.edu.ifpb.pratica.testes.michelle.persistence.model.EmprestimoDAO;
import java.sql.Connection;

/**
 *
 * @author miolivc
 */
public class EmprestimoDatabase implements EmprestimoDAO {

    private final Connection connection;

    public EmprestimoDatabase() {
        this.connection = ConnectionFactory.getConnection();
    }
    
    @Override
    public void add(Emprestimo emprestimo) {
        
    }

    @Override
    public Emprestimo get(int id) {
        return null;
    }

    @Override
    public void update(Emprestimo emprestimo) {
        
    }
    
}

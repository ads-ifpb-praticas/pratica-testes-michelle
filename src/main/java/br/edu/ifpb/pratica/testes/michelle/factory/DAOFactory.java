/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.pratica.testes.michelle.factory;

import br.edu.ifpb.pratica.testes.michelle.persistence.model.EmprestimoDAO;
import br.edu.ifpb.pratica.testes.michelle.persistence.model.FilmeDAO;

/**
 *
 * @author miolivc
 */
public interface DAOFactory {
    
    FilmeDAO createFilmeDAO();
    EmprestimoDAO createEmprestimoDAO();
    
}

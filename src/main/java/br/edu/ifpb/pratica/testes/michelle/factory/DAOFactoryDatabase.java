/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.pratica.testes.michelle.factory;

import br.edu.ifpb.pratica.testes.michelle.persistence.jdbc.EmprestimoDatabase;
import br.edu.ifpb.pratica.testes.michelle.persistence.jdbc.FilmeDatabase;
import br.edu.ifpb.pratica.testes.michelle.persistence.model.EmprestimoDAO;
import br.edu.ifpb.pratica.testes.michelle.persistence.model.FilmeDAO;

/**
 *
 * @author miolivc
 */
public class DAOFactoryDatabase implements DAOFactory {

    @Override
    public FilmeDAO createFilmeDAO() {
        return new FilmeDatabase();
    }

    @Override
    public EmprestimoDAO createEmprestimoDAO() {
        return new EmprestimoDatabase();
    }

}

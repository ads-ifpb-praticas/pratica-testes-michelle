/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.pratica.testes.michelle.manager;

import br.edu.ifpb.pratica.testes.michelle.entity.Filme;
import br.edu.ifpb.pratica.testes.michelle.exception.FilmeInvalidoException;
import br.edu.ifpb.pratica.testes.michelle.factory.PersistFactory;
import br.edu.ifpb.pratica.testes.michelle.persistence.model.FilmeDAO;
import br.edu.ifpb.pratica.testes.michelle.validators.ValidadorFilme;
import java.util.List;

/**
 *
 * @author miolivc
 */
public class FilmeManager {
    private final ValidadorFilme validador;
    private final FilmeDAO dao;

    public FilmeManager() {
        this.validador = new ValidadorFilme();
        this.dao = PersistFactory.createFactory(PersistFactory.DATABASE).createFilmeDAO();
    }
    
    public void cadastraFilme(Filme filme) throws FilmeInvalidoException {
        if (validador.validate(filme)) {
            dao.add(filme);
        } else {
            throw new FilmeInvalidoException("O filme que você tentou cadastrar não é válido!");
        }
    }
    
    public List<Filme> listaFilmes() {
        return dao.list();
    }
    
    public Filme recuperaFilme(int id) {
        return dao.get(id);
    }
    
}

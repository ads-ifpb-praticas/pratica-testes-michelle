/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.pratica.testes.michelle.persistence.model;

import br.edu.ifpb.pratica.testes.michelle.entity.Filme;
import java.util.List;

/**
 *
 * @author miolivc
 */
public interface FilmeDAO {
    
    void add(Filme filme);
    Filme get(int id);
    List<Filme> list();
    
}

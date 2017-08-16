/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.pratica.testes.michelle.manager;

import br.edu.ifpb.pratica.testes.michelle.entity.Emprestimo;
import br.edu.ifpb.pratica.testes.michelle.exception.EmprestimoInvalidoException;
import br.edu.ifpb.pratica.testes.michelle.factory.PersistFactory;
import br.edu.ifpb.pratica.testes.michelle.persistence.model.EmprestimoDAO;
import br.edu.ifpb.pratica.testes.michelle.validators.ValidadorEmprestimo;
import java.util.List;

/**
 *
 * @author miolivc
 */
public class EmprestimoManager {
    private final ValidadorEmprestimo validador;
    private final EmprestimoDAO dao; 
    
    public EmprestimoManager() {
        this.validador = new ValidadorEmprestimo();
        this.dao = PersistFactory.createFactory(PersistFactory.DATABASE).createEmprestimoDAO();
    }
    
    public void emprestar(Emprestimo emprestimo) throws EmprestimoInvalidoException {
        if (validador.validateEmprestimo(emprestimo)) {
            dao.add(emprestimo);
        } else {
            throw new EmprestimoInvalidoException("O emprestimo não pode ser "
                    + "efetivado pois um dos dados é invalido!");
        }
    }
    
    public void devolver(Emprestimo emprestimo) throws EmprestimoInvalidoException {
        if (validador.validateDevolucao(emprestimo)) {
            dao.update(emprestimo);
        } else {
            throw new EmprestimoInvalidoException("O emprestimo não pode ser "
                    + "efetivado pois um dos dados é invalido!");
        }
    }
    
    public List<Emprestimo> emprestimosRealizados() {
        return dao.list();
    }
    
    public Emprestimo recuperaEmprestimoRealizado(int id) {
        return dao.get(id);
    }
    
}

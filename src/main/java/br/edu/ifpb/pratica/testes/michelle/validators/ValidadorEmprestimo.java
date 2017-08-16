/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.pratica.testes.michelle.validators;

import br.edu.ifpb.pratica.testes.michelle.entity.Emprestimo;
import br.edu.ifpb.pratica.testes.michelle.entity.FilmeSituacao;
import java.time.LocalDate;

/**
 *
 * @author miolivc
 */
public class ValidadorEmprestimo {
    
    public boolean validateEmprestimo(Emprestimo emprestimo) {
        if (emprestimo == null) return false;
        if (emprestimo.getDate().isBefore(LocalDate.now())) return false;
        if (emprestimo.getFilme() == null) return false;
        return emprestimo.getSituacao().equals(FilmeSituacao.EMPRESTADO);
    }
    
    public boolean validateDevolucao(Emprestimo emprestimo) {
        if (emprestimo == null) return false;
        return emprestimo.getDate().isBefore(emprestimo.getDevolucao());
    }
}

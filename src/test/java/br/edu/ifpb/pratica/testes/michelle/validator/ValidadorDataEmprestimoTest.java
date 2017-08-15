/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.pratica.testes.michelle.validator;

import br.edu.ifpb.pratica.testes.michelle.entity.Emprestimo;
import br.edu.ifpb.pratica.testes.michelle.entity.Filme;
import br.edu.ifpb.pratica.testes.michelle.entity.FilmeSituacao;
import br.edu.ifpb.pratica.testes.michelle.entity.GeneroFilme;
import br.edu.ifpb.pratica.testes.michelle.validators.ValidadorEmprestimo;
import java.time.LocalDate;
import org.junit.Assert;
import org.junit.Test;

/**
 *
 * @author miolivc
 */
public class ValidadorDataEmprestimoTest {
    private final ValidadorEmprestimo validador = new ValidadorEmprestimo();
    
    @Test
    public void testaDataRetroativa() {
        Filme filme = new Filme("Mamãe e suas filhas mortas", GeneroFilme.TERROR, 123);
        Emprestimo emprestimo = new Emprestimo();
        emprestimo.setFilme(filme);
        emprestimo.setDate(LocalDate.parse("2007-12-03"));
        Assert.assertFalse(validador.validateEmprestimo(emprestimo));
    }
    
    @Test
    public void testaSituacao() {
        Filme filme = new Filme("Mamãe e suas filhas mortas", GeneroFilme.TERROR, 123);
        Emprestimo emprestimo = new Emprestimo();
        emprestimo.setFilme(filme);
        Assert.assertEquals(emprestimo.getSituacao(), FilmeSituacao.EMPRESTADO);
    }
    
    @Test
    public void testaFilmeNulo() {
        Filme filme = null;
        Emprestimo emprestimo = new Emprestimo();
        emprestimo.setFilme(filme);
        Assert.assertFalse(validador.validateEmprestimo(emprestimo));
    }
    
    @Test
    public void testaDevolucaoRetroativa() {
        Filme filme = new Filme("Mamãe e suas filhas mortas", GeneroFilme.TERROR, 123);
        Emprestimo emprestimo = new Emprestimo();
        emprestimo.setFilme(filme);
        emprestimo.setDevolucao(LocalDate.parse("2007-12-03"));
        Assert.assertFalse(validador.validateDevolucao(emprestimo));
    }
}

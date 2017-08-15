/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.pratica.testes.michelle;

import br.edu.ifpb.pratica.testes.michelle.entity.Filme;
import br.edu.ifpb.pratica.testes.michelle.entity.GeneroFilme;
import br.edu.ifpb.pratica.testes.michelle.validators.ValidadorFilme;

/**
 *
 * @author ifpb
 */
public class ValidadorFilmeTest {
    private ValidadorFilme validador = new ValidadorFilme();
    
    @Test
    public void testaDuracaoFilme() {
        Filme filme = new Filme("Hahaha, eu te peguei.", GeneroFilme.COMÉDIA, 0);
        Assert.assertFalse(validador.validate(filme));
    }
    
    @Test
    public void testaCaracteresEspeciais() {
        Filme filme = new Filme("Maria 100% loka", GeneroFilme.ROMANCE, 123);
        Assert.assertFalse(validador.validate(filme));
    }
    
    @Test
    public void testaQuantidadeCaracteres() {
        Filme filme = new Filme("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"
                + "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa", GeneroFilme.ROMANCE, 123);
        Assert.assertFalse(validador.validate(filme));
    }
    
    @Test
    public void testaGeneroNulo() {
        Filme filme = new Filme("Maria", null, 12);
        Assert.assertFalse(validador.validate(filme));
    }
    
}

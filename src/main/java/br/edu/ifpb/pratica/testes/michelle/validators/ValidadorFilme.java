/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.pratica.testes.michelle.validators;

import br.edu.ifpb.pratica.testes.michelle.entity.Filme;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author ifpb
 */
public class ValidadorFilme {
    
    public boolean validate(Filme filme) {
       if (filme == null) return false;
       if (filme.getDuracao() <= 0) return false;
       if (filme.getGenero() == null) return false;
       if (filme.getTitulo().length() == 0 || filme.getTitulo().length() > 50 || filme.getTitulo() == null) return false;
       Pattern pattern = Pattern.compile("[a-zA-Z_0-9_#_!_?]");
       Matcher matcher = pattern.matcher(filme.getTitulo());
       return matcher.matches();
    }
}

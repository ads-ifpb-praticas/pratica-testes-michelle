/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.pratica.testes.michelle.persistence.jdbc;

import br.edu.ifpb.pratica.testes.michelle.entity.Filme;
import br.edu.ifpb.pratica.testes.michelle.entity.GeneroFilme;
import br.edu.ifpb.pratica.testes.michelle.factory.ConnectionFactory;
import br.edu.ifpb.pratica.testes.michelle.persistence.model.FilmeDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author miolivc
 */
public class FilmeDatabase implements FilmeDAO {

    private final Connection connection;

    public FilmeDatabase() {
        this.connection = ConnectionFactory.getConnection();
    }
    
    @Override
    public void add(Filme filme) {
        try {  
            String sql = "INSERT INTO FILME(TITULO, GENERO, DURACAO) VALUES(?,?,?)";
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, filme.getTitulo());
            stmt.setString(2, filme.getGenero().name());
            stmt.setInt(3, filme.getDuracao());
            if (stmt.executeUpdate() != 1) throw new SQLException();
        } catch (SQLException ex) {
            System.err.println(ex);
        }
    }

    @Override
    public Filme get(int id) {
        try {  
            String sql = "SELECT * FROM FILME WHERE ID = " + id;
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            Filme filme = new Filme();
            while(rs.next()) {
                filme.setId(rs.getInt("ID"));
                filme.setTitulo("TITULO");
                filme.setGenero(GeneroFilme.valueOf(rs.getString("GENERO")));
                filme.setDuracao(rs.getInt("DURACAO"));
            }
            return filme;
        } catch (SQLException ex) {
            System.err.println(ex);
        }
        return null;
    }

    @Override
    public List<Filme> list() {
        try {  
            String sql = "SELECT * FROM FILME";
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            List<Filme> filmes = new ArrayList<>();
            while(rs.next()) {
                Filme filme = new Filme();
                filme.setId(rs.getInt("ID"));
                filme.setTitulo("TITULO");
                filme.setGenero(GeneroFilme.valueOf(rs.getString("GENERO")));
                filme.setDuracao(rs.getInt("DURACAO"));
                filmes.add(filme);
            }
            return filmes;
        } catch (SQLException ex) {
            System.err.println(ex);
        }
        return Collections.EMPTY_LIST;
    }
    
}

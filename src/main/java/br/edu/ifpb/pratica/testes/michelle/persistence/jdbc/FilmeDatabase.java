/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.pratica.testes.michelle.persistence.jdbc;

import br.edu.ifpb.pratica.testes.michelle.entity.Filme;
import br.edu.ifpb.pratica.testes.michelle.entity.GeneroFilme;
import br.edu.ifpb.pratica.testes.michelle.factory.ConnectionFactory;
import br.edu.ifpb.pratica.testes.michelle.factory.PersistFactory;
import br.edu.ifpb.pratica.testes.michelle.persistence.model.EmprestimoDAO;
import br.edu.ifpb.pratica.testes.michelle.persistence.model.FilmeDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

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
    public boolean isLocked(int id) {
        EmprestimoDAO emprestimoDAO = PersistFactory.createFactory(PersistFactory.DATABASE).createEmprestimoDAO();
        return emprestimoDAO.isLocked(id);
    }
    
    @Override
    public void add(Filme filme) {
        try {  
            String sql = "INSERT INTO FILME(TITULO, GENERO, DURACAO) VALUES(?,?,?)";
            try (PreparedStatement stmt = connection.prepareStatement(sql)) {
                stmt.setString(1, filme.getTitulo());
                stmt.setString(2, filme.getGenero().name());
                stmt.setInt(3, filme.getDuracao());
                if (stmt.executeUpdate() != 1) throw new SQLException();
            }
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
            stmt.close();
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
            stmt.close();
            return filmes;
        } catch (SQLException ex) {
            System.err.println(ex);
        }
        return Collections.EMPTY_LIST;
    }
    
    @Override
    public void update(Filme filme) {
        String sql = "UPDATE FILME SET TITULO = ? GENERO = ? DURACAO = ? WHERE ID = ?";
        try {
            try (PreparedStatement stmt = connection.prepareStatement(sql)) {
                stmt.setString(1, filme.getTitulo());
                stmt.setString(2, filme.getGenero().name());
                stmt.setInt(3, filme.getDuracao());
                stmt.setInt(4, filme.getId());
                if (stmt.executeUpdate() != 1) throw new SQLException();
            }
        } catch (SQLException ex) {
            System.err.println(ex);
        }
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.pratica.testes.michelle.persistence.jdbc;

import br.edu.ifpb.pratica.testes.michelle.entity.Emprestimo;
import br.edu.ifpb.pratica.testes.michelle.entity.FilmeSituacao;
import br.edu.ifpb.pratica.testes.michelle.factory.ConnectionFactory;
import br.edu.ifpb.pratica.testes.michelle.factory.PersistFactory;
import br.edu.ifpb.pratica.testes.michelle.persistence.model.EmprestimoDAO;
import br.edu.ifpb.pratica.testes.michelle.persistence.model.FilmeDAO;
import java.sql.Connection;
import java.sql.Date;
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
public class EmprestimoDatabase implements EmprestimoDAO {

    private final Connection connection;

    public EmprestimoDatabase() {
        this.connection = ConnectionFactory.getConnection();
    }
    
    @Override 
    public boolean isLocked(int id) {
        try {
            String sql = "SELECT EXISTS FROM EMPRESTIMO WHERE FILME = ? AND SITUACAO = 'EMPRESTADO'";
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, id);
            return stmt.getMoreResults();
        } catch (SQLException ex) {
            System.err.println(ex);
        }
        return false;
    }
    
    @Override
    public void add(Emprestimo emprestimo) {
        try {
            String sql = "INSERT INTO EMPRESTIMO(FILME, DATA, DEVOLUCAO, SITUACAO) VALUES (?,?,?,?)";
            try (PreparedStatement stmt = connection.prepareStatement(sql)) {
                stmt.setInt(1, emprestimo.getFilme().getId());
                stmt.setDate(2, Date.valueOf(emprestimo.getDate()));
                stmt.setDate(3, Date.valueOf(emprestimo.getDevolucao()));
                stmt.setString(4, emprestimo.getSituacao().name());
                if (stmt.executeUpdate() != 1) throw new SQLException();
            }
        } catch (SQLException ex) {
            System.err.println(ex);
        }
    }

    @Override
    public List<Emprestimo> list() {
        try {
            String sql = "SELECT * FROM EMPRESTIMO";
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            List<Emprestimo> emprestimos = new ArrayList<>();
            FilmeDAO filmeDAO = PersistFactory.createFactory(PersistFactory.DATABASE).createFilmeDAO();
            while(rs.next()) {
                Emprestimo emprestimo = new Emprestimo();
                emprestimo.setId(rs.getInt("ID"));
                emprestimo.setFilme(filmeDAO.get(rs.getInt("FILME")));
                emprestimo.setDate(rs.getDate("DATA").toLocalDate());
                emprestimo.setDevolucao(rs.getDate("DEVOLUCAO").toLocalDate());
                emprestimo.setSituacao(FilmeSituacao.valueOf(rs.getString("SITUACAO")));
                emprestimos.add(emprestimo);
            }
            return emprestimos;
        } catch (SQLException ex) {
            System.err.println(ex);
        }
        return Collections.EMPTY_LIST;
    }
    
    @Override
    public Emprestimo get(int id) {
        try {
            String sql = "SELECT * FROM EMPRESTIMO WHERE ID = " + id;
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            Emprestimo emprestimo = new Emprestimo();
            FilmeDAO filmeDAO = PersistFactory.createFactory(PersistFactory.DATABASE).createFilmeDAO();
            while(rs.next()) {
                emprestimo.setId(rs.getInt("ID"));
                emprestimo.setFilme(filmeDAO.get(rs.getInt("FILME")));
                emprestimo.setDate(rs.getDate("DATA").toLocalDate());
                emprestimo.setDevolucao(rs.getDate("DEVOLUCAO").toLocalDate());
                emprestimo.setSituacao(FilmeSituacao.valueOf(rs.getString("SITUACAO")));
            }
            return emprestimo;
        } catch (SQLException ex) {
            System.err.println(ex);
        }
        return null;
    }

    @Override
    public void update(Emprestimo emprestimo) {
        try {
            String sql = "UPDATE EMPRESTIMO SET FILME = ? DATA = ? DEVOLUCAO = ? SITUACAO = ? WHERE ID = ?";
            try (PreparedStatement stmt = connection.prepareStatement(sql)) {
                stmt.setInt(1, emprestimo.getFilme().getId());
                stmt.setDate(2, Date.valueOf(emprestimo.getDate()));
                stmt.setDate(3, Date.valueOf(emprestimo.getDevolucao()));
                stmt.setString(4, emprestimo.getSituacao().name());
                stmt.setInt(5, emprestimo.getId());
                if (stmt.executeUpdate() != 1) throw new SQLException();
            }
        } catch (SQLException ex) {
            System.err.println(ex);
        }
    }
    
}

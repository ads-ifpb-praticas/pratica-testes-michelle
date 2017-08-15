/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.pratica.testes.michelle.factory;

/**
 *
 * @author miolivc
 */
public class PersistFactory {
    public static final int DATABASE = 0;
    
    public static final DAOFactory createFactory(int factoryType) {
        if (factoryType == 0) return new DAOFactoryDatabase();
        return null;
    }
}

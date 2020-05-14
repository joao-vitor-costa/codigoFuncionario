/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.SQLException;
import java.util.ArrayList;
import model.Funcionario;

/**
 *
 * @author JoãoVitor
 */
public interface IDAOFuncionario {

    public boolean inserir(Funcionario funcionario) throws Exception;

    public boolean remover(Funcionario funcionario) throws SQLException;
    
    public ArrayList<Funcionario> getFuncionarioALL() throws Exception;
     
    public boolean editarFuncionario(Funcionario funcionario) throws SQLException;
    
    public boolean setBonus(Funcionario funcionario) throws SQLException;
}

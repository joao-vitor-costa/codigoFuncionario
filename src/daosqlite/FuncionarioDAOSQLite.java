/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daosqlite;

import dao.ConexaoDAO;
import dao.IDAOFuncionario;
import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.Funcionario;

/**
 *
 * @author JoãoVitor
 */
public final class FuncionarioDAOSQLite implements IDAOFuncionario,ConexaoDAO {

    private Connection connection;
    public static String DRIVER;
    public static String URL;

    public FuncionarioDAOSQLite() throws Exception {
        File file = new File("src/data/funcionariobd.sqlite");
        FuncionarioDAOSQLite.URL = "jdbc:sqlite:" + file.getAbsolutePath();
        FuncionarioDAOSQLite.DRIVER = "org.sqlite.JDBC";
        conexao();

    }

    @Override
    public boolean inserir(Funcionario funcionario) throws Exception {
        String query = "INSERT INTO funcionario (nome,salario,idade,regiao,bonus,nomebonus,cargo,falta,dependente) VALUES (?, ?, ?, ?,?,?,?,?,?)";

        PreparedStatement statement = connection.prepareStatement(query);

        statement.setString(1, funcionario.getNome());
        statement.setDouble(2, funcionario.getSalario());
        statement.setInt(3, funcionario.getIdade());
        statement.setString(4, funcionario.getRegiao());
        statement.setDouble(5, funcionario.getBonus());
        statement.setString(6, funcionario.getNomeBonus());
        statement.setString(7, funcionario.getCargo());
        statement.setInt(8, funcionario.getFalta());
        statement.setInt(9, funcionario.getDepedentes());

        return (statement.executeUpdate() > 0); // 0 deu pau
    }

    @Override
    public boolean remover(Funcionario funcionario) throws SQLException {
        String query = "DELETE FROM funcionario Where id = ?";

        PreparedStatement statement = connection.prepareStatement(query);

        statement.setInt(1, funcionario.getId());

        return (statement.executeUpdate() > 0);

    }

    @Override
    public ArrayList<Funcionario> getFuncionarioALL() throws Exception {

        ArrayList<Funcionario> funcionarios = new ArrayList<>();

        String query = "SELECT * FROM funcionario";

        PreparedStatement statement = connection.prepareStatement(query);
        ResultSet rs = statement.executeQuery();

        while (rs.next()) {
            int id = rs.getInt("id");
            String nome = rs.getString("nome");
            double salario = rs.getDouble("salario");
            int idade = rs.getInt("idade");
            String regiao = rs.getString("regiao");
            double bonus = rs.getDouble("bonus");
            String nomebonus = rs.getString("nomebonus");
            String cargo = rs.getString("cargo");
            int falta = rs.getInt("falta");
            int dependente = rs.getInt("dependente");

            Funcionario funcionario = new Funcionario(id, nome, salario, falta, cargo, idade, regiao, nomebonus, dependente, bonus);

            funcionarios.add(funcionario);
        }

        return funcionarios;
    }

    @Override
    public boolean editarFuncionario(Funcionario funcionario) throws SQLException {
        String query = "UPDATE funcionario SET nome = ?,salario = ?,idade = ?,regiao = ?,bonus = ?,nomebonus = ?,cargo = ?,falta = ?, dependente = ? WHERE id = ?";

        PreparedStatement statement = connection.prepareStatement(query);

        statement.setString(1, funcionario.getNome());
        statement.setDouble(2, funcionario.getSalario());
        statement.setInt(3, funcionario.getIdade());
        statement.setString(4, funcionario.getRegiao());
        statement.setDouble(5, funcionario.getBonus());
        statement.setString(6, funcionario.getNomeBonus());
        statement.setString(7, funcionario.getCargo());
        statement.setInt(8, funcionario.getFalta());
        statement.setInt(9, funcionario.getDepedentes());
        statement.setInt(10, funcionario.getId());

        return (statement.executeUpdate() > 0);
    }

    @Override
    public boolean setBonus(Funcionario funcionario) throws SQLException {
        String query = "UPDATE funcionario set bonus = ? where nome = ? ";

        PreparedStatement statement = connection.prepareStatement(query);

        statement.setDouble(1, funcionario.getBonus());
        statement.setString(2, funcionario.getNome());

        return (statement.executeUpdate() > 0);
    }

    @Override
    public void conexao() throws Exception {
        try {
            Class.forName(DRIVER);
            connection = DriverManager.getConnection(URL);
        } catch (ClassNotFoundException | SQLException e) {
            throw new Exception("Não foi possivel conectar. Erro :" + e.getMessage());
        }
    }

}

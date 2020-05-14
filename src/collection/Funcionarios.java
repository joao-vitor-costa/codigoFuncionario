/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package collection;

import configuration.Configuracao;
import dao.IDAOFuncionario;
import abstractfactory.FabricaAbstrata;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Properties;
import model.Funcionario;
import java.sql.SQLException;
import observer.IObservador;
import observer.Observado;

/**
 *
 * @author JoãoVitor
 */
public class Funcionarios extends Observado {

    private static Funcionarios instancia;
    private ArrayList<Funcionario> funcionarios;
    private final FabricaAbstrata factory;
    private final IDAOFuncionario dao;
    private final ArrayList<IObservador> observadores;

    private Funcionarios() throws IOException, ClassNotFoundException, InstantiationException, IllegalAccessException, Exception {
        Configuracao configuracao = Configuracao.getInstance();
         Properties properties = Configuracao.properties;
        factory = new FabricaAbstrata();
        dao = (IDAOFuncionario) factory.fabricaDAO(properties.getProperty("dao"));
        this.funcionarios = dao.getFuncionarioALL();
        this.observadores = new ArrayList<>();
    }

    public ArrayList<Funcionario> getFuncionarios() {
        return funcionarios;
    }

    //sigton
    public static Funcionarios getInstancia() throws IOException, ClassNotFoundException, InstantiationException, IllegalAccessException, Exception {
        if (instancia == null) {
            instancia = new Funcionarios();
        }
        return instancia;
    }

    public void addFuncionario(Funcionario funcionario) throws Exception {
        this.dao.inserir(funcionario);
        funcionarios = this.getallFuncionarios();
        notificar();
    }

    public void removerFuncionario(Funcionario f) throws SQLException, Exception {
        this.dao.remover(f);
        funcionarios = this.getallFuncionarios();
        notificar();

    }

    public void setBonus(Funcionario funcionario) throws SQLException, Exception {
        this.dao.setBonus(funcionario);
        funcionarios = this.getallFuncionarios();
        notificar();
    }

    public void editar(Funcionario funcionario) throws SQLException, Exception {
        this.dao.editarFuncionario(funcionario);
        funcionarios = this.getallFuncionarios();
        notificar();

    }

    public ArrayList<Funcionario> getallFuncionarios() throws Exception {
        return dao.getFuncionarioALL();
    }

    public int numeroFuncionario() {
        return funcionarios.size();
        
    }

    @Override
    public void addObservador(IObservador observador) {
        if (!observadores.contains(observador)) {
            observadores.add(observador);
        }

    }

    @Override
    public void removerObservador(IObservador observador) {
        if (observadores.contains(observador)) {
            observadores.remove(observador);
        }

    }

    @Override
    public void notificar() {
        observadores.stream().forEach((IObservador IObservador) -> {
            IObservador.atualizar(Funcionarios.this);
        });
    }

}

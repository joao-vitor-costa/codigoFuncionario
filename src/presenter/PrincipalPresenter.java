/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presenter;

import collection.Funcionarios;
import view.PrincipalView;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import observer.IObservador;

/**
 *
 * @author JoãoVitor
 */
public class PrincipalPresenter implements IObservador {

    public final PrincipalView view;
    private static PrincipalPresenter instancia;
    private final Funcionarios funcionarios;
    private static String log;
    private static String dao;

    @SuppressWarnings("LeakingThisInConstructor")
    private PrincipalPresenter() throws ClassNotFoundException, InstantiationException, IllegalAccessException, Exception {
        this.view = new PrincipalView();
        this.funcionarios = Funcionarios.getInstancia();
        this.view.setVisible(false);
        this.view.setLocationRelativeTo(null);
        this.view.setTitle("Gerenciar Funcionarios");
        this.view.setResizable(false);
        funcionarios.addObservador(this);
        setLabel();

        this.view.getBtncadastrar().addActionListener((ActionEvent e) -> {
            try {
                chamarCadastrarFuncionarioPresenter();
            } catch (InstantiationException ex) {
                Logger.getLogger(PrincipalPresenter.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IllegalAccessException ex) {
                Logger.getLogger(PrincipalPresenter.class.getName()).log(Level.SEVERE, null, ex);
            } catch (Exception ex) {
                Logger.getLogger(PrincipalPresenter.class.getName()).log(Level.SEVERE, null, ex);
            }
        });

        this.view.getBtnlistar().addActionListener((ActionEvent e) -> {
            try {
                chamarListarFuncionarioPresenter();
            } catch (Exception ex) {
                Logger.getLogger(PrincipalPresenter.class.getName()).log(Level.SEVERE, null, ex);
            }
        });

        this.view.getBtnconfiglog().addActionListener((ActionEvent e) -> {
            chamarConfiguraPresenter();
        });

        this.view.setVisible(true);
    }

    public static PrincipalPresenter getInstancia() throws InstantiationException, IllegalAccessException, Exception {
        if (instancia == null) {
            return instancia = new PrincipalPresenter();
        }
        return instancia;
    }

    private void chamarCadastrarFuncionarioPresenter() throws ClassNotFoundException, InstantiationException, IllegalAccessException, Exception {
        ManterFuncionarioPresenter ManterFuncionarioPresenter = new ManterFuncionarioPresenter(null,"Inserir");
        view.getDesktop().add(ManterFuncionarioPresenter.getView());
    }

    private void chamarListarFuncionarioPresenter() throws Exception {
        ListarFuncionarioPresenter listarFuncionarioPresenter = new ListarFuncionarioPresenter();
        view.getDesktop().add(listarFuncionarioPresenter.getView());
    }

    private void setLabel() {
        view.getLabelStatus().setText("Total de Funcionarios Cadastrados:" + numeroDeFuncionario());
    }

    private int numeroDeFuncionario() {
        return funcionarios.numeroFuncionario();
    }

    private void chamarConfiguraPresenter() {
        ConfiguracaoPresenter configuracaoPresenter;
        try {
            configuracaoPresenter = new ConfiguracaoPresenter();
            view.getDesktop().add(configuracaoPresenter.getView());
        } catch (IOException ex) {
            Logger.getLogger(PrincipalPresenter.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public void atualizar(Funcionarios funcionarios) {
        setLabel();
    }

}

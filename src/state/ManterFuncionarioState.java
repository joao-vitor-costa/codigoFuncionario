/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package state;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Funcionario;
import presenter.ManterFuncionarioPresenter;

/**
 *
 * @author JoaoVitor
 */
public abstract class ManterFuncionarioState {

    protected ManterFuncionarioPresenter presenter;

    public ManterFuncionarioState(ManterFuncionarioPresenter presenter) {
        this.presenter = presenter;
        this.presenter.getView().setResizable(false);
       // this.presenter.getView().setVisible(false);

        for (ActionListener l : presenter.getView().getBtncancelar().getActionListeners()) {
            presenter.getView().getBtncancelar().removeActionListener(l);
        }

        for (ActionListener l : presenter.getView().getBtnsalvar().getActionListeners()) {
            presenter.getView().getBtnsalvar().removeActionListener(l);
        }

        this.presenter.getView().getBtncancelar().addActionListener((ActionEvent e) -> {
            btnfechar();
        });

        configuraCaixadeSelecao();

        this.presenter.getView().setVisible(true);

    }

    public void btnfechar() {
        try {
            this.presenter.getView().setVisible(false);
            this.presenter.getView().dispose();
        } catch (Exception ex) {
            Logger.getLogger(ManterFuncionarioPresenter.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void configuraCaixadeSelecao() {
        //Limpo a caixa de combinação
        presenter.getView().getCbcargo().removeAllItems();
        presenter.getView().getCbregiao().removeAllItems();
        presenter.getView().getCbbonus().removeAllItems();

        //Preencho a caixa de combinação de cargo
        presenter.getView().getCbcargo().addItem("");
        presenter.getView().getCbcargo().addItem("Programador");
        presenter.getView().getCbcargo().addItem("Gerente");

        //Preencho a caixa de combinação de cargo
        presenter.getView().getCbregiao().addItem("");
        presenter.getView().getCbregiao().addItem("Brasil");
        presenter.getView().getCbregiao().addItem("Síria");
        presenter.getView().getCbregiao().addItem("Caribe");

        //Preenche combobox
        presenter.getView().getCbbonus().addItem("");
        presenter.getView().getCbbonus().addItem("Assiduidade");
        presenter.getView().getCbbonus().addItem("Generoso");
        presenter.getView().getCbbonus().addItem("Normal");
        presenter.getView().getCbbonus().addItem("Regional");
        presenter.getView().getCbbonus().addItem("Variado");

    }

   

   

    public void limpaCampos() {
        presenter.getView().getTextfalta().setText(null);
        presenter.getView().getTextnome().setText(null);
        presenter.getView().getTxtidade().setText(null);
        presenter.getView().getTxtsalario().setText(null);

    }


    public abstract void inserir();

    public abstract void visualizar(Funcionario funcionario);

    public abstract void editar(Funcionario funcionario);

   

}

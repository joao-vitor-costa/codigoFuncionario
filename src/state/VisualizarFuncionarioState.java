/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package state;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import model.Funcionario;
import presenter.ManterFuncionarioPresenter;

/**
 *
 * @author JoaoVitor
 */
public class VisualizarFuncionarioState extends ManterFuncionarioState {

    @SuppressWarnings("FieldNameHidesFieldInSuperclass")
    ManterFuncionarioPresenter presenter;
    Funcionario funcionario;

    public VisualizarFuncionarioState(ManterFuncionarioPresenter funcionariopresenter, Funcionario funcionario) {
        super(funcionariopresenter);
        this.presenter = funcionariopresenter;
        this.funcionario = funcionario;
        configuraViewPraVisualizacao();
        
        presenter.getView().getBtneditarnovo().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                editar(funcionario);
            }
        });
       
    }

    private void configuraViewPraVisualizacao() {
        presenter.getView().setTitle("Visualizar Funcionario");
        //Limpo a caixa de combinação
      
        presenter.getView().getTextnome().setText(funcionario.getNome());
        presenter.getView().getTextfalta().setText(Integer.toString(funcionario.getFalta()));
        presenter.getView().getTxtidade().setText(Integer.toString(funcionario.getIdade()));
        presenter.getView().getTxtsalario().setText(Double.toString(funcionario.getSalario()));
        presenter.getView().getTxtdependente().setText(Integer.toString(funcionario.getFalta()));
        presenter.getView().getCbbonus().setSelectedItem(funcionario.getNomeBonus());
        presenter.getView().getCbcargo().setSelectedItem(funcionario.getCargo());
        presenter.getView().getCbregiao().setSelectedItem(funcionario.getRegiao());
        
        presenter.getView().getTextnome().setEnabled(false);
        presenter.getView().getTextfalta().setEnabled(false);
        presenter.getView().getTxtidade().setEnabled(false);
        presenter.getView().getTxtsalario().setEnabled(false);
        presenter.getView().getTxtdependente().setEnabled(false);
        presenter.getView().getCbbonus().setEnabled(false);
        presenter.getView().getCbcargo().setEnabled(false);
        presenter.getView().getCbregiao().setEnabled(false);
        presenter.getView().getBtnsalvar().setEnabled(false);
   
    }

    @Override
    public void inserir() {
        throw new UnsupportedOperationException("Não épossivel inserir"); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void visualizar(Funcionario funcionario) {
        throw new UnsupportedOperationException("Funcionario já vizualizado."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void editar(Funcionario funcionario) {
        presenter.getView().getBtneditarnovo().setEnabled(false);
        presenter.setState(new EditarFuncionarioState(presenter, funcionario));
        
    }

}

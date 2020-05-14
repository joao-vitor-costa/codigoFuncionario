/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presenter;

import view.ManterFuncionarioView;
import java.io.IOException;
import model.Funcionario;
import state.EditarFuncionarioState;
import state.InserirFuncionarioState;
import state.ManterFuncionarioState;
import state.VisualizarFuncionarioState;

/**
 *
 * @author JoãoVitor
 */
public class ManterFuncionarioPresenter {

    private final ManterFuncionarioView view;
    private ManterFuncionarioState state;

   

    @SuppressWarnings({"IncompatibleEquals", "ConvertToStringSwitch"})
    public ManterFuncionarioPresenter(Funcionario funcionario, String estado) throws IOException, ClassNotFoundException, InstantiationException, IllegalAccessException, Exception {
        this.view = new ManterFuncionarioView();
        if (estado.equals("Inserir")) {
            setState(new InserirFuncionarioState(this,funcionario));
        } else if (estado.equals("Visualizar")) {
            setState(new VisualizarFuncionarioState(this, funcionario));
        } else if (estado.equals("Editar")) {
            setState(new EditarFuncionarioState(this, funcionario));
        }
    }

    public ManterFuncionarioView getView() {
        return view;
    }

    public void setState(ManterFuncionarioState state) {
        this.state = state;
    }
}

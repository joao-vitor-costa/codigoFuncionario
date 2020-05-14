/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package state;

import collection.Funcionarios;
import java.awt.event.ActionEvent;
import javax.swing.JOptionPane;
import model.Funcionario;
import presenter.ManterFuncionarioPresenter;
import strategybonus.ICalcularBonus;

/**
 *
 * @author JoaoVitor
 */
public class InserirFuncionarioState extends ManterFuncionarioState {

    private String nome, regiao, nomebonus, cargo;
    private int idade, faltas, dependes;
    private double salario;
    private double bonus = 0;
    private Funcionario funcionario;
    private final Funcionarios funcionarios;

    public InserirFuncionarioState(ManterFuncionarioPresenter presenter, Funcionario funcionario) throws ClassNotFoundException, InstantiationException, IllegalAccessException, Exception {
        super(presenter);
        configuraViewPraInclusao();
        funcionarios = Funcionarios.getInstancia();
        this.funcionario = funcionario;
        
        presenter.getView().getBtnsalvar().addActionListener((ActionEvent e) -> {
            inserir();
        });
    }

    private void verificaCampos() throws Exception {

        if (presenter.getView().getTextnome().getText().equals("") || presenter.getView().getTxtidade().getText().equals("") || presenter.getView().getTxtsalario().getText().equals("")
                || presenter.getView().getTextfalta().getText().equals("")) {
            throw new Exception("Preencha todos os campos");
        }
    }

    private void pegaCampos() throws Exception {
        this.cargo = presenter.getView().getCbcargo().getSelectedItem().toString();
        this.regiao = presenter.getView().getCbregiao().getSelectedItem().toString();
        this.nome = presenter.getView().getTextnome().getText();
        this.nomebonus = presenter.getView().getCbbonus().getSelectedItem().toString();
        this.idade = Integer.parseInt(this.presenter.getView().getTxtidade().getText());
        this.salario = Double.parseDouble(this.presenter.getView().getTxtsalario().getText());
        this.faltas = Integer.parseInt(this.presenter.getView().getTextfalta().getText());
        this.dependes = Integer.parseInt(this.presenter.getView().getTxtdependente().getText());
    }

    private void verificaIgual(String nome) throws Exception {
        Funcionarios funcionarios = Funcionarios.getInstancia();
        for (Funcionario f : funcionarios.getFuncionarios()) {
            if (f.getNome().equals(nome)) {
                throw new Exception("Já existe um funcionario com esse nome");
            }
        }
    }

    private void vericaCampoNegativo() throws Exception {
        if ((this.idade <= 0)) {
            throw new Exception("Coloque valores maiores que 0 na idade");
        } else {
            if (this.faltas < 0) {
                throw new Exception("Coloque valores maiores ou igual a 0 no campo falta");
            } else {
                if (this.bonus < 0) {
                    throw new Exception("Coloque valores maiores ou igual a 0 no campo Bonus");
                } else {
                    if (this.salario <= 0) {
                        throw new Exception("Coloque valores maiores que 0 no salario");
                    } else {
                        if (this.dependes <= 0) {
                            throw new Exception("Coloque valores maiores que 0 no salario");
                        }
                    }
                }
            }
        }
    }

    private void configuraViewPraInclusao() {
        presenter.getView().setTitle("Cadastro de Funcionario");

    }

    private void novaInstanciaFuncionario() {
        funcionario = new Funcionario(0, nome, salario, faltas, cargo, idade, regiao, nomebonus, dependes, 0);
    }

    private void gerarBonus() throws ClassNotFoundException, InstantiationException, IllegalAccessException, Exception {
        String nomeInstancia = presenter.getView().getCbbonus().getSelectedItem().toString();
        Class classe = Class.forName("strategybonus.Bonus" + nomeInstancia);
        Object objeto = classe.newInstance();
        ICalcularBonus instanciaBonus = (ICalcularBonus) objeto;
        funcionario.setiCalculaBunos(instanciaBonus);
        funcionario.calculaBonus(0);
    }

    private void addFuncionario() throws Exception {
        verificaIgual(nome);
        novaInstanciaFuncionario();
        gerarBonus();
        limpaCampos();
        funcionarios.setBonus(funcionario);
        funcionarios.addFuncionario(funcionario);
        throw new Exception("Salvo com Sucesso!");

    }

    private void btnSalvar() {
        try {

            if (presenter.getView().getCbbonus().getSelectedItem().toString().equals("Variado")) {
                bonus = 0;
                String nomeBonusX = JOptionPane.showInputDialog(presenter.getView(), "Digite um Valor para bonus variado");
                bonus = Integer.parseInt(nomeBonusX);
            }
            pegaCampos();
            verificaCampos();
            vericaCampoNegativo();
            addFuncionario();
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(presenter.getView(), "Preencha o campo Idade ou Salario ou Falta com valores validos", "Atenção", JOptionPane.WARNING_MESSAGE);
        } catch (Exception ex) {
            funcionario = null;
            JOptionPane.showMessageDialog(presenter.getView(), ex.getMessage(), "Mensagem", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    @Override
    public void inserir() {
        btnSalvar();
    }

    @Override
    public void visualizar(Funcionario funcionario) {
        throw new RuntimeException("Não é possivel Visualizar."); 
    }

    @Override
    public void editar(Funcionario funcionario) {
         throw new RuntimeException("Não é possivel Editar."); 
    }

    

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package state;

import adapterlog.Ilog;
import collection.Funcionarios;
import configuration.Configuracao;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.Properties;
import javax.swing.JOptionPane;
import log.Data;
import log.Hora;
import model.Funcionario;
import model.Log;
import presenter.ManterFuncionarioPresenter;
import strategybonus.ICalcularBonus;

/**
 *
 * @author JoaoVitor
 */
public class EditarFuncionarioState extends ManterFuncionarioState {

    @SuppressWarnings("FieldNameHidesFieldInSuperclass")
    ManterFuncionarioPresenter presenter;
    Funcionario funcionario;
    private String nome, regiao, nomebonus, cargo;
    private int idade, faltas, dependes;
    private double salario;
    private double bonus = 0;

    //Atributos do log
    private int id;
    private String nomeBonuslog;
    private double bonuslog;

    public EditarFuncionarioState(ManterFuncionarioPresenter funcionariopresenter, Funcionario funcionario) {
        super(funcionariopresenter);
        this.presenter = funcionariopresenter;
        this.funcionario = funcionario;
        configuraViewPraEdicao();
        
        presenter.getView().getBtnsalvar().addActionListener((ActionEvent e) -> {
            editar(funcionario);
        });
        
    }

    private void configuraViewPraEdicao() {
        presenter.getView().setTitle("Editar Funcionario");
        
         
        presenter.getView().getTextnome().setEnabled(true);
        presenter.getView().getTextfalta().setEnabled(true);
        presenter.getView().getTxtidade().setEnabled(true);
        presenter.getView().getTxtsalario().setEnabled(true);
        presenter.getView().getTxtdependente().setEnabled(true);
        presenter.getView().getCbbonus().setEnabled(true);
        presenter.getView().getCbcargo().setEnabled(true);
        presenter.getView().getCbregiao().setEnabled(true);
        presenter.getView().getBtnsalvar().setEnabled(true);
        
        //Limpo a caixa de combinação
        presenter.getView().getTextnome().setText(funcionario.getNome());
        presenter.getView().getTextfalta().setText(Integer.toString(funcionario.getFalta()));
        presenter.getView().getTxtidade().setText(Integer.toString(funcionario.getIdade()));
        presenter.getView().getTxtsalario().setText(Double.toString(funcionario.getSalario()));
        presenter.getView().getTxtdependente().setText(Integer.toString(funcionario.getFalta()));
        presenter.getView().getCbbonus().setSelectedItem(funcionario.getNomeBonus());
        presenter.getView().getCbcargo().setSelectedItem(funcionario.getCargo());
        presenter.getView().getCbregiao().setSelectedItem(funcionario.getRegiao());
        
      
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

    private void verificaIgual(String nome) throws Exception {
        Funcionarios funcionarios = Funcionarios.getInstancia();
        for (Funcionario f : funcionarios.getFuncionarios()) {
            if (f.getNome().equals(nome)) {
                throw new Exception("Já existe um funcionario com esse nome");
            }
        }
    }

    private void preparaPreLog() {
        id = funcionario.getId();
        bonuslog = funcionario.getBonus();
        nomeBonuslog = funcionario.getNomeBonus();

    }

    private void gerarBonus() throws ClassNotFoundException, InstantiationException, IllegalAccessException, Exception {
        String nomeInstancia = presenter.getView().getCbbonus().getSelectedItem().toString();
        Class classe = Class.forName("strategybonus.Bonus" + nomeInstancia);
        Object objeto = classe.newInstance();
        ICalcularBonus instanciaBonus = (ICalcularBonus) objeto;
        funcionario.setiCalculaBunos(instanciaBonus);
        funcionario.calculaBonus(0);
    }

    private void editarFuncionario() throws Exception {
        Funcionarios funcionarios = Funcionarios.getInstancia();
        preparaPreLog();
        if (!funcionario.getNome().equals(nome)) {
            verificaIgual(nome);
        }
        funcionario.setCargo(cargo);
        funcionario.setFalta(faltas);
        funcionario.setIdade(idade);
        funcionario.setNomeBonus(nomebonus);
        funcionario.setNome(nome);
        funcionario.setRegiao(regiao);
        funcionario.setDepedentes(dependes);
        gerarBonus();
        if (!nomeBonuslog.equals(funcionario.getNomeBonus())) {
            Hora hora = new Hora();
            Data data = new Data();
            Log log = new Log(data.gerarData(), hora.geraHora(), id, funcionario.getNome(), nomeBonuslog, bonuslog, funcionario.getNomeBonus(), funcionario.getBonus());
            Ilog adpIlog = InstanciaLog();
            adpIlog.gerarLog(log);
        }
        funcionarios.editar(funcionario);
        btnfechar();
        throw new Exception("Salvo com sucesso");

    }

    @SuppressWarnings("UnusedAssignment")
    private Ilog InstanciaLog() throws InstantiationException, IllegalAccessException, ClassNotFoundException, IOException {
        Configuracao configuracao = Configuracao.getInstance();
        Properties properties = Configuracao.properties;
        Class classe = Class.forName(properties.getProperty("log"));
        Object objeto = classe.newInstance();
        Ilog log = (Ilog) objeto;
        return log;
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
            editarFuncionario();
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(presenter.getView(), "Preencha o campo Idade ou Salario ou Falta com valores validos", "Atenção", JOptionPane.WARNING_MESSAGE);
        } catch (Exception ex) {
            funcionario = null;
            JOptionPane.showMessageDialog(presenter.getView(), ex.getMessage(), "Mensagem", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    @Override
    public void inserir() {
        throw new RuntimeException("Não é possivel Inserir.");
    }

    @Override
    public void visualizar(Funcionario funcionario) {
        throw new RuntimeException("Não é possivel Visualizar.");
    }

    @Override
    public void editar(Funcionario funcionario) {
        btnSalvar();
    }

}

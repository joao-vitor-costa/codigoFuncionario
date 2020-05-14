/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presenter;

import collection.Funcionarios;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.Funcionario;
import view.BuscarFuncionarioView;

/**
 *
 * @author JoãoVitor
 */
public class BuscarFuncionarioPresenter {

    private final Funcionarios gerenciarFuncionario;
    private final BuscarFuncionarioView view;
    private final ListarFuncionarioPresenter listarFuncionarioPresenter;

    public BuscarFuncionarioPresenter(ListarFuncionarioPresenter listarFuncionarioPresenter) throws IOException, ClassNotFoundException, InstantiationException, IllegalAccessException, Exception {
        this.listarFuncionarioPresenter = listarFuncionarioPresenter;
        this.gerenciarFuncionario = Funcionarios.getInstancia();
        this.view = new BuscarFuncionarioView();
        this.view.setVisible(false);
        this.view.setTitle("Buscar Funcionarios");
        this.view.setResizable(false);
        view.getCbcampo().removeAllItems();
        view.getCbcampo().addItem("Nome");
        view.getCbcampo().addItem("Idade");
        view.getCbcampo().addItem("Bonus");
        view.getCbcampo().addItem("Cargo");
        view.getCbcampo().addItem("Regiao");
        view.getCbcampo().addItem("Salario");

        this.view.getBtnbuscar().addActionListener((ActionEvent e) -> {
            btnbuscar();
        });

        this.view.getBtncancelar().addActionListener((ActionEvent e) -> {
            btnfechar();
        });

        this.view.setVisible(true);
    }
    
    public BuscarFuncionarioView getView() {
        return view;
    }

    private void btnfechar() {
        try {
            this.view.setVisible(false);
            this.view.dispose();
        } catch (Exception ex) {
            Logger.getLogger(ManterFuncionarioPresenter.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void buscarPorNome(String busca) throws Exception {
        Funcionario funcionario;
        int flag = 0;
        /*DefaultTableModel modelo = (DefaultTableModel) listarFuncionarioPresenter.view.getTabelafuncionarios().getModel();
        for (Funcionario f : this.gerenciarFuncionario.getFuncionarios()) {
            if (f.getNome().equals(busca)) {
                flag = 1;
                funcionario = f;
                modelo.setNumRows(0);

                String nome = funcionario.getNome();
                String cargo = funcionario.getCargo();
                String faltas = Integer.toString(funcionario.getFalta());
                String idade = Integer.toString(funcionario.getIdade());
                String regiao = funcionario.getRegiao();
                String salario = "R$:" + funcionario.getSalario() + "0";
                String bonus = "R$:" + funcionario.getBonus() + "0";
                String tipobonus = funcionario.getNomeBonus();
                double totalSalrio = funcionario.getSalario() + funcionario.getBonus();
                String SalarioBonus = "R$" + totalSalrio + "0";

                modelo.addRow(new Object[]{nome, cargo, faltas, idade, regiao, salario, bonus, tipobonus, SalarioBonus});
            }
        }

        if (flag == 0) {
            throw new Exception("Nenhuma valor encontrado");
        } else {
            btnfechar();
        }*/

    }

    private void buscarPorIdade(int busca) throws Exception {
        Funcionario funcionario;
        int flag = 0;
        DefaultTableModel modelo = (DefaultTableModel) listarFuncionarioPresenter.view.getTabelafuncionarios().getModel();
        for (Funcionario f : this.gerenciarFuncionario.getFuncionarios()) {
            if (f.getIdade() == busca) {
                flag = 1;
                funcionario = f;
                modelo.setNumRows(0);

                String nome = funcionario.getNome();
                String cargo = funcionario.getCargo();
                String faltas = Integer.toString(funcionario.getFalta());
                String idade = Integer.toString(funcionario.getIdade());
                String regiao = funcionario.getRegiao();
                String salario = "R$:" + funcionario.getSalario() + "0";
                String bonus = "R$:" + funcionario.getBonus() + "0";
                String tipobonus = funcionario.getNomeBonus();
                double totalSalrio = funcionario.getSalario() + funcionario.getBonus();
                String SalarioBonus = "R$" + totalSalrio + "0";

                modelo.addRow(new Object[]{nome, cargo, faltas, idade, regiao, salario, bonus, tipobonus, SalarioBonus});
            }
        }

        if (flag == 0) {
            throw new Exception("Nenhuma valor encontrado");
        } else {
            btnfechar();
        }

    }

    private void buscarPorNomeBonus(String busca) throws Exception {
        Funcionario funcionario;
        int flag = 0;
        DefaultTableModel modelo = (DefaultTableModel) listarFuncionarioPresenter.view.getTabelafuncionarios().getModel();
        for (Funcionario f : this.gerenciarFuncionario.getFuncionarios()) {
            if (f.getNomeBonus().equals(busca)) {
                flag = 1;
                funcionario = f;
                modelo.setNumRows(0);
                String nome = funcionario.getNome();
                String cargo = funcionario.getCargo();
                String faltas = Integer.toString(funcionario.getFalta());
                String idade = Integer.toString(funcionario.getIdade());
                String regiao = funcionario.getRegiao();
                String salario = "R$:" + funcionario.getSalario() + "0";
                String bonus = "R$:" + funcionario.getBonus() + "0";
                String tipobonus = funcionario.getNomeBonus();
                double totalSalrio = funcionario.getSalario() + funcionario.getBonus();
                String SalarioBonus = "R$" + totalSalrio + "0";

                modelo.addRow(new Object[]{nome, cargo, faltas, idade, regiao, salario, bonus, tipobonus, SalarioBonus});
            }
        }
        if (flag == 0) {
            throw new Exception("Nenhuma valor encontrado");
        } else {
            btnfechar();
        }

    }

    private void buscarPorRegiao(String busca) throws Exception {
        Funcionario funcionario;
        int flag = 0;
        DefaultTableModel modelo = (DefaultTableModel) listarFuncionarioPresenter.view.getTabelafuncionarios().getModel();
        for (Funcionario f : this.gerenciarFuncionario.getFuncionarios()) {
            if (f.getRegiao().equals(busca)) {
                flag = 1;
                funcionario = f;
                modelo.setNumRows(0);

                String nome = funcionario.getNome();
                String cargo = funcionario.getCargo();
                String faltas = Integer.toString(funcionario.getFalta());
                String idade = Integer.toString(funcionario.getIdade());
                String regiao = funcionario.getRegiao();
                String salario = "R$:" + funcionario.getSalario() + "0";
                String bonus = "R$:" + funcionario.getBonus() + "0";
                String tipobonus = funcionario.getNomeBonus();
                double totalSalrio = funcionario.getSalario() + funcionario.getBonus();
                String SalarioBonus = "R$" + totalSalrio + "0";

                modelo.addRow(new Object[]{nome, cargo, faltas, idade, regiao, salario, bonus, tipobonus, SalarioBonus});
            }
        }

        if (flag == 0) {
            throw new Exception("Nenhuma valor encontrado");
        } else {
            btnfechar();
        }
    }

    private void buscarPorCargo(String busca) throws Exception {
        Funcionario funcionario;
        int flag = 0;
        DefaultTableModel modelo = (DefaultTableModel) listarFuncionarioPresenter.view.getTabelafuncionarios().getModel();
        for (Funcionario f : this.gerenciarFuncionario.getFuncionarios()) {
            if (f.getCargo().equals(busca)) {
                flag = 1;
                funcionario = f;
                modelo.setNumRows(0);

                String nome = funcionario.getNome();
                String cargo = funcionario.getCargo();
                String faltas = Integer.toString(funcionario.getFalta());
                String idade = Integer.toString(funcionario.getIdade());
                String regiao = funcionario.getRegiao();
                String salario = "R$:" + funcionario.getSalario() + "0";
                String bonus = "R$:" + funcionario.getBonus() + "0";
                String tipobonus = funcionario.getNomeBonus();
                double totalSalrio = funcionario.getSalario() + funcionario.getBonus();
                String SalarioBonus = "R$" + totalSalrio + "0";

                modelo.addRow(new Object[]{nome, cargo, faltas, idade, regiao, salario, bonus, tipobonus, SalarioBonus});
            }
        }
        if (flag == 0) {
            throw new Exception("Nenhuma valor encontrado");
        } else {
            btnfechar();
        }
    }

    private void buscarPorSalario(Double busca) throws Exception {
        Funcionario funcionario;
        int flag = 0;
        DefaultTableModel modelo = (DefaultTableModel) listarFuncionarioPresenter.view.getTabelafuncionarios().getModel();
        for (Funcionario f : this.gerenciarFuncionario.getFuncionarios()) {
            if (f.getSalario() == busca) {
                flag = 1;
                funcionario = f;
                modelo.setNumRows(0);

                String nome = funcionario.getNome();
                String cargo = funcionario.getCargo();
                String faltas = Integer.toString(funcionario.getFalta());
                String idade = Integer.toString(funcionario.getIdade());
                String regiao = funcionario.getRegiao();
                String salario = "R$:" + funcionario.getSalario() + "0";
                String bonus = "R$:" + funcionario.getBonus() + "0";
                String tipobonus = funcionario.getNomeBonus();
                double totalSalrio = funcionario.getSalario() + funcionario.getBonus();
                String SalarioBonus = "R$" + totalSalrio + "0";

                modelo.addRow(new Object[]{nome, cargo, faltas, idade, regiao, salario, bonus, tipobonus, SalarioBonus});
            }
        }

        if (flag == 0) {
            throw new Exception("Nenhuma valor encontrado");
        } else {
            btnfechar();
        }
    }

    private void buscarPorFalta(int busca) throws Exception {
        Funcionario funcionario;
        int flag = 0;
        DefaultTableModel modelo = (DefaultTableModel) listarFuncionarioPresenter.view.getTabelafuncionarios().getModel();
        for (Funcionario f : this.gerenciarFuncionario.getFuncionarios()) {
            if (f.getFalta() == busca) {
                flag = 1;
                funcionario = f;
                modelo.setNumRows(0);

                String nome = funcionario.getNome();
                String cargo = funcionario.getCargo();
                String faltas = Integer.toString(funcionario.getFalta());
                String idade = Integer.toString(funcionario.getIdade());
                String regiao = funcionario.getRegiao();
                String salario = "R$:" + funcionario.getSalario() + "0";
                String bonus = "R$:" + funcionario.getBonus() + "0";
                String tipobonus = funcionario.getNomeBonus();
                double totalSalrio = funcionario.getSalario() + funcionario.getBonus();
                String SalarioBonus = "R$" + totalSalrio + "0";

                modelo.addRow(new Object[]{nome, cargo, faltas, idade, regiao, salario, bonus, tipobonus, SalarioBonus});
            }
        }

        if (flag == 0) {
            throw new Exception("Nenhuma valor encontrado");
        } else {
            btnfechar();
        }
    }

    private void btnbuscar() {
        try {
            String campo = view.getCbcampo().getSelectedItem().toString();
            String busca = view.getTxtbuscar().getText();
            if (campo.equals("Nome")) {
                buscarPorNome(busca);
            }

            if (campo.equals("Idade")) {
                int valor;
                try {
                    valor = Integer.parseInt(busca);
                    buscarPorIdade(valor);
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(view, "Coloque um valor Inteiro, não negativo!", "Atenção", JOptionPane.WARNING_MESSAGE);
                }
            }

            if (campo.equals("Falta")) {
                int valor;
                try {
                    valor = Integer.parseInt(busca);
                    buscarPorFalta(valor);
                    btnfechar();
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(view, "Coloque um valor Inteiro, não negativo!", "Atenção", JOptionPane.WARNING_MESSAGE);
                }
            }

            if (campo.equals("Salario")) {
                double valor;
                try {
                    valor = Double.parseDouble(busca);
                    buscarPorSalario(valor);
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(view, "Coloque um valor Inteiro ou real, não negativo!", "Atenção", JOptionPane.WARNING_MESSAGE);
                }
            }

            if (campo.equals("Bonus")) {
                buscarPorNomeBonus(busca);
            }

            if (campo.equals("Regiao")) {
                buscarPorRegiao(busca);
            }

            if (campo.equals("Cargo")) {
                buscarPorCargo(busca);
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(view, e.getMessage(), "Atenção", JOptionPane.WARNING_MESSAGE);
        }

    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presenter;

import collection.Funcionarios;
import java.awt.event.ActionEvent;
import java.util.Iterator;
import javax.swing.JOptionPane;
import view.ListarFuncionarioView;
import javax.swing.table.DefaultTableModel;
import model.Funcionario;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableColumn;
import observer.IObservador;

/**
 *
 * @author JoãoVitor
 */
public class ListarFuncionarioPresenter implements IObservador {

    final ListarFuncionarioView view;
    private Funcionarios gerenciarFuncionario;
    private DefaultTableModel modelo;

    @SuppressWarnings("LeakingThisInConstructor")
    public ListarFuncionarioPresenter() throws Exception {
        this.gerenciarFuncionario = Funcionarios.getInstancia();
        this.view = new ListarFuncionarioView();
        this.view.setVisible(false);
        //this.view.setLocationRelativeTo(null);
        this.view.setTitle("Listar Funcionarios");
        this.view.setResizable(false);
        gerenciarFuncionario.addObservador(this);
        configuraTabela();
        preencheTabela();


        this.view.getBtnbuscar().addActionListener((ActionEvent e) -> {
            btnBuscar();
        });

        this.view.getBtneditar().addActionListener((ActionEvent e) -> {
            btnVisualizar();
        });

        this.view.getBtnremover().addActionListener((ActionEvent e) -> {
            btnRemover();
        });

        this.view.setVisible(true);

    }

    private void configuraTabela() throws Exception {
        try {
            ///Criar modelo          0        1       2     3          4       5          6            7              8
            Object colunas[] = {"Nome", "Cargo", "Faltas", "Idade", "Região", "Salario", "Bonus", "Tipo de Bonus", "Salario(Com Bonus)"};
            DefaultTableModel modelo = new DefaultTableModel(colunas, 0) {
                //Para permitir o duplo click, sem isso o duplo click irá 
                //editar a celular e não dispara o evento de duplo click
                //No caso para visualizar o produto

                @Override
                public boolean isCellEditable(int rowIndex, int mColIndex) {
                    return false;
                }
            };
            this.view.getTabelafuncionarios().setModel(modelo);

            TableColumn colNome = this.view.getTabelafuncionarios().getColumnModel().getColumn(0);
            TableColumn colCargo = this.view.getTabelafuncionarios().getColumnModel().getColumn(1);
            TableColumn colFalta = this.view.getTabelafuncionarios().getColumnModel().getColumn(2);
            TableColumn colIdade = this.view.getTabelafuncionarios().getColumnModel().getColumn(3);
            TableColumn colPais = this.view.getTabelafuncionarios().getColumnModel().getColumn(4);
            TableColumn colSalario = this.view.getTabelafuncionarios().getColumnModel().getColumn(5);
            TableColumn colBonus = this.view.getTabelafuncionarios().getColumnModel().getColumn(6);
            TableColumn colTipoBonus = this.view.getTabelafuncionarios().getColumnModel().getColumn(7);
            TableColumn colSalarioBonus = this.view.getTabelafuncionarios().getColumnModel().getColumn(8);

            //alinhando a tabela preço a direita
            DefaultTableCellRenderer r = new DefaultTableCellRenderer();
            DefaultTableCellRenderer c = new DefaultTableCellRenderer();
            r.setHorizontalAlignment(SwingConstants.RIGHT);
            c.setHorizontalAlignment(SwingConstants.CENTER);

            //formatando as colunas  c = alinhando para o centro, r para a direita
            this.view.getTabelafuncionarios().getColumnModel().getColumn(0).setCellRenderer(c);
            this.view.getTabelafuncionarios().getColumnModel().getColumn(1).setCellRenderer(c);
            this.view.getTabelafuncionarios().getColumnModel().getColumn(2).setCellRenderer(r);
            this.view.getTabelafuncionarios().getColumnModel().getColumn(3).setCellRenderer(r);
            this.view.getTabelafuncionarios().getColumnModel().getColumn(4).setCellRenderer(c);
            this.view.getTabelafuncionarios().getColumnModel().getColumn(5).setCellRenderer(r);
            this.view.getTabelafuncionarios().getColumnModel().getColumn(6).setCellRenderer(r);
            this.view.getTabelafuncionarios().getColumnModel().getColumn(7).setCellRenderer(c);
            this.view.getTabelafuncionarios().getColumnModel().getColumn(8).setCellRenderer(r);

            // alinhando o titulo da tabela pro centro
            ((DefaultTableCellRenderer) this.view.getTabelafuncionarios().getTableHeader().getDefaultRenderer()).setHorizontalAlignment(SwingConstants.CENTER);

            //não deixar arrastar a tabela
            this.view.getTabelafuncionarios().getTableHeader().setReorderingAllowed(false);
        } catch (Exception e) {
            throw new Exception("Não foi possivel configuar a tabela");
        }

    }

    private void preencheTabela() {
        try {
            DefaultTableModel modelo = (DefaultTableModel) this.view.getTabelafuncionarios().getModel();
            modelo.setNumRows(0);
            for (Funcionario funcionario : gerenciarFuncionario.getFuncionarios()) {
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

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this.view, "Não foi possivel configuar a tabela");
        }

    }

    private int pegaLinhaSelecionada() {
        int selecionada = view.getTabelafuncionarios().getSelectedRow();
        return selecionada;
    }

    private Funcionario pegaObjetoSelecionado() throws Exception {
        int linha = pegaLinhaSelecionada();
        if (linha == -1) {
            throw new Exception("Selecione um funcionario");
        }
        Funcionario f;
        Iterator<Funcionario> it = this.gerenciarFuncionario.getFuncionarios().iterator();
        while (it.hasNext()) {
            f = it.next();
            if (view.getTabelafuncionarios().getValueAt(linha, 0).toString().equals(f.getNome())) {
                return f;
            }

        }
        return null;
    }

    @SuppressWarnings("ResultOfObjectAllocationIgnored")
    private void btnVisualizar() {
        try {
            Funcionario funcionario = pegaObjetoSelecionado();
            if (funcionario == null) {
                throw new Exception("Nenhum funcionario selecionado!");
            } else {
                ManterFuncionarioPresenter presenter = new ManterFuncionarioPresenter(funcionario,"Visualizar");
                PrincipalPresenter principal = PrincipalPresenter.getInstancia();
                principal.view.getDesktop().add(presenter.getView());
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(view, e.getMessage());
        }
    }

    @SuppressWarnings("ResultOfObjectAllocationIgnored")
    private void btnBuscar() {
        try {
            BuscarFuncionarioPresenter presenter = new BuscarFuncionarioPresenter(this);
            PrincipalPresenter principal = PrincipalPresenter.getInstancia();
            principal.view.getDesktop().add(presenter.getView());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(view, e.getMessage());
        }
    }

    private void btnRemover() {
        try {
            Funcionario funcionario = pegaObjetoSelecionado();
            if (funcionario == null) {
                throw new Exception("Nenhum funcionario selecionado!");
            } else {
                Object opcoes[] = {"Sim", "Não"};
                int result = JOptionPane.showOptionDialog(null, "Deseja Excluir o Funcionario " + funcionario.getNome() + "?", "ALERTA",
                        JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null, opcoes, opcoes[0]);

                if (result == 0) {
                    gerenciarFuncionario.removerFuncionario(funcionario);
                    throw new Exception("Funcionario removido com sucesso!");
                }
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(view, e.getMessage());
        }

    }

    @Override
    public void atualizar(Funcionarios funcionarios) {
        gerenciarFuncionario = funcionarios;
        preencheTabela();
    }

    public ListarFuncionarioView getView() {
        return view;
    }
}

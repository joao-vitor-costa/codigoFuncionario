/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presenter;

import configuration.Configuracao;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import view.ConfiguracaoView;

/**
 *
 * @author JoãoVitor
 */
public class ConfiguracaoPresenter {

    private final Configuracao config;
    private final ConfiguracaoView view;

    public ConfiguracaoPresenter() throws IOException {
        this.view = new ConfiguracaoView();
        this.config = Configuracao.getInstance();
        this.view.setVisible(false);
        this.view.setTitle("Configurar");
        this.view.setResizable(false);
        configuraCaixaDeSelecao();

        this.view.getBtnconfirmar().addActionListener((ActionEvent e) -> {
            btnConfirmar();
        });

        this.view.getBtnsair().addActionListener((ActionEvent e) -> {
            btnSair();
        });

        this.view.setVisible(true);
    }

    private void btnSair() {
        this.view.setVisible(false);
        this.view.dispose();
    }

    private void confProperties() throws IOException {
        if (this.view.getCbdao().getSelectedItem().toString().equals("SQLite")) {
            config.AtualizarProperties("dao", "daosqlite.FuncionarioDAOSQLite");
        }
        
        if (this.view.getCblog().getSelectedItem().toString().equals("XML")) {
            config.AtualizarProperties("log", "adapterlog.LogXML");
        }
        
        if (this.view.getCblog().getSelectedItem().toString().equals("TXT")) {
            config.AtualizarProperties("log", "adapterlog.LogTXT");
        }

    }

    private void btnConfirmar() {
        try {
            confProperties();
            JOptionPane.showMessageDialog(view, "Sistema configurado com sucesso!", "Atenção", JOptionPane.INFORMATION_MESSAGE);
            btnSair();
        } catch (IOException ex) {
            Logger.getLogger(ConfiguracaoPresenter.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void configuraCaixaDeSelecao() {
        this.view.getCbdao().removeAllItems();
        this.view.getCblog().removeAllItems();

        this.view.getCbdao().addItem("SQLite");
        this.view.getCblog().addItem("TXT");
        this.view.getCblog().addItem("XML");

    }

    public ConfiguracaoView getView() {
        return view;
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import configuration.Configuracao;
import java.io.IOException;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;
import presenter.PrincipalPresenter;

/**
 *
 * @author JoãoVitor
 */
public class Main implements Serializable {

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     *
     */
    public static void main(String[] args) throws IOException {
        Configuracao config = Configuracao.getInstance();
        config.AtualizarProperties("log", "adapterlog.LogXML");
        config.AtualizarProperties("dao", "daosqlite.FuncionarioDAOSQLite");
        try {
            PrincipalPresenter principalpresenter = PrincipalPresenter.getInstancia();
        } catch (IllegalAccessException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
       

    }

}

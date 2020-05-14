/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adapterlog;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import log.TXT;
import model.Log;

/**
 *
 * @author JoãoVitor
 */
public class LogTXT implements Ilog {

    @Override
    public void gerarLog(Log log) {
        TXT logTXT = new TXT();
        try {
            logTXT.gerar(log);
        } catch (IOException ex) {
            Logger.getLogger(LogTXT.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
 

}

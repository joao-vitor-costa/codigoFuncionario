/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adapterlog;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import log.XML;
import model.Log;

/**
 *
 * @author JoãoVitor
 */
public class LogXML implements Ilog{

    
    @Override
    public void gerarLog(Log log) {
        XML logXML = new XML();
        try {
            logXML.gerar(log);
        } catch (IOException ex) {
            Logger.getLogger(LogXML.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}

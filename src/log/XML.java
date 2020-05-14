/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package log;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import model.Log;

/**
 *
 * @author JoãoVitor
 */
public final class XML {

    
    private final XStream xstream;

    public XML() {
        xstream = new XStream(new DomDriver());
        
    }

    @SuppressWarnings("ConvertToTryWithResources")
    public void gerar(Log log) throws IOException {
        @SuppressWarnings("UnusedAssignment")
        PrintWriter print = null;
        try {
            File file = new File("src/data/logXML.xml");
            print = new PrintWriter(file);
            String xml = xstream.toXML(log);
            print.write(xml);
            print.flush();
            print.close();
            
        } catch (IOException e) {
        }
    }
}

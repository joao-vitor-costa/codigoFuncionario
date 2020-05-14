/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package configuration;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

/**
 *
 * @author JoãoVitor
 */
public class Configuracao {

    private static Configuracao instance = null;
    public static Properties properties;

    private Configuracao() throws IOException {
        properties = new Properties();
        lerProperties();
    }

    public static Configuracao getInstance() throws IOException {
        if (instance == null) {
            instance = new Configuracao();
        }

        return instance;
    }

    private void lerProperties() throws IOException {
        properties.load(new FileInputStream("src/configuration/config.properties"));
    }

    public void AtualizarProperties(String key, String value) throws IOException {
        FileOutputStream out = new FileOutputStream("src/configuration/config.properties");
        lerProperties();
        properties.setProperty(key, value);
        properties.store(out, null);
    }

}

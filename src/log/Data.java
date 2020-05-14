/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package log;

import java.text.SimpleDateFormat;

/**
 *
 * @author JoãoVitor
 */
public final class Data {
    private final String d;
    
    public Data(){
       d = gerarData();
    }
            

    public String gerarData() {
        String formato = "dd/MM/yyyy";
        String data;
        java.util.Date date = new java.util.Date();
        SimpleDateFormat formata = new SimpleDateFormat(formato);
        data = formata.format(date);
        return data;
    }

}

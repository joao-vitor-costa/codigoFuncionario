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
public final class Hora {

    private final String h;

    public Hora() {
        h = geraHora();
    }

    public String geraHora() {
        String formato = "h:mm - a";
        String hora;
        java.util.Date date = new java.util.Date();
        SimpleDateFormat formata = new SimpleDateFormat(formato);
        hora = formata.format(date);
        return hora;
    }

}

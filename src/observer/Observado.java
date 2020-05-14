/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package observer;

import java.util.ArrayList;

/**
 *
 * @author JoãoVitor
 */
abstract public class Observado {
    ArrayList<IObservador> observadores;

    public Observado() {
        this.observadores = new ArrayList<>();
    }
    
    public void addObservador(IObservador observador){};
    public void removerObservador(IObservador observador){};
    public void notificar(){};
}

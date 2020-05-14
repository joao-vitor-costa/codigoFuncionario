/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author JoãoVitor
 */
public class Log {

    private final String data,hora;
    private final int id;
    private final String Fucionario;
    private final String NomeBonusAntigo;
    private final double valorAntigo;
    private final String NomeBonusNovo;
    private final double valorNovo;

    public Log(String data, String hora, int id, String Fucionario, String NomeBonusAntigo, double valorAntigo, String NomeBonusNovo, double valorNovo) {
        this.data = data;
        this.hora = hora;
        this.id = id;
        this.Fucionario = Fucionario;
        this.NomeBonusAntigo = NomeBonusAntigo;
        this.valorAntigo = valorAntigo;
        this.NomeBonusNovo = NomeBonusNovo;
        this.valorNovo = valorNovo;
    }

    public String getData() {
        return data;
    }

    public String getHora() {
        return hora;
    }

    public int getId() {
        return id;
    }

    public String getFucionario() {
        return Fucionario;
    }

    public String getNomeBonusAntigo() {
        return NomeBonusAntigo;
    }

    public double getValorAntigo() {
        return valorAntigo;
    }

    public String getNomeBonusNovo() {
        return NomeBonusNovo;
    }

    public double getValorNovo() {
        return valorNovo;
    }

   
    
    
   
    
}
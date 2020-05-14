/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import strategybonus.ICalcularBonus;

/**
 *
 * @author JoãoVitor
 */
public class Funcionario{

    private final int id; //Pk do banco de dados
    private String nome;
    private double salario;
    private int falta;
    private double bonus;
    private String nomeBonus;
    private String cargo;
    private int idade;
    private String regiao;
    private int depedentes;
    private ICalcularBonus iCalculaBunos;

    public Funcionario(int id,String nome, double salario, int falta, String cargo, int idade, String Regiao, String nomeBonus,int depedentes,double bonus) {
        this.id = id;
        this.nome = nome;
        this.salario = salario;
        this.falta = falta;
        this.cargo = cargo;
        this.idade = idade;
        this.regiao = Regiao;
        this.nomeBonus = nomeBonus;
        this.depedentes = depedentes;
        this.bonus = bonus;
    }
    
    public void setiCalculaBunos(ICalcularBonus iCalculaBunos) {
        this.iCalculaBunos = iCalculaBunos;
    }

    public void calculaBonus(double valorOpcional) throws Exception {
        iCalculaBunos.tratarBonus(this,valorOpcional);
    }

    public int getDepedentes() {
        return depedentes;
    }

    public void setDepedentes(int depedentes) {
        this.depedentes = depedentes;
    }

    public int getId() {
        return id;
    }
    
    public double getSalario() {
        return salario;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setRegiao(String regiao) {
        this.regiao = regiao;
    }

    public String getNome() {
        return nome;
    }

    public String getRegiao() {
        return regiao;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public int getFalta() {
        return falta;
    }

    public void setFalta(int falta) {
        this.falta = falta;
    }

    public double getBonus() {
        return bonus;
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }

    public String getNomeBonus() {
        return nomeBonus;
    }

    public void setNomeBonus(String nomeBonus) {
        this.nomeBonus = nomeBonus;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

}


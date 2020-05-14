/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package strategybonus;


import model.Funcionario;

/**
 *
 * @author JoãoVitor
 */
public interface ICalcularBonus {
    public void tratarBonus(Funcionario funcionario,double valorVariavel) throws Exception;
    //public boolean aceitar(Funcionario funcionario) throws Exception;
}

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
public class BonusNormal implements ICalcularBonus{

    @Override
    public void tratarBonus(Funcionario funcionario,double valorVariavel) throws Exception  {
        double bonus = funcionario.getSalario()*0.05;
        funcionario.setBonus(bonus);
       
    }

  

}

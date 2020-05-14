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
public class BonusRegional implements ICalcularBonus {

    @Override
    public void tratarBonus(Funcionario funcionario, double valorVariavel) throws Exception {
        if (funcionario.getRegiao().equals("Brasil")) {
            double bonus = funcionario.getSalario() * 0.05;
            funcionario.setBonus(bonus);

        } else {
            if (funcionario.getRegiao().equals("Síria")) {
                double bonus = funcionario.getSalario() * 1;
                funcionario.setBonus(bonus);
            } else {
                if (funcionario.getRegiao().equals("Caribe")) {
                    double bonus = funcionario.getSalario() * 0;
                    funcionario.setBonus(bonus);
                }
            }
        }

    }

  
}

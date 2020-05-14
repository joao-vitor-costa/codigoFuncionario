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
public class BonusAssiduidade implements ICalcularBonus {

    @Override
    public void tratarBonus(Funcionario funcionario, double valorVariavel) throws Exception {
        if (funcionario.getFalta() == 0) {
            double bonus = funcionario.getSalario() * 0.05;
            funcionario.setBonus(bonus);
        } else {
            if ((funcionario.getFalta() >= 1) && (funcionario.getFalta() <= 5)) {
                double bonus = funcionario.getSalario() * 0.02;
                funcionario.setBonus(bonus);
            } else {
                if (funcionario.getFalta() > 5) {
                    double bonus = funcionario.getSalario() * 0;
                    funcionario.setBonus(bonus);
                }

            }

        }

    }

   
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package abstractfactory;

import dao.IDAOFuncionario;
import java.io.IOException;

/**
 *
 * @author JoãoVitor
 */
public class FabricaAbstrata {

    private static FabricaAbstrata instancia = null;

    public static FabricaAbstrata getInstance() throws IOException {
        if (instancia == null) {
            instancia = new FabricaAbstrata();
        }

        return instancia;
    }

    public IDAOFuncionario fabricaDAO(String nome) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        Class classe = Class.forName(nome);
        Object objeto = classe.newInstance();
        IDAOFuncionario  fabrica = (IDAOFuncionario) objeto;
        return fabrica;
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package log;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JOptionPane;
import model.Log;

/**
 *
 * @author JoãoVitor
 */
public final class TXT {

    private final File arquivo;

    public TXT() {
        this.arquivo = new File("src/data/logTXT.txt");
    }

    @SuppressWarnings("ConvertToTryWithResources")
    public void gerar(Log log) throws IOException {
        try {

            FileWriter w = new FileWriter(arquivo, true);
            BufferedWriter bf = new BufferedWriter(w);
            bf.write("LOG de edição");
            bf.newLine();
            bf.write("Data: " + log.getData() + " Hora: " + log.getHora());
            bf.newLine();
            bf.write("Funcionario: " + log.getFucionario() + "ID: " + log.getId());
            bf.newLine();
            bf.write("Bonus Antigo: " + log.getNomeBonusAntigo() + "Valor: " + log.getValorAntigo());
            bf.newLine();
            bf.write("Bonus novo: " + log.getNomeBonusNovo() + "Valor: " + log.getValorNovo());
            bf.newLine();
            bf.write("Fim do LOG");
            bf.newLine();
            bf.newLine();

            bf.close();
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }

    }
}

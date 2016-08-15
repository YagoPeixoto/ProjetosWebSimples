package br.yago;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Refeicao {
    
    private int refeicao = 20;

    public int getRefeicao() {
        return refeicao;
    }

    public synchronized void comer(int valor, String cliente) {
        if (refeicao >= valor) {
            System.out.println(cliente + " vai comer");
            try {
                System.out.println("esperando");
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(Refeicao.class.getName()).log(Level.SEVERE, null, ex);
            }
            refeicao -= valor;
            String msg = cliente + "Comeu: " + valor +  " | Refeição disponível: " + refeicao;
            System.out.println(msg);
        }else{
            System.out.println("Comida foi insuficiente");
        }

    }

}

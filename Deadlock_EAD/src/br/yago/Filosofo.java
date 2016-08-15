package br.yago;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Filosofo implements Runnable {

    Refeicao refeicao;
    private int fome = 3;
    private boolean temHashi;

    public Filosofo(Refeicao refeicao) {
        this.refeicao = refeicao;
    }

    @Override
    public void run() {
        String nomeFilosofo = Thread.currentThread().getName();
        while (refeicao.getRefeicao() > 0) {
            if (temHashi) {
                refeicao.comer(1, nomeFilosofo);
            } else {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Filosofo.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

        }

    }

    public int getFome() {
        return fome;
    }

    public void setFome(int fome) {
        this.fome = fome;
    }

    public boolean isTemHashi() {
        return temHashi;
    }

    public void setTemHashi(boolean temHashi) {
        this.temHashi = temHashi;
    }

}

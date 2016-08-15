package br.yago;

public class Main {

    static Refeicao refeicao = new Refeicao();

    public static void main(String[] args) {
        Filosofo filosofo1 = new Filosofo(refeicao);
        Filosofo filosofo2 = new Filosofo(refeicao);
        Filosofo filosofo3 = new Filosofo(refeicao);
        Filosofo filosofo4 = new Filosofo(refeicao);
        Filosofo filosofo5 = new Filosofo(refeicao);

        Hashi hashi = new Hashi(0, filosofo1, filosofo2,
        		filosofo3, filosofo4, filosofo5);

        Thread primeiro = new Thread(filosofo1, "Primeiro");
        Thread segundo = new Thread(filosofo2, "Segundo");
        Thread terceiro = new Thread(filosofo3, "Terceiro");
        Thread quarto = new Thread(filosofo4, "Quarto");
        Thread quinto = new Thread(filosofo5, "Quinto");

        hashi.start();
        primeiro.start();
        segundo.start();
        terceiro.start();
        quarto.start();
        quinto.start();

        while (!hashi.isInterrupted()) {
            if (refeicao.getRefeicao() < 1) {
                hashi.interrupt();
            }
        }

    }

}

package br.yago;

public class Hashi extends Thread implements Runnable {

    int contador = 1;

    Filosofo filosofo1;
    Filosofo filosofo2;
    Filosofo filosofo3;
    Filosofo filosofo4;
    Filosofo filosofo5;

    public Hashi(int contador, Filosofo filosofo1, Filosofo filosofo2, Filosofo filosofo3, Filosofo filosofo4,
			Filosofo filosofo5) {
		super();
		this.contador = contador;
		this.filosofo1 = filosofo1;
		this.filosofo2 = filosofo2;
		this.filosofo3 = filosofo3;
		this.filosofo4 = filosofo4;
		this.filosofo5 = filosofo5;
	}

	@Override
    public void run() {

        try {
            while (!Thread.interrupted()) {
            	filosofo1.setTemHashi(true);
                Thread.sleep(2000);
                filosofo1.setTemHashi(false);

                filosofo2.setTemHashi(true);
                Thread.sleep(2000);
                filosofo2.setTemHashi(false);

                filosofo3.setTemHashi(true);
                Thread.sleep(2000);
                filosofo3.setTemHashi(false);

                filosofo4.setTemHashi(true);
                Thread.sleep(2000);
                filosofo4.setTemHashi(false);

                filosofo5.setTemHashi(true);
                Thread.sleep(2000);
                filosofo5.setTemHashi(false);
                filosofo1.setTemHashi(true);
            }
        } catch (InterruptedException ex) {
            System.out.println("O jantar foi finalizado");
        }

    }

}

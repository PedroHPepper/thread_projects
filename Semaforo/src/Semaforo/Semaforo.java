package Semaforo;

import java.util.concurrent.Semaphore;
//Primeiro definir uma implementa��o de Thread
public class Semaforo extends Thread {
    private int idThread;
    private Semaphore semaforo;
 
    public Semaforo(int id, Semaphore semaphore) {
        this.idThread = id;
        this.semaforo = semaphore;
    }
//Definimos inicialmente um identificador para a nossa Thread
//Agora vamos definir os m�todos da nossa Thread, dentro da classe Semaforo
private void processar() {
    try {
        System.out.println("Thread #" + idThread + " Amarelo");
        Thread.sleep((long) (Math.random() * 10000));
    } catch (Exception e) {
        e.printStackTrace();
    }
}
//Este m�todo processar() apenas faz a thread dormir por algum tempo, simulando o efeito de um processamento longo
private void entrarRegiaoNaoCritica() {
    System.out.println("Thread #" + idThread + " Entrando no Vermelho");
    processar();
}
//Este m�todo simula o acesso da Thread em uma regi�o n�o cr�tica,exibimos o atual estado da Thread, para facilitar o entendimento do progama, e realizamos um processamento qualquer
private void entrarRegiaoCritica() {
    System.out.println("Thread #" + idThread
            + " Entrando no Vermelho");
    processar();
    System.out.println("Thread #" + idThread + " Entrando no Verde");
    
}
public void run() {
    entrarRegiaoNaoCritica();
    try {
        semaforo.acquire();
        entrarRegiaoCritica();
    } catch (InterruptedException e) {
        e.printStackTrace();
    } finally {
        semaforo.release();
    }
}
public static void main(String[] args) {
    int numeroDePermicoes = 2;
    int numeroDeProcessos = 6;
    Semaphore semaphore = new Semaphore(numeroDePermicoes);
    Semaforo[] processos = new Semaforo[numeroDeProcessos];
    for (int i = 0; i < numeroDeProcessos; i++) {
        processos[i] = new Semaforo(i, semaphore);
        processos[i].start();
    }
}
}
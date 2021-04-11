/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jantarfilosofos;

import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;



/**
 *
 * @author Cliente
 */
public class Filosofos {
    public class Garfos extends Thread{
        private final int garfoEsquerda;
        private final int garfoDireita;
        
        public Garfos(int garfoEsquerda, int garfoDireita){
            this.garfoDireita = garfoDireita;
            this.garfoEsquerda = garfoEsquerda;
        }
        
        public void Run(){
            while(true){
                try{
                    sorteioDireita();
                    sorteioEsquerda();
                    Thread.sleep(1000);
                }catch(InterruptedException e){
                    System.out.println(e);
                }
            }
        }
        
        public void sorteioDireita(){
            int garfoDireita;
            Random d = new Random();
            garfoDireita = d.nextInt();
            
            System.out.println("O garfo da direita foi sorteado "+ garfoDireita);
        }
        
        public void sorteioEsquerda(){
            int garfoEsquerda;
            Random d = new Random();
            garfoEsquerda = d.nextInt();
            
            System.out.println("O garfo da esquerda foi sorteado "+ garfoEsquerda);
        }
        
    }
    
    public class Filosofo extends Thread{
        String nome; 
        Garfos garfo;
        int lugarMesa;
        
        public Filosofo(String nome, Garfos garfo, int lugarMesa){
            this.nome = nome;
            this.lugarMesa = lugarMesa;
            this.garfo = garfo;
            
            System.out.println("O filosofo "+ nome+ " sentou na mesa.");
        }
        public void Pensar() throws InterruptedException{
            System.out.println("O filosofo "+ nome+ " está pensando.");
            Thread.sleep(3000);
        }
        
        @Override
        public void run(){
            while(true){
                
                if(garfo.garfoDireita==5){
                    System.out.println("O filosofo "+ nome+ " pegou o garfo " +garfo.garfoDireita);
                    if(garfo.garfoEsquerda ==1){
                        System.out.println("O filosofo "+ nome+ " pegou o garfo " +garfo.garfoEsquerda);
                        System.out.println("O filosofo "+ nome+ " está comendo");
                        System.out.println("O filosofo "+ nome+ " largou o garfo da direita");
                        System.out.println("O filosofo "+ nome+ " largou o garfo da esquerda");
                    }else{
                        System.out.println("O filosofo "+ nome+ " largou o garfo "+garfo.garfoDireita);
                    }
                }else{
                    try{
                        Pensar();
                    }catch(InterruptedException ex){
                        Logger.getLogger(Filosofos.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                if(garfo.garfoDireita==1){
                    System.out.println("O filosofo "+ nome+ " pegou o garfo " +garfo.garfoDireita);
                    if(garfo.garfoEsquerda ==2){
                        System.out.println("O filosofo "+ nome+ " pegou o garfo " +garfo.garfoEsquerda);
                        System.out.println("O filosofo "+ nome+ " está comendo");
                        System.out.println("O filosofo "+ nome+ " largou o garfo da direita");
                        System.out.println("O filosofo "+ nome+ " largou o garfo da esquerda");
                    }else{
                        System.out.println("O filosofo "+ nome+ " largou o garfo "+garfo.garfoDireita);
                    }
                }else{
                    try{
                        Pensar();
                    }catch(InterruptedException ex){
                        Logger.getLogger(Filosofos.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                if(garfo.garfoDireita==3){
                    System.out.println("O filosofo "+ nome+ " pegou o garfo " +garfo.garfoDireita);
                    if(garfo.garfoEsquerda ==4){
                        System.out.println("O filosofo "+ nome+ " pegou o garfo " +garfo.garfoEsquerda);
                        System.out.println("O filosofo "+ nome+ " está comendo");
                        System.out.println("O filosofo "+ nome+ " largou o garfo da direita");
                        System.out.println("O filosofo "+ nome+ " largou o garfo da esquerda");
                    }else{
                        System.out.println("O filosofo "+ nome+ " largou o garfo "+garfo.garfoDireita);
                    }
                }else{
                    try{
                        Pensar();
                    }catch(InterruptedException ex){
                        Logger.getLogger(Filosofos.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                if(garfo.garfoDireita==4){
                    System.out.println("O filosofo "+ nome+ " pegou o garfo " +garfo.garfoDireita);
                    if(garfo.garfoEsquerda ==5){
                        System.out.println("O filosofo "+ nome+ " pegou o garfo " +garfo.garfoEsquerda);
                        System.out.println("O filosofo "+ nome+ " está comendo");
                        System.out.println("O filosofo "+ nome+ " largou o garfo da direita");
                        System.out.println("O filosofo "+ nome+ " largou o garfo da esquerda");
                    }else{
                        System.out.println("O filosofo "+ nome+ " largou o garfo "+garfo.garfoDireita);
                    }
                }else{
                    try{
                        Pensar();
                    }catch(InterruptedException ex){
                        Logger.getLogger(Filosofos.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                    
                
            }
        }
        
    }
    public void test(){
        Garfos g1 = new Garfos(1,5);
        Garfos g2 = new Garfos(2,1);
        Garfos g3 = new Garfos(3,2);
        Garfos g4 = new Garfos(4,3);
        Garfos g5 = new Garfos(5,4);
        
        Filosofo filosofo1 = new Filosofo("Platão", g1, 1);
        Filosofo filosofo2 = new Filosofo("Aristóteles", g2, 2);
        Filosofo filosofo3 = new Filosofo("Sócrates", g3, 3);
        Filosofo filosofo4 = new Filosofo("Descartes", g4, 4);
        Filosofo filosofo5 = new Filosofo("Euclides", g5, 5);
        
        new Thread(filosofo1).start();
        new Thread(filosofo2).start();
        new Thread(filosofo3).start();
        new Thread(filosofo4).start();
        new Thread(filosofo5).start();
        
    }
    
}

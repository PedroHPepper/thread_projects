/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package barbeiro;

import java.util.Random;

/**
 *
 * @author Cliente
 */
public class Barbeiro implements Runnable{
    
    private int waitingChair; //defines how many people will wait
    boolean ocupiedChair = false; // false = free;  true = ocupied
    int[] clients; //random number of clients
    boolean barberSleeps = false; // false = awake; true = sleeps
    private String name; // thread name
    private int newClients; //random até o numero maximo de clientes
    int nClients; //inicialização da variável total de clientes
    
    Barbeiro(String name, int waitingChair, int clients){
        this.newClients = clients; // initializes the maximum number of clients
        this.name = name; // nome do barbeiro
        this.waitingChair = waitingChair;
        
        System.out.println("Barbeiro "+name+" chegou no salão.");
    }
    
    public void Clients(){
        Random r = new Random(); //generates random clients number
        this.nClients = r.nextInt(this.newClients);// generates the total clients number
        this.clients = new int[this.nClients];// give the size to the vector
        
        for(int i = 0; this.nClients<this.clients.length; i++){
            this.clients[i] = i;
        }
    }
    
    public void BarberSleeps() throws InterruptedException{
        System.out.println("Ainda não chegaram clientes no salão. O barbeiro está esperando!!!");
        Thread.sleep(5000);//espera por 2 segundos
        System.out.println("A cadeira do barbeiro está livre");
        
        Clients();
    }
    
    public void BarberAwakes() throws InterruptedException{
        
        if(this.nClients!=0){ //the if initiates if there are clients
            if(this.nClients > 1 && this.ocupiedChair == false){//if there is moe clients and we have allowed chairs
                System.out.println(this.nClients + " entrou ou entraram no salão.");
            }else{
                System.out.println(this.nClients + " está(ão) esperando pelo atendimento");
            }
            System.out.println("Um cliente ocupou a cadeira do Barbeiro "+this.name);
            this.nClients--;//serving client and decrementing the number of clients
            System.out.println("Um cliente está sendo atendido pelo barbeiro " + this.name);
            this.ocupiedChair = true;//barber chair is occupied now
            
            Thread.sleep(6000);
            
            if(this.nClients > this.waitingChair){
                //verifying how many clients are going away
                int cli = this.nClients - this.waitingChair;
                //verifying how many clients are waiting
                this.nClients = this.nClients - cli;
                
                //while the counter is less than the number of clients, the vector is will be 0
                for(int i = 0; i < this.clients.length - 1; i++){
                    this.clients[i] = 0;
                }
                //updates total clients number
                for(int j = 0; j < this.nClients; j++){
                    this.clients[j] = j + 1;
                }
                System.out.println(cli + " clientes foram embora");
                System.out.println(this.nClients+ " clientes estão esperando");
            }
            System.out.println("Um cliente já foi atendido.");
        }else if(this.nClients == 1){
            System.out.println("A cadeira do barbeiro "+ this.name+" está livre.");
            System.out.println("A cadeira do barbeiro agora está ocupada e não tem clientes esperando.");
            Thread.sleep(1000);
            
            System.out.println("Um cliente já foi atendido pelo barbeiro");
        }else{
            System.out.println("A cadeira do barbeiro "+this.name+" está livre.");
            this.ocupiedChair = false;
        }
        
    }
    
    
    @Override
    public void run() {
        while(true){
            if(this.nClients <=0){
                try{
                    BarberSleeps();
                }catch(InterruptedException e){
                    System.out.println(e);
                }
            }else{
                try{
                    BarberAwakes();
                }catch(InterruptedException e){
                    System.out.println(e);
                }
            }
        }
    }
    
    
    
}

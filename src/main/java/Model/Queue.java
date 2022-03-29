package Model;

import java.util.Collections;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.atomic.*;

public class Queue implements Runnable{

    BlockingQueue<Client> clients ;
    AtomicInteger waitingPeriod;
    String name;

    public Queue(int NrMaxClients) {
        clients =new ArrayBlockingQueue<Client>(NrMaxClients);
        waitingPeriod = new AtomicInteger(0);
    }

    public void addClient(Client newClient){
        clients.add(newClient);
        waitingPeriod.addAndGet(newClient.getServiceTime());
    }

    public void run(){
        while(true){
            if(!clients.isEmpty()) {
                int CurrTaskTime = clients.element().getServiceTime();
                waitingPeriod.addAndGet(-CurrTaskTime);
                try {
                    Thread.sleep(clients.element().getServiceTime() * 1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                clients.remove(clients.element());
            }
        }
    }

}





















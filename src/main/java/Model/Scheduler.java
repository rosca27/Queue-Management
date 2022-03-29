package Model;

import View.LogView;

import java.util.ArrayList;
import java.util.List;

public class Scheduler {
    LogView log = new LogView();
    private int NrMaxQueues;
    private Strategy strategy;
    public int waitingTime = 0;
    private List<Queue> queues = new ArrayList<Queue>();
    public Scheduler(LogView log ,int NrMaxQueues, int NrMaxClientsServer){
        this.log = log;
        for(int i = 0; i < NrMaxQueues; i++){
            Queue q = new Queue(NrMaxClientsServer);
            q.name= String.valueOf(i+1);
            queues.add(q);
            waitingTime += q.waitingPeriod.get();
            Thread c = new Thread(q);
            c.start();
        }
    }

    public void Strategy(ServicePolicy policy){

        if(policy == ServicePolicy.SHORTEST_QUEUE){
            strategy = new ShortesQueueStrategy();
        }
        if(policy == ServicePolicy.SHORTEST_TIME){
            strategy = new SmallestTimeStrategy();
        }
    }
    public synchronized void dispatchTask(Client t){
        strategy.addTask(log,queues,t);
    }
    public List<Queue> getServers(){
        return queues;
    }

}

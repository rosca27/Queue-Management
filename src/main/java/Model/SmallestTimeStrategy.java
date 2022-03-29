package Model;

import View.LogView;

import java.util.List;

public class SmallestTimeStrategy implements Strategy{
    LogView log = new LogView();
    @Override
    public void addTask(LogView log,List<Queue> queues, Client c) {
        this.log = log;
        int min = 99999;
        for(Queue i : queues){
            if(i.waitingPeriod.get() < min)
            {
                min = i.waitingPeriod.get();
            }
        }
        for(Queue i : queues){
            if(i.waitingPeriod.get() == min)
            {
                i.addClient(c);
                log.addText("Clientul " + c.getId() + " " + c.getArrivalTime() + " " + c.getServiceTime() + " a fost plasat in coada: " + i.name + " !");
                break;
            }
        }
    }
}

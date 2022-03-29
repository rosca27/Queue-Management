package Model;

import View.LogView;

import java.util.List;

public class ShortesQueueStrategy implements Strategy{
    LogView log = new LogView();

    @Override
    public void addTask(LogView log, List<Queue> queues, Client c) {
        this.log = log;
        int min = 9999;
        for(Queue i : queues){
            if(i.clients.size()<min) {
                min = i.clients.size();
            }
        }
        for(Queue i : queues){
            if (min == i.clients.size()){
                i.addClient(c);
                log.addText("Clientul " + c.getId() + " " + c.getArrivalTime() + " " + c.getServiceTime() + " a fost plasat in coada: " + i.name + " !");
                break;
            }
        }

    }
}

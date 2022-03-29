package Model;

import View.LogView;
import View.QueueManagementView;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;


public class SimulationManager implements Runnable{

    public int timeLimit ;
    public int maxProcessingtime;
    public int minProcessingtime;
    public int queuesNumber;
    public int clientsNumber;
    public int minArrivalTime;
    public int maxArrivalTime ;
    public ServicePolicy policy;
    private Scheduler scheduler;
    private List<Client> generatedClients;
    private List<Queue> queues ;
    private int averageTime = 0;
    LogView log = new LogView();

    public SimulationManager(LogView log,int timeLimit, int maxProcessingtime, int minProcessingtime, int queuesNumber, int clientsNumber, int minArrivalTime, int maxArrivalTime, ServicePolicy policy) {
        this.log = log;
        this.timeLimit = timeLimit;
        this.maxProcessingtime = maxProcessingtime;
        this.minProcessingtime = minProcessingtime;
        this.queuesNumber = queuesNumber;
        this.clientsNumber = clientsNumber;
        this.minArrivalTime = minArrivalTime;
        this.maxArrivalTime = maxArrivalTime;
        this.policy = policy;
        scheduler = new Scheduler(log,queuesNumber,clientsNumber);
        scheduler.Strategy(policy);
        generatedClients = Collections.synchronizedList(new ArrayList<Client>());
        generateNRandomTask();
        queues = scheduler.getServers();
    }

    private synchronized void generateNRandomTask(){

        generatedClients = Collections.synchronizedList(new ArrayList<Client>());

        for(int i = 1; i <= clientsNumber; i++){
            int ArrivalTime =(int) (Math.random() * (maxArrivalTime-minArrivalTime) + minArrivalTime);
            int ProcessingTime =(int) (Math.random() * (maxProcessingtime-minProcessingtime) + minProcessingtime);
            Client c = new Client(i,ArrivalTime,ProcessingTime);
            generatedClients.add(c);
            Collections.sort(generatedClients, new Comparator<Client>() {
                @Override
                public int compare(Client o1, Client o2) {
                    if(o1.getArrivalTime() < o2.getArrivalTime())
                        return -1;
                    if(o1.getArrivalTime() == o2.getArrivalTime())
                        return 0;
                    if(o1.getArrivalTime() > o2.getArrivalTime())
                        return 1;
                return 0;
                }
            });
        }
    }

    @Override
    public synchronized void run() {
        int currTime = 0;
        int time = 0;
        int k = 0;
        List<Client> list = new ArrayList<Client>();
        int k2= 0;
        while(currTime < timeLimit){

            System.out.println(currTime);
            for(Client i : generatedClients) {
                if (i.getArrivalTime() == currTime) {
                    k2++;
                    scheduler.dispatchTask(i);
                    averageTime += i.getServiceTime();
                    log.setWaitingTime(averageTime/k2);
                }
                list.add(i);
            }
            log.setTime(currTime);
            currTime++;
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

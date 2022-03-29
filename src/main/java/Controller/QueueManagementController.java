package Controller;


import Model.Scheduler;
import Model.ServicePolicy;
import Model.SimulationManager;
import View.LogView;
import View.QueueManagementView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class QueueManagementController {

    private QueueManagementView view = new QueueManagementView();

    int timeLimit;
    int maxProcessingtime;
    int minProcessingtime;
    int queuesNumber;
    int clientsNumber;
    int minArrivalTime;
    int maxArrivalTime;
    ServicePolicy policy;

    public QueueManagementController(QueueManagementView view) {

        view.StartButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                LogView log = new LogView();
                timeLimit = view.getSimulationTime();
                maxProcessingtime = view.getMaxArrivalTime();
                minProcessingtime = view.getMinArrivalTime();
                queuesNumber = view.getNrQueues();
                clientsNumber = view.getNrClients();
                minArrivalTime = view.getMinServiceTime();
                maxArrivalTime = view.getMaxServiceTime();
                if(view.getStrategy().compareTo("SHORTEST_TIME") == 0)
                    policy = ServicePolicy.SHORTEST_TIME;
                else
                    policy = ServicePolicy.SHORTEST_QUEUE;
                log.frame.setVisible(true);
                SimulationManager gen = new SimulationManager(log,timeLimit,maxProcessingtime,minProcessingtime,queuesNumber,clientsNumber,minArrivalTime,maxArrivalTime,policy);
                Thread t  =new Thread(gen);
                t.start();
            }
        });
    }

}

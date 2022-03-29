package Model;

import View.LogView;

import java.util.List;

public interface Strategy {
    public void addTask(LogView log,List<Queue> queues, Client c);
}

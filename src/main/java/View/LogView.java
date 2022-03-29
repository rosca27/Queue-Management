package View;

import javax.swing.*;
import java.awt.*;

public class LogView extends JPanel {
    public JScrollPane logList;
    public JLabel titleLabel;
    public JLabel waitingTimeLabel;
    public JTextField waitingTimeText;
    public JTextField timeText;
    public JLabel timeLabel;
    public JTextArea logText;
    public JFrame frame = new JFrame("LogView");

    public LogView() {

        logText = new JTextArea(1000,1);
        logList = new JScrollPane (logText);
        titleLabel = new JLabel ("Live log");
        waitingTimeLabel = new JLabel ("Waiting time:");
        waitingTimeText = new JTextField (0);
        timeText = new JTextField (0);
        timeLabel = new JLabel ("Time:");


        frame.setSize(360,480);
        frame.setResizable(false);
        frame.setLayout(null);

        timeText.setEditable(false);
        waitingTimeText.setEditable(false);


        frame.add(logList);
        frame.add(titleLabel);
        frame.add(waitingTimeLabel);
        frame.add(waitingTimeText);
        frame.add(timeText);
        frame.add(timeLabel);


        logList.setBounds (30, 135, 285, 275);
        titleLabel.setBounds (145, 15, 100, 25);
        waitingTimeLabel.setBounds (30, 60, 100, 25);
        waitingTimeText.setBounds (30, 90, 100, 25);
        timeText.setBounds (215, 90, 100, 25);
        timeLabel.setBounds (220,60 , 100, 25);
    }


    public synchronized void setTime(int time){
        timeText.setText(String.valueOf(time));
    }

    public synchronized void addText(String text){
        logText.append(text + "\n");
    }

    public synchronized void setWaitingTime(int waitngTime){
        waitingTimeText.setText(String.valueOf(waitngTime));
    }

}

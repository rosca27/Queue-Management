package View;

import javax.swing.*;
import java.awt.*;
import java.util.Objects;
import Model.SimulationManager;

public class QueueManagementView extends JPanel {
     JLabel NrClientsLabel;
     JLabel TitleLabel;
     JLabel NrQueuesLabel;
     JLabel MinArrivalLabel;
     JLabel MaxArrivalLabel;
     JLabel SimTimeLabel;
     JComboBox NrClientsCombo;
     JComboBox NrQueuesCombo;
     JLabel MinServiceLabel;
     JLabel MaxServiceLabel;
     JTextField MinArrivalText;
     JTextField MaxArrivalText;
     JTextField SimTimeText;
     JTextField MinServiceText;
     JComboBox ServicePolicyCombo;
     JLabel ServicePolicyLabel;
     public JButton StartButton;
     JTextField MaxServiceText;
     public JFrame frame;

    public QueueManagementView() {

        String[] NrClientsComboItems = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31", "32", "33", "34", "35", "36", "37", "38", "39", "40", "41", "42", "43", "44", "45", "46", "47", "48", "49", "50", "51", "52", "53", "54", "55", "56", "57", "58", "59", "60", "61", "62", "63", "64", "65", "66", "67", "68", "69", "70", "71", "72", "73", "74", "75", "76", "77", "78", "79", "80", "81", "82", "83", "84", "85", "86", "87", "88", "89", "90", "91", "92", "93", "94", "95", "96", "97", "98", "99", "100"};
        String[] NrQueuesComboItems = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10"};
        String[] ServicePolicyComboItems = {"SHORTEST_TIME", "SHORTEST_QUEUE"};

        frame = new JFrame ("MyPanel");
        frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setBackground(Color.white);
        frame.setSize(new Dimension (760, 500));
        frame.setResizable(false);
        NrClientsLabel = new JLabel ("Number of clients:");
        TitleLabel = new JLabel ("Queue management system ");
        NrQueuesLabel = new JLabel ("Number of queues:");
        MinArrivalLabel = new JLabel ("Min arrival time:");
        MaxArrivalLabel = new JLabel ("Max arrival time:");
        SimTimeLabel = new JLabel ("Simulation time:");
        NrClientsCombo = new JComboBox (NrClientsComboItems);
        NrQueuesCombo = new JComboBox (NrQueuesComboItems);
        MinServiceLabel = new JLabel ("Min service time:");
        MaxServiceLabel = new JLabel ("Max service time:");
        MinArrivalText = new JTextField ();
        MaxArrivalText = new JTextField ();
        SimTimeText = new JTextField ();
        MinServiceText = new JTextField ();
        MaxServiceText = new JTextField();
        ServicePolicyCombo = new JComboBox (ServicePolicyComboItems);
        ServicePolicyLabel = new JLabel ("Service policy:");
        StartButton = new JButton ("Start");


        NrQueuesCombo.setFocusable(false);
        NrClientsCombo.setFocusable(false);
        ServicePolicyCombo.setFocusable(false);
        frame.setLayout (null);
        frame.add(NrClientsLabel);
        frame.add(TitleLabel);
        frame.add(NrQueuesLabel);
        frame.add(MinArrivalLabel);
        frame.add(MaxArrivalLabel);
        frame.add(SimTimeLabel);
        frame.add(NrClientsCombo);
        frame.add(NrQueuesCombo);
        frame.add(MinServiceLabel);
        frame.add(MaxServiceLabel);
        frame.add(MinArrivalText);
        frame.add(MaxArrivalText);
        frame.add(SimTimeText);
        frame.add(MinServiceText);
        frame.add(MaxServiceText);
        frame.add(ServicePolicyCombo);
        frame.add(ServicePolicyLabel);
        frame.add(StartButton);

        TitleLabel.setFont(new Font("Times New Roman",Font.ITALIC, 25));
        NrClientsLabel.setBounds (165, 115, 110, 25);
        TitleLabel.setBounds (270, 35, 370, 40);
        NrQueuesLabel.setBounds (395, 115, 110, 25);
        MinArrivalLabel.setBounds (30, 195, 100, 25);
        MaxArrivalLabel.setBounds (275, 195, 100, 25);
        SimTimeLabel.setBounds (505, 195, 100, 25);
        NrClientsCombo.setBounds (280, 115, 65, 25);
        NrQueuesCombo.setBounds (520, 115, 65, 25);
        MinServiceLabel.setBounds (135, 265, 100, 25);
        MaxServiceLabel.setBounds (380, 265, 100, 25);
        MinArrivalText.setBounds (130, 195, 100, 25);
        MaxArrivalText.setBounds (380, 195, 100, 25);
        SimTimeText.setBounds (610, 195, 100, 25);
        MinServiceText.setBounds (245, 265, 100, 25);
        MaxServiceText.setBounds (495, 265, 100, 25);
        ServicePolicyCombo.setBounds (340, 330, 150, 25);
        ServicePolicyLabel.setBounds (225, 330, 100, 25);
        StartButton.setBounds (325, 390, 125, 40);
    }
    public synchronized int getNrClients() {
        return Integer.parseInt((String) Objects.requireNonNull(NrClientsCombo.getSelectedItem()));
    }

    public synchronized int getNrQueues() {
        return Integer.parseInt((String) Objects.requireNonNull(NrQueuesCombo.getSelectedItem()));
    }

    public synchronized String getStrategy(){
        return Objects.requireNonNull(ServicePolicyCombo.getSelectedItem()).toString();
    }

    public synchronized int getMinArrivalTime(){
        return Integer.parseInt((String) MinArrivalText.getText());
    }

    public synchronized int getMaxArrivalTime(){
        return Integer.parseInt((String) MaxArrivalText.getText());
    }

    public synchronized int getMinServiceTime(){
        return Integer.parseInt((String) MinServiceText.getText());
    }

    public synchronized int getMaxServiceTime(){
        return Integer.parseInt((String) MaxServiceText.getText());
    }

    public  synchronized int getSimulationTime(){
        return Integer.parseInt((String) SimTimeText.getText());
    }

    public static void main(String[] args) {
        QueueManagementView c = new QueueManagementView();
    }
}

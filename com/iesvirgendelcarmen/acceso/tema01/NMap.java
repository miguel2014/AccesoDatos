/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.iesvirgendelcarmen.acceso.tema01;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;

/**
 *
 * @author juangu
 */
public class NMap extends JFrame implements ActionListener
{
    private JLabel prompt;
    private JLabel portNo;
    private JSpinner portInput;
    private JTextField hostInput;
    private JTextArea report;
    private JButton seekButton, exitButton;
    private JPanel hostPanel, buttonPanel;
    private static Socket socket = null;
    
    public static void main(String[] args) {
        NMap frame = new NMap();
        frame.setSize(600, 300);
        frame.setVisible(true);
        frame.addWindowListener(
                new WindowAdapter() {
                    public void windowClosing(
                            WindowEvent event) {
                //Check whether a socket is open...
                                if (socket != null) {
                                    try {
                                        socket.close();
                                    } catch (IOException ioEx) {
                                        System.out.println(
                                                "\nUnable to close link!\n");
                                        System.exit(1);
                                    }
                                }
                                System.exit(0);
                            }

                   }
        );
    }
    
    public NMap() {
        hostPanel = new JPanel();
        prompt = new JLabel("Host name: ");
        hostInput = new JTextField("cisco", 25);
        portNo = new JLabel("Max Port (0..): ");
        // portInput = new JTextField("25", 5);
        SpinnerModel spinnerModel =
            new SpinnerNumberModel(
                        25, //initial value
                        0, //min
                        65535, //max
                        1);//step
        portInput = new JSpinner (spinnerModel);
        hostPanel.add(prompt);
        hostPanel.add(hostInput);
        hostPanel.add(portNo);
        hostPanel.add(portInput);
        add(hostPanel, BorderLayout.NORTH);
        report = new JTextArea(10, 25);
        add(report, BorderLayout.CENTER);
        buttonPanel = new JPanel();
        seekButton = new JButton("Seek server ports ");
        seekButton.addActionListener(this);
        buttonPanel.add(seekButton);
        exitButton = new JButton("Exit");
        exitButton.addActionListener(this);
        buttonPanel.add(exitButton);
        add(buttonPanel, BorderLayout.SOUTH);
    }

    public void actionPerformed(ActionEvent event) {
        if (event.getSource() == exitButton) {
            System.exit(0);
        }
//Must have been the 'seek' button that was
//pressed, so clear the output area of any
//previous output...
        report.setText("");
//Retrieve the URL from the input text field...
        String host = hostInput.getText();
        try {
//Convert the URL string into an INetAddress
//object...
            InetAddress theAddress
                    = InetAddress.getByName(host);
            report.append("IP address: "
                    + theAddress + "\n");
            for (int i = 0; i < (Integer)portInput.getValue(); i++) {
                try {
//Attempt to establish a socket on
//port i...
                    socket = new Socket(host, i);
//If no IOException thrown, there must
//be a service running on the port...
                    report.append(
                            "There is a server on port "
                            + i + ".\n");
                    socket.close();
                } catch (IOException ioEx) {
                }// No server on this port
            }
        } catch (UnknownHostException uhEx) {
            report.setText("Unknown host!");
        }
    }

}

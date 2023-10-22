package ASimulatorSystem;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class Transactions extends JFrame implements ActionListener{

	JButton deposit, withdrawl, ministatement, pinchange,fastcash, balanceenquiry,exit;
	String pinnumber;
    Transactions(String pinnumber){
        this.pinnumber=pinnumber;
        setLayout(null);
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("ASimulatorSystem/icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1000, 1180, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 960,1080);
        add(image);
        
        JLabel text = new JLabel("Please Select Your Transaction");
        text.setBounds(235,400,700,35);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System", Font.BOLD, 16));
        image.add(text);
        
         deposit =new JButton("Deposit");
        deposit.setBounds(170,499,150,35);
        deposit.addActionListener(this);
        image.add(deposit);
        
         withdrawl =new JButton("Cash withdrawl");
        withdrawl.setBounds(390,499,150,35);
        withdrawl.addActionListener(this);
        image.add(withdrawl);
        
         fastcash =new JButton("Fash Cash");
        fastcash.setBounds(170,543,150,35);
        fastcash.addActionListener(this);
        image.add(fastcash);
        
         ministatement =new JButton("Mini Statement");
         ministatement.setBounds(390,543,150,35);
         ministatement.addActionListener(this);
        image.add(ministatement);
        
         pinchange =new JButton("Pin Change");
        pinchange.setBounds(170,588,150,35);
        pinchange.addActionListener(this);
        image.add(pinchange);
        
         balanceenquiry =new JButton("Balance Enquiry");
        balanceenquiry.setBounds(390,588,150,35);
        balanceenquiry.addActionListener(this);
        image.add(balanceenquiry);
        
        exit =new JButton("Exit");
        exit.setBounds(390,633,150,35);
        exit.addActionListener(this);
        image.add(exit);
        
        
        setSize(960, 1080);
        setLocation(500,0);       
        setUndecorated(true);
        setVisible(true);
        
       
        
       
        
    }
    public void actionPerformed(ActionEvent ae) {
    	if (ae.getSource() == exit) {
    		System.exit(0);
    	} else if (ae.getSource () == deposit) {
    		setVisible(false);
    		new Deposit(pinnumber).setVisible(true);
    	}else if (ae.getSource() == withdrawl) {
    		setVisible(false);
    		new Withdrawl(pinnumber).setVisible(true);
    		
    	} else if (ae.getSource()== fastcash) {
    		setVisible(false);
    		new FastCash(pinnumber).setVisible(true);
    	} else if (ae.getSource()== pinchange) {
    		setVisible(false);
    		new PinChange(pinnumber).setVisible(true);
    	}else if (ae.getSource()== balanceenquiry) {
    		setVisible(false);
    		new BalanceEnquiry(pinnumber).setVisible(true);
    	}
    	else if (ae.getSource()== ministatement) {
    		
    		new MiniStatement(pinnumber).setVisible(true);
    	}
    }
    
    
    
    
    public static void main(String[] args){
        new Transactions("");
    }
}
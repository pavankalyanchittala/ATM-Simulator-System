package ASimulatorSystem;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import java.util.Date;

public class FastCash extends JFrame implements ActionListener {

	JButton deposit, withdraw, ministatement, pinchange,fastcash, balanceenquiry,exit;
	String pinnumber;
	FastCash(String pinnumber){
        this.pinnumber=pinnumber;
        setLayout(null);
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("ASimulatorSystem/icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1000, 1180, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 960,1080);
        add(image);
        
        JLabel text = new JLabel("SELECT WITHDRAWL AMOUNT");
        text.setBounds(235,400,700,35);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System", Font.BOLD, 16));
        image.add(text);
        
         deposit =new JButton("Rs 100");
        deposit.setBounds(170,499,150,35);
        deposit.addActionListener(this);
        image.add(deposit);
        
         withdraw =new JButton("Rs 500");
        withdraw.setBounds(390,499,150,35);
        withdraw.addActionListener(this);
        image.add(withdraw);
        
         fastcash =new JButton("Rs 1000");
        fastcash.setBounds(170,543,150,35);
        fastcash.addActionListener(this);
        image.add(fastcash);
        
         ministatement =new JButton("Rs 2000");
         ministatement.setBounds(390,543,150,35);
         ministatement.addActionListener(this);
        image.add(ministatement);
        
         pinchange =new JButton("Rs 5000");
        pinchange.setBounds(170,588,150,35);
        pinchange.addActionListener(this);
        image.add(pinchange);
        
         balanceenquiry =new JButton("Rs 10000");
        balanceenquiry.setBounds(390,588,150,35);
        balanceenquiry.addActionListener(this);
        image.add(balanceenquiry);
        
         exit =new JButton("BACK");
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
    		setVisible(false);
    		new Transactions(pinnumber).setVisible(true);
    		} else {
    			String amount =((JButton)ae.getSource()).getText().substring(3);
    		    Conn c= new Conn();
    		    try {
    		    	ResultSet rs = c.s.executeQuery("select *from bank where pin = '"+pinnumber+"'");
    		    	int balance =0;
    		    	while(rs.next()) {
    		    		if (rs.getString("type").equals("Deposit")) {
    		    			balance += Integer.parseInt(rs.getString("amount"));
    		    		} else {
    		    			balance -= Integer.parseInt(rs.getString("amount"));
    		    		}
    		    		
    		    	}
    		    	
    		    	if (ae.getSource() != exit && balance < Integer.parseInt(amount)) {
    		    		 JOptionPane.showMessageDialog(null, "Insufficient Balance");
    		    		 return;
    		    	}
    		    	Date date = new Date();
    		    	String query = " insert into bank values('"+pinnumber+"', '"+date+"', 'Withdrawl', '"+amount+"')";
    		    	c.s.executeUpdate(query);
    		    	JOptionPane.showMessageDialog(null, "Rs"+ amount+ "Debited Sucessfully");
    		    	
    		    	setVisible(false);
    		    	new Transactions(pinnumber).setVisible(true);
    		    } catch (Exception e) {
    		    	System.out.println(e);
    		    
    	}
    		
    	}
    }
    
    
    
    
    public static void main(String[] args){
        new FastCash("");
    }
}

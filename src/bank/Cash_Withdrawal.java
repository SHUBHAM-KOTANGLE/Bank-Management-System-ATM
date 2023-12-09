package bank;

import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Cash_Withdrawal extends JFrame implements ActionListener{

	JButton withdraw,back;
	JTextField amount;
	String pint;
	 Cash_Withdrawal(String pint) {
		 this.pint=pint;
			setLayout(null);

			ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
			Image i2 = i1.getImage().getScaledInstance(900, 800, Image.SCALE_DEFAULT);
			ImageIcon i3 = new ImageIcon(i2);
			JLabel image = new JLabel(i3);
			image.setBounds(0, 0, 900, 800);
			add(image);
			
			JLabel heading =new JLabel("MAXIMUM WITHRAWAL IS RS.10000");
			heading.setBounds(200, 240, 400, 50);
			heading.setFont(new Font("", Font.BOLD, 16));
			heading.setForeground(getForeground().WHITE);
			image.add(heading);
			
			JLabel newpin =new JLabel("PLEASE ENTER YOUR AMOUNT");
			newpin.setBounds(170, 300, 400, 50);
			newpin.setFont(new Font("", Font.BOLD, 12));
			newpin.setForeground(getForeground().WHITE);
			image.add(newpin);
			
			 amount=new JTextField();
			 amount.setBounds(170, 350, 335, 25);
			image.add(amount);
			

			withdraw = new JButton("WITHDRAW");
			withdraw.setBounds(355, 430, 150, 25);
			withdraw.addActionListener(this);
			image.add(withdraw);

			back = new JButton("Back");
			back.setBounds(355, 460, 150, 25);
			back.addActionListener(this);
			image.add(back);

			setSize(900, 800);
			setVisible(true);
			setLocation(225, 0);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==withdraw) {
			String amtnumber=amount.getText();
			Date date=new Date();
			Conn con=new Conn();
			try {
				ResultSet rs=con.s.executeQuery("select * from bank where pin='"+pint+"'");
				int balance=0;
				while (rs.next()) {
					
					if(rs.getString("type").equals("Deposit")) {
						balance += Integer.parseInt(rs.getString("amount"));
						
					}else {
						balance -= Integer.parseInt(rs.getString("amount"));
					}
				
				if(balance >=Integer.parseInt(amtnumber)) {
					String query="insert into bank values('"+pint+"','"+date+"','withdraw','"+amtnumber+"')";
					con.s.executeUpdate(query);
					JOptionPane.showMessageDialog(null, "Successfully withdrawal RS. "+amtnumber);
					setVisible(false);
					new Transactions(pint).setVisible(true);
				}else {
				
					JOptionPane.showMessageDialog(null, "Insufficient Balance");
				}
					
				}
				
			
				
				
			} catch (Exception e2) {
				e2.printStackTrace();
			}
			
			
		}else if(e.getSource()==back){
			setVisible(false);
			new Transactions(pint).setVisible(true);
			
		}
		

	
	}
	public static void main(String[] args) {
		new Cash_Withdrawal("");

	}



}

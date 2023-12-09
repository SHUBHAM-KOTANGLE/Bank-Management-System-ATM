package bank;

import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Deposit extends JFrame implements ActionListener {

	JButton deposit,back;
	JTextField amount;
	String pint;
	Deposit(String pint) {
		this.pint=pint;
		setLayout(null);

		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
		Image i2 = i1.getImage().getScaledInstance(900, 800, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel image = new JLabel(i3);
		image.setBounds(0, 0, 900, 800);
		add(image);
		
		JLabel heading =new JLabel("ENTER AMOUNT YOU WANT TO DEPOSIT");
		heading.setBounds(170, 270, 400, 50);
		heading.setFont(new Font("", Font.BOLD, 15));
		heading.setForeground(getForeground().WHITE);
		image.add(heading);
		
		
		 amount=new JTextField();
		 amount.setBounds(170, 320, 335, 25);
		image.add(amount);
		

		deposit = new JButton("DEPOSIT");
		deposit.setBounds(355, 430, 150, 25);
		deposit.addActionListener(this);
		image.add(deposit);

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
		
		if(e.getSource()==deposit) {
			String amtnumber=amount.getText();
			Date date=new Date();
			try {
				Conn con=new Conn();
				String query="insert into bank values('"+pint+"','"+date+"','Deposit','"+amtnumber+"')";
				con.s.executeUpdate(query);
				JOptionPane.showMessageDialog(null, "Successfully Deposited RS. "+amtnumber);
				setVisible(false);
				new Transactions(pint).setVisible(true);
				
				
			} catch (Exception e2) {
				e2.printStackTrace();
			}
			
			
		}else if(e.getSource()==back){
			setVisible(false);
			new Transactions(pint).setVisible(true);
			
		}
		

	}

	public static void main(String[] args) {
		new Deposit("");
	}

}

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



public class Fast_Cash extends JFrame implements ActionListener {

	JButton back,rs100,rs500,rs1000,rs2000,rs5000,rs10000;
	String pint;
	Fast_Cash(String pint) {
		this.pint=pint;
		setLayout(null);

		ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
		Image i2=i1.getImage().getScaledInstance(900, 800, Image.SCALE_DEFAULT); 
		ImageIcon i3=new ImageIcon(i2);
		JLabel image=new JLabel(i3);
		image.setBounds(0, 0, 900, 800);
		add(image);
		
		JLabel headingf=new JLabel("SELECT WITHDRAWL AMOUNT");
		headingf.setBounds(200, 250, 400, 50);
		headingf.setFont(new Font("", Font.BOLD, 18));
		headingf.setForeground(getForeground().white );
		image.add(headingf);
		
		 rs100=new JButton("Rs 100");
		rs100.setBounds(170, 370, 150, 25);
		rs100.addActionListener(this);
		image.add(rs100);
		
		 rs500=new JButton("Rs 500");
		rs500.setBounds(355, 370, 150, 25);
		rs500.addActionListener(this);
		image.add(rs500);
		
		
		 rs1000=new JButton("Rs 1000");
		rs1000.setBounds(170, 400, 150, 25);
		rs1000.addActionListener(this);
		image.add(rs1000);
		
		
		 rs2000=new JButton("Rs 2000");
		rs2000.setBounds(355, 400, 150, 25);
		rs2000.addActionListener(this);
		image.add(rs2000);
		
		
		 rs5000=new JButton("Rs 5000");
		rs5000.setBounds(170, 430, 150, 25);
		rs5000.addActionListener(this);
		image.add(rs5000);
		
		
		 rs10000=new JButton("Rs 10000");
		rs10000.setBounds(355, 430, 150, 25);
		rs10000.addActionListener(this);
		image.add(rs10000);
		
		 back=new JButton("Back");
		 back.setBounds(355, 460, 150, 25);
		 back.addActionListener(this);
		image.add(back);
		
		setSize(900,800);
		setVisible(true);
		setLocation(225,0);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==back) {
			setVisible(false);
			new Transactions(pint).setVisible(true);;
			
		}else {
			String amount=((JButton) e.getSource()).getText().substring(3);
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
					
					if (e.getSource() != back && balance < Integer.parseInt(amount)) {
						
						JOptionPane.showMessageDialog(null, "Insufficient Balance");
						return;
						
					} 
					Date date =new Date();
					String query="insert into bank values('"+pint+"','"+date+"','withdraw','"+amount+"')";
					con.s.executeUpdate(query);
					JOptionPane.showMessageDialog(null, "RS. "+amount+"Debited Successfully");
					
					setVisible(false);
					new Transactions(pint).setVisible(true);
				}
				
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		
	
	}

	public static void main(String[] args) {
		new Fast_Cash("");

	}

	
}

package bank;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;

public class Signupthree extends JFrame implements ActionListener {

	JButton submit, cancel;
	JCheckBox Acknowledgement, s1, s2, s3, s4, s5, s6;
	JRadioButton t4, t3, t2, t1;
	String text;
	Signupthree(String text) {
	    this.text=text;
		setLayout(null);

		JLabel heading = new JLabel("Page 3: Account Details");
		heading.setBounds(170, 50, 500, 50);
		heading.setFont(new Font("", Font.BOLD, 38));
		add(heading);

		JLabel type = new JLabel("Account Type");
		type.setBounds(75, 130, 250, 50);
		type.setFont(new Font("", Font.BOLD, 18));
		add(type);

		t1 = new JRadioButton("Saving Account");
		t1.setBounds(75, 170, 150, 30);
		t1.setBackground(Color.WHITE);
		add(t1);

		t2 = new JRadioButton("Fixed Deposit Account");
		t2.setBounds(230, 170, 200, 30);
		t2.setBackground(Color.WHITE);
		add(t2);

		t3 = new JRadioButton("Current Account");
		t3.setBounds(75, 200, 150, 30);
		t3.setBackground(Color.WHITE);
		add(t3);

		t4 = new JRadioButton("Recurring Deposit Account");
		t4.setBounds(230, 200, 250, 30);
		t4.setBackground(Color.WHITE);
		add(t4);

		ButtonGroup typeg = new ButtonGroup();
		typeg.add(t1);
		typeg.add(t2);
		typeg.add(t3);
		typeg.add(t4);

		JLabel cardn = new JLabel("Card Number                  XXXX-XXXX-XXXX-4184");
		cardn.setBounds(75, 290, 600, 50);
		cardn.setFont(new Font("", Font.BOLD, 18));
		add(cardn);

		JLabel y16 = new JLabel("Your 16 Digit Card Number");
		y16.setBounds(75, 307, 200, 50);
		y16.setFont(new Font("", Font.BOLD, 10));
		add(y16);

		JLabel pint = new JLabel("pint                                   XXXX");
		pint.setBounds(75, 350, 400, 50);
		pint.setFont(new Font("", Font.BOLD, 18));
		add(pint);

		JLabel y4 = new JLabel("Your 4 Digit Password");
		y4.setBounds(75, 367, 200, 50);
		y4.setFont(new Font("", Font.BOLD, 10));
		add(y4);

		JLabel Services = new JLabel("Services Required:");
		Services.setBounds(75, 420, 200, 50);
		Services.setFont(new Font("", Font.BOLD, 18));
		add(Services);

		s1 = new JCheckBox("ATM Card");
		s1.setBounds(75, 470, 150, 30);
		s1.setBackground(Color.WHITE);
		add(s1);

		s2 = new JCheckBox("Internet Banking");
		s2.setBounds(230, 470, 150, 30);
		s2.setBackground(Color.WHITE);
		add(s2);

		s3 = new JCheckBox("Mobile Banking");
		s3.setBounds(75, 520, 150, 30);
		s3.setBackground(Color.WHITE);
		add(s3);

		s4 = new JCheckBox("EMAIL & SMS Alert");
		s4.setBounds(230, 520, 150, 30);
		s4.setBackground(Color.WHITE);
		add(s4);

		s5 = new JCheckBox("Check Book");
		s5.setBounds(75, 570, 150, 30);
		s5.setBackground(Color.WHITE);
		add(s5);

		s6 = new JCheckBox("E-Statement");
		s6.setBounds(230, 570, 150, 30);
		s6.setBackground(Color.WHITE);
		add(s6);

		Acknowledgement = new JCheckBox(
				"I hereby declares that the above entered deatils are correct to the best of my knowledge");
		Acknowledgement.setBounds(75, 620, 550, 30);
		Acknowledgement.setBackground(Color.WHITE);
		add(Acknowledgement);

		cancel = new JButton("Cancel");
		cancel.setBounds(300, 670, 80, 30);
		cancel.addActionListener(this);
		add(cancel);

		submit = new JButton("Submit");
		submit.setBounds(390, 670, 80, 30);
		submit.addActionListener(this);
		add(submit);

		setSize(800, 760);
		setVisible(true);
		setLocation(250, 2);
		getContentPane().setBackground(Color.WHITE);
		setTitle("Page 3: Account Details");

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == submit) {
			String type = null;
			if (t1.isSelected()) {
				type = "Saving Account";
			} else if (t2.isSelected()) {
				type = "Fixed Deposit Account";
			} else if (t3.isSelected()) {
				type = "Current Account";
			} else if (t4.isSelected()) {
				type = "Recurring Deposit Account";
			}

			Random random = new Random();
			String cardno16 = "" + Math.abs(random.nextLong() % 90000000L + 503443280000000L);

			String pint = "" + Math.abs(random.nextLong() % 9000L + 1000L);

			String Services = "";
			if (s1.isSelected()) {
				Services = Services + " ATM Card";
			} else if (s2.isSelected()) {
				Services = Services + " Internet Banking";
			} else if (s3.isSelected()) {
				Services = Services + " Mobile Banking";
			} else if (s4.isSelected()) {
				Services = Services + " EMAIL & SMS Alert";
			} else if (s5.isSelected()) {
				Services = Services + " Check Book";
			} else if (s6.isSelected()) {
				Services = Services + " E-Statement";
			}
			
			try {
				Conn con=new Conn();
				String insertthree="insert into signupthree values('"+text+"','"+type+"','"+cardno16+"','"+pint+"','"+Services+"')";
				con.s.executeUpdate(insertthree);
				
				String login="insert into login values('"+text+"','"+cardno16+"','"+pint+"')";
				con.s.executeUpdate(login);
				
				JOptionPane.showMessageDialog(null, "Your Card NO: "+cardno16 +"\n pint: " +pint);
				
				setVisible(false);
				new Deposit(pint).setVisible(true);
				
				
			} catch (Exception e2) {
				
				e2.printStackTrace();
			}
			

		} else if (e.getSource() == cancel) {
			
			setVisible(false);

		}

	}

	public static void main(String[] args) {

		new Signupthree("");

	}

}

package bank;

import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Balance_Enquiery extends JFrame implements ActionListener {

	JButton back;
	String pint;

	Balance_Enquiery(String pint) {
		this.pint = pint;
		setLayout(null);

		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
		Image i2 = i1.getImage().getScaledInstance(900, 800, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel backimage = new JLabel(i3);
		backimage.setBounds(0, 0, 900, 800);
		add(backimage);

		Conn c = new Conn();
		try {
			ResultSet rs = c.s.executeQuery("select * from bank where pin='" + pint + "'");
			int balance = 0;
			while (rs.next()) {

				if (rs.getString("type").equals("Deposit")) {
					balance += Integer.parseInt(rs.getString("amount"));

				} else {
					balance -= Integer.parseInt(rs.getString("amount"));
				}

			}
			JLabel heading = new JLabel("Your Currect Account Balance is Rs: " + balance);
			heading.setBounds(190, 250, 400, 50);
			heading.setFont(new Font("", Font.BOLD, 15));
			heading.setForeground(getForeground().WHITE);
			backimage.add(heading);

			back = new JButton("Back");
			back.setBounds(355, 460, 150, 25);
			back.addActionListener(this);
			backimage.add(back);

		} catch (Exception e) {
			e.printStackTrace();
		}

		setSize(900, 800);
		setVisible(true);
		setLocation(225, 0);
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if(e.getSource()==back) {
			setVisible(false);
			new Transactions(pint).setVisible(true);
		}
		
	}

	public static void main(String[] args) {
		new Balance_Enquiery("");

	}

}

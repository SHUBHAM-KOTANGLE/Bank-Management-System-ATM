package bank;

import java.awt.Font;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class Mini_Statement extends JFrame {

	Mini_Statement(String pint) {
		setLayout(null);

		JLabel heading = new JLabel();
		heading.setBounds(350, 50, 410, 50);
		heading.setFont(new Font("", Font.BOLD, 38));
		add(heading);

		JLabel b = new JLabel();
		b.setBounds(100, 650, 500, 50);
		b.setFont(new Font("", Font.BOLD, 18));
		add(b);

	

		JLabel data = new JLabel();
		data.setBounds(200, 100, 600, 600);
		data.setFont(new Font("", Font.BOLD, 15));
		add(data);

		Conn c = new Conn();
		int balance = 0;
		try {
			ResultSet rs = c.s.executeQuery("select * from bank where pin='" + pint + "'");
			while (rs.next()) {

				if (rs.getString("type").equals("Deposit")) {
					balance += Integer.parseInt(rs.getString("amount"));

				} else {
					balance -= Integer.parseInt(rs.getString("amount"));
				}

			}
		} catch (Exception e) {

		}
		long s = 0L;
		try {
			ResultSet dp = c.s.executeQuery("select * from bank where pin='" + pint + "'");
			while (dp.next()) {
				data.setText(data.getText() + "<html>   " + dp.getString("date") + "    " + dp.getString("type")
						+ "      " + dp.getString("amount") + "<br><html/>");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		try {

			ResultSet cardno15 = c.s.executeQuery("select 'cardno16' from login where pin='" + pint + "'");
			b.setText("Your Account Balance is " + balance );

		} catch (SQLException e) {
			e.printStackTrace();
		}

		heading.setText("Axix Bank");

		setSize(900, 800);
		setVisible(true);
		setLocation(225, 0);
		
	}

	public static void main(String[] args) {
		new Mini_Statement("");

	}

}

package bank;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Change_your_pin extends JFrame implements ActionListener {

	JButton back, change;
	JPasswordField newpinf, reenternewpinf;
	String pint;

	Change_your_pin(String pint) {
		this.pint = pint;
		setLayout(null);

		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
		Image i2 = i1.getImage().getScaledInstance(900, 800, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel image = new JLabel(i3);
		image.setBounds(0, 0, 900, 800);
		add(image);

		JLabel heading = new JLabel("CHANGE YOUR PIN");
		heading.setBounds(260, 240, 400, 50);
		heading.setFont(new Font("", Font.BOLD, 18));
		heading.setForeground(getForeground().WHITE);
		image.add(heading);

		JLabel newpin = new JLabel("New PIN:");
		newpin.setBounds(170, 300, 400, 50);
		newpin.setFont(new Font("", Font.BOLD, 12));
		newpin.setForeground(getForeground().WHITE);
		image.add(newpin);

		newpinf = new JPasswordField();
		newpinf.setBounds(305, 310, 200, 20);
		image.add(newpinf);

		JLabel reenternewpin = new JLabel("Re-Enter New PIN:");
		reenternewpin.setBounds(170, 330, 400, 50);
		reenternewpin.setFont(new Font("", Font.BOLD, 12));
		reenternewpin.setForeground(getForeground().WHITE);
		image.add(reenternewpin);

		reenternewpinf = new JPasswordField();
		reenternewpinf.setBounds(305, 340, 200, 20);
		image.add(reenternewpinf);

		change = new JButton("Change");
		change.setBounds(355, 430, 150, 25);
		change.addActionListener(this);
		image.add(change);

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

		if (e.getSource() == change) {

			try {

				String newpin = newpinf.getText();
				String reenternewpin = reenternewpinf.getText();

				if (!newpin.equals(reenternewpin)) {
					JOptionPane.showMessageDialog(null, "PIN Doesn't Match");
					return;
				}

				if (newpin.equals("")) {
					JOptionPane.showMessageDialog(null, "Enter New PIN Is Blank");
					return;
				}
				if (reenternewpin.equals("")) {
					JOptionPane.showMessageDialog(null, "Re-Enter New PIN Is Blank");
					return;

				}

				Conn c = new Conn();
				String query1 = "update bank set pin='" + newpin + "' where pin='" + pint + "'";
				String query2 = "update login set pin='" + newpin + "' where pin='" + pint + "'";
				String query3 = "update signupthree set pin='" + newpin + "' where pin='" + pint + "'";

				c.s.executeUpdate(query1);
				c.s.executeUpdate(query2);
				c.s.executeUpdate(query3);

				JOptionPane.showMessageDialog(null, "PIN Changed Successfully");

			} catch (Exception e2) {
				e2.printStackTrace();
			}

		}else if(e.getSource()==back){
			setVisible(false);
			new Transactions(pint);
		}

	}

	public static void main(String[] args) {
		new Change_your_pin("");

	}

}

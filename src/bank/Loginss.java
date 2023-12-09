package bank;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;



public class Loginss implements ActionListener {
	JFrame f=new JFrame();
	JButton Signin,Clear, Signup;
	JTextField   cardf;
	JPasswordField pinf;
	JLabel pin,cardt;
	Loginss(){
		
		f.setLayout(null);
			
		
//		Image 1-----------------------------
		ImageIcon icon=new ImageIcon(ClassLoader.getSystemResource("icons/lo.png"));
		Image i2=icon.getImage().getScaledInstance(100, 100,Image.SCALE_DEFAULT);
		ImageIcon i3=new ImageIcon(i2);
		JLabel l=new JLabel(i3);
		l.setBounds(50, 50, 100, 100);
		f.add(l);
		
//		Text --------------------------------------
		
		JLabel text= new JLabel("Welcome");
		text.setBounds(200, 40, 400, 40);
		text.setFont(new Font("Osward", Font.BOLD, 38));
		f.add(text);
		
//		text
		JLabel cardt=new JLabel("Card No :");
		cardt.setFont(new Font("", Font.BOLD, 38));
		cardt.setBounds(100, 150, 180, 150);
 		f.add(cardt);
		
 		JLabel pin=new JLabel("PIN :");
 		pin.setFont(new Font("", Font.BOLD, 38));
 		pin.setBounds(100, 200, 100, 150);
 		f.add(pin);
		
// 		text field
		cardf=new JTextField();
		cardf.setBounds(350, 200, 350, 38);
		f.add(cardf);
	
		pinf=new JPasswordField();
		pinf.setBounds(350, 260, 350, 38);
		f.add(pinf);
		
//		button
		 Signin=new JButton("Login");
		
		Signin.setBounds(350, 320, 165, 38);
		Signin.addActionListener(this);
		f.add(Signin);
		
		 Clear=new JButton("Clear");
		Clear.setBounds(535, 320, 165, 38);
		Clear.addActionListener(this);
		f.add(Clear);
		
		 Signup=new JButton("Sign Up");
		Signup.setBounds(350, 370, 350, 38);
		Signup.addActionListener(this);
		f.add(Signup);
		
		
		
		
		
//		basic size
		
		f.getContentPane().setBackground(Color.WHITE);
		f.setSize(900, 550);
		f.setVisible(true);
		f.setLocation(225, 100);
		
		
		

	}

	@Override
	public void actionPerformed(ActionEvent e) {
	
		if(e.getSource() == Clear) {
			
			cardf.setText("");
			pinf.setText("");
			
		}else if (e.getSource() == Signin) {
			Conn c=new Conn();
			String cardt =cardf.getText();
			String pint=pinf.getText();
			String Query ="select * from login where cardno16='"+cardt+"' and pin='"+pint+"'";
			try {
				
				 ResultSet rs=c.s.executeQuery(Query);
				if(rs.next()) {
					f.setVisible(false);
					new Transactions(pint).setVisible(true);
				}else {
					JOptionPane.showMessageDialog(null, "Please Enter Valid Card no and PIN");
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
//			503443240647866   3894
//			503443231097771   3596
			
		}else if (e.getSource() ==Signup) {
			f.setVisible(false);
			new SignUpOne().setVisible(true);
		
		}
		
		
	}
	
		
	
	
	public static void main(String[] args) {
		new Loginss();
		

}
}
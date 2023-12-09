package bank;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import com.toedter.calendar.JDateChooser;

public class SignUpOne extends JFrame implements ActionListener {
	
	long ran;
	JTextField namet,pincodet,statet,cityt,addresst,emailt,fathersNamet;
	JButton next;
	JDateChooser dobc;
	JRadioButton male ,female,other,married,unmarried,otherm; 
	
	SignUpOne() {

	
		setLayout(null);
		Random random = new Random();
		 ran = Math.abs(random.nextLong() % 9000L + 15000L);

		JLabel text = new JLabel("Applicaton Form No : " + ran);
		text.setBounds(100, 40, 500, 50);
		text.setFont(new Font("", Font.BOLD, 35));
		add(text);

		JLabel pageno = new JLabel("Page 1 Personal Details ");
		pageno.setBounds(150, 100, 250, 50);
		pageno.setFont(new Font("", Font.BOLD, 20));
		add(pageno);

		JLabel name = new JLabel("Name :");
		name.setBounds(50, 140, 150, 50);
		name.setFont(new Font("", Font.BOLD, 20));
		add(name);

		 namet = new JTextField();
		namet.setBounds(230, 150, 350, 30);
		add(namet);

		JLabel fathersName = new JLabel("Father's Name :");
		fathersName.setBounds(50, 190, 150, 50);
		fathersName.setFont(new Font("", Font.BOLD, 20));
		add(fathersName);

		 fathersNamet = new JTextField();
		fathersNamet.setBounds(230, 200, 350, 30);
		add(fathersNamet);

		JLabel dob = new JLabel("Date Of Birth :");
		dob.setBounds(50, 240, 240, 50);
		dob.setFont(new Font("", Font.BOLD, 20));
		add(dob);

		 dobc = new JDateChooser();
		dobc.setBounds(230, 250, 350, 30);
		add(dobc);

		JLabel gender = new JLabel("Gender :");
		gender.setBounds(50, 290, 150, 50);
		gender.setFont(new Font("", Font.BOLD, 20));
		add(gender);

		 male = new JRadioButton("Male");
		male.setBounds(230, 300, 60, 30);
		male.setBackground(Color.WHITE);
		add(male);

		 female = new JRadioButton("Female");
		female.setBounds(300, 300, 70, 30);
		female.setBackground(Color.WHITE);
		add(female);

		 other = new JRadioButton("Other");
		other.setBounds(370, 300, 60, 30);
		other.setBackground(Color.WHITE);
		add(other);

		ButtonGroup bg = new ButtonGroup();
		bg.add(male);
		bg.add(female);
		bg.add(other);

		JLabel email = new JLabel("Email Address :");
		email.setBounds(50, 340, 150, 50);
		email.setFont(new Font("", Font.BOLD, 20));
		add(email);

		 emailt  = new JTextField();
		emailt.setBounds(230, 350, 350, 30);
		add(emailt);

		JLabel single = new JLabel("Marital Status :");
		single.setBounds(50, 390, 150, 50);
		single.setFont(new Font("", Font.BOLD, 20));
		add(single);

		 married = new JRadioButton("Married");
		married.setBounds(230, 400, 70, 30);
		married.setBackground(Color.WHITE);
		add(married);

		 unmarried = new JRadioButton("Unmarried");
		unmarried.setBounds(300, 400, 90, 30);
		unmarried.setBackground(Color.WHITE);
		add(unmarried);

		 otherm = new JRadioButton("Other");
		otherm.setBounds(390, 400, 60, 30);
		otherm.setBackground(Color.WHITE);
		add(otherm);

		ButtonGroup bgm = new ButtonGroup();
		bgm.add(married);
		bgm.add(unmarried);
		bgm.add(otherm);

		JLabel address = new JLabel("Address :");
		address.setBounds(50, 440, 150, 50);
		address.setFont(new Font("", Font.BOLD, 20));
		add(address);

		 addresst  = new JTextField();
		addresst.setBounds(230, 450, 350, 30);
		add(addresst);

		JLabel city = new JLabel("City :");
		city.setBounds(50, 490, 150, 50);
		city.setFont(new Font("", Font.BOLD, 20));
		add(city);

		 cityt  = new JTextField();
		cityt.setBounds(230, 500, 350, 30);
		add(cityt);

		JLabel state = new JLabel("State :");
		state.setBounds(50, 540, 150, 50);
		state.setFont(new Font("", Font.BOLD, 20));
		add(state);

		 statet = new JTextField();
		statet.setBounds(230, 550, 350, 30);
		add(statet);

		JLabel pincode = new JLabel("Pin Caode :");
		pincode.setBounds(50, 590, 150, 50);
		pincode.setFont(new Font("", Font.BOLD, 20));
		add(pincode);

		 pincodet = new JTextField();
		pincodet.setBounds(230, 600, 350, 30);
		add(pincodet);

		 next = new JButton("Next");
		next.setBounds(500, 660, 70, 30);
		next.addActionListener(this);
		add(next);

		setSize(650, 770);
		setVisible(true);
		setLocation(373, 2);
		getContentPane().setBackground(Color.WHITE);

	}
	@Override
	public void actionPerformed(ActionEvent e) {
		
		
		
		String text= ""+ran;
		String name=namet.getText();
		String fathersName=fathersNamet.getText();
		String dob=((JTextField)dobc.getDateEditor().getUiComponent()).getText();
		String gender=null;
		if(male.isSelected()) {
			gender="Male";
		}else if(female.isSelected()) {
			gender="Female";
		}else if(other.isSelected()) {
			gender="Other";
		}
		String email=emailt.getText();
		String  single=null;
		if(married.isSelected()) {
			single="Male";
		}else if(unmarried.isSelected()) {
			single="Female";
		}else if(otherm.isSelected()) {
			single="Other";
		}
		String address=addresst.getText();
		String city=cityt.getText();
		String state=statet.getText();
		String pincode=pincodet.getText();
		
		
		try {
			if(name.equals("")) {
				JOptionPane.showMessageDialog(null, "Please Enter Name");
			}else {
				Conn c=new Conn();
				String query="insert into signup values('"+text+"','"+name+"','"+fathersName+"','"+dob+"','"+gender+"','"+email+"','"+single+"','"+address+"','"+city+"','"+state+"','"+pincode+"')";
			c.s.executeUpdate(query);
			
			setVisible(false);
			new Signintwo(text).setVisible(true);
			}
			
			
			
		} catch (Exception e2) {
			e2.printStackTrace();
		}
		
		
		
		
		
		
		
		
		
	}

	public static void main(String[] args) {
		new SignUpOne();

	}

	

}

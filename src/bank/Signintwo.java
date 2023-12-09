package bank;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class Signintwo extends JFrame implements ActionListener{

	JComboBox<String> religionc,categoryc,incomec,educationc,occupationc;
	JTextField panf,adharf;
	JRadioButton seniorb,seniorba,existingb,existingba;
	String text;
	Signintwo(String text) {

		this.text=text;
		setTitle("Page 2 Additional Details ");
		setLayout(null);

		JLabel heading = new JLabel("Page 2: Additional Details");
		heading.setBounds(150, 50, 500, 50);
		heading.setFont(new Font("", Font.BOLD, 38));
		add(heading);

		JLabel religion = new JLabel("Religion :");
		religion.setBounds(50, 100, 150, 50);
		religion.setFont(new Font("", Font.BOLD, 28));
		add(religion);

		String[] r = { "Hindu", "Muslim", "Sikh" ,"Christun","Other"};
		 religionc = new JComboBox<String>(r);
		religionc.setBounds(330, 110, 350, 30);
		add(religionc);

		JLabel category = new JLabel("Category :");
		category.setBounds(50, 150, 150, 50);
		category.setFont(new Font("", Font.BOLD, 28));
		add(category);

		String[] c = { "Genaral","SC", "St", "NT" ,"OBC","Other"};
		 categoryc = new JComboBox<String>(c);
		categoryc.setBounds(330, 160, 350, 30);
		add(categoryc);

		JLabel income = new JLabel("Income :");
		income.setBounds(50, 200, 170, 50);
		income.setFont(new Font("", Font.BOLD, 28));
		add(income);
		

		String[] i = { "Upto: 1,50,000", "Upto: 2,50,00", "Upto: 5,00,00", "Upto: 1,50,00" };
		 incomec = new JComboBox<String>(i);
		incomec.setBounds(330, 210, 350, 30);
		add(incomec);

		JLabel education = new JLabel("Education");
		education.setBounds(50, 250, 150, 50);
		education.setFont(new Font("", Font.BOLD, 28));
		add(education);

		String[] e = { "Non-Graduate", "Graduate", "Post-Graduate", "Doctrate", "Other" };
		 educationc = new JComboBox<String>(e);
		educationc.setBounds(330, 260, 350, 30);
		add(educationc);

		JLabel occupation = new JLabel("occupation");
		occupation.setBounds(50, 300, 150, 50);
		occupation.setFont(new Font("", Font.BOLD, 28));
		add(occupation);

		String[] o = { "Salaried", "Self-Employeed", "Business", "Student", "Retired", "Other"};
		 occupationc = new JComboBox<String>(o);
		occupationc.setBounds(330, 310, 350, 30);
		add(occupationc);

		JLabel pan = new JLabel("PAN Numbar :");
		pan.setBounds(50, 350, 200, 50);
		pan.setFont(new Font("", Font.BOLD, 28));
		add(pan);

		 panf = new JTextField();
		panf.setBounds(330, 360, 350, 30);
		panf.setFont(new Font("", Font.BOLD, 28));
		add(panf);

		JLabel adhar = new JLabel("Adhar Numbar :");
		adhar.setBounds(50, 400, 230, 50);
		adhar.setFont(new Font("", Font.BOLD, 28));
		add(adhar);

		 adharf = new JTextField();
		adharf.setBounds(330, 410, 350, 30);
		adharf.setFont(new Font("", Font.BOLD, 28));
		add(adharf);

		JLabel senior = new JLabel("Senior Citizen :");
		senior.setBounds(50, 450, 250, 50);
		senior.setFont(new Font("", Font.BOLD, 28));
		add(senior);

		 seniorb = new JRadioButton("Yes");
		seniorb.setBounds(330, 450, 50, 50);
		add(seniorb);
		 seniorba = new JRadioButton("No");

		seniorba.setBounds(390, 450, 50, 50);
		add(seniorba);

		ButtonGroup ba = new ButtonGroup();
		ba.add(seniorb);
		ba.add(seniorba);

		JLabel existing = new JLabel("Existing Account :");
		existing.setBounds(50, 500, 250, 50);
		existing.setFont(new Font("", Font.BOLD, 28));
		add(existing);

		existingb = new JRadioButton("Yes");

		existingb.setBounds(330, 500, 50, 50);
		add(existingb);
		existingba = new JRadioButton("No");

		existingba.setBounds(390, 500, 50, 50);
		add(existingba);

		ButtonGroup b = new ButtonGroup();
		b.add(existingb);
		b.add(existingba);
		
		JButton next =new JButton("Next");
		next.setBounds(620, 590, 60, 30);
		next.addActionListener(this);
		add(next);

		setSize(800, 750);
		setVisible(true);
		setLocation(250, 5);
		getContentPane().setBackground(Color.WHITE);
	}
	@Override
	public void actionPerformed(ActionEvent e) {

		String religion=(String) religionc.getSelectedItem();
		String category= (String) categoryc.getSelectedItem();
		String income=(String) incomec.getSelectedItem();
		String education=(String) educationc.getSelectedItem();
		String occupation=(String) occupationc.getSelectedItem();
		String pan=panf.getText();
		String adhar= adharf.getText();
		String senior=null;
		if(seniorb.isSelected()) {
			senior="Yes";
		}else if (seniorba.isSelected()) {
			senior="No";
		}
		String existing=null;
		if(existingb.isSelected()) {
			existing="Yes";
		}else if (existingba.isSelected()) {
			existing="No";
		}
		
		try {
			if (pan.equals("")) {
				JOptionPane.showMessageDialog(null, "Enter PAN");
				
			} else {
				Conn co=new Conn();
			
				String Query2= "insert into signuptwo values('"+text+"','"+religion+"','"+category+"','"+income+"','"+education+"','"+occupation+"','"+pan+"','"+adhar+"','"+senior+"','"+existing+"')";
			co.s.executeUpdate(Query2);
			
			setVisible(false);
			new Signupthree(text).setVisible(true);;
			
			}
			
		} catch (Exception e2) {
			
		}
		
		
		
		
		
		
		
		
		
		
	}

	public static void main(String[] args) {
		new Signintwo("");

	}

	

}

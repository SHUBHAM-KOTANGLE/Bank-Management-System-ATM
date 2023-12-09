package bank;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.ImageObserver;
import java.awt.image.ImageProducer;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Transactions extends JFrame implements ActionListener{

	JButton exit,deposit,cashwithdrawl,fastcash,ministatement,pinchange,balanceenquiry;
	String pint;
	Transactions(String pint){
		this.pint=pint;
	setLayout(null);

		ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
		Image i2=i1.getImage().getScaledInstance(900, 800, Image.SCALE_DEFAULT); 
		ImageIcon i3=new ImageIcon(i2);
		JLabel image=new JLabel(i3);
		image.setBounds(0, 0, 900, 800);
		add(image);
		
		 deposit=new JButton("Deposit");
		deposit.setBounds(170, 370, 150, 25);
		deposit.addActionListener(this);
		image.add(deposit);
		
		 cashwithdrawl=new JButton("Cash Withdrawl");
		cashwithdrawl.setBounds(355, 370, 150, 25);
		cashwithdrawl.addActionListener(this);
		image.add(cashwithdrawl);
		
		
		 fastcash=new JButton("Fast Cash");
		fastcash.setBounds(170, 400, 150, 25);
		fastcash.addActionListener(this);
		image.add(fastcash);
		
		
		 ministatement=new JButton("Mini Statement");
		ministatement.setBounds(355, 400, 150, 25);
		ministatement.addActionListener(this);
		image.add(ministatement);
		
		
		 pinchange=new JButton("PIN Change");
		pinchange.setBounds(170, 430, 150, 25);
		pinchange.addActionListener(this);
		image.add(pinchange);
		
		
		 balanceenquiry=new JButton("Balance Enquiry");
		balanceenquiry.setBounds(355, 430, 150, 25);
		balanceenquiry.addActionListener(this);
		image.add(balanceenquiry);
		
		 exit=new JButton("Exit");
		exit.setBounds(355, 460, 150, 25);
		exit.addActionListener(this);
		image.add(exit);
		
		setSize(900,800);
		setVisible(true);
		setLocation(225,0);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource()==exit) {
			System.exit(EXIT_ON_CLOSE);
		}else if (e.getSource()==deposit) {
			setVisible(false);
			new Deposit(pint).setVisible(true);
		}else if (e.getSource()==cashwithdrawl) {
			setVisible(false);
			new Cash_Withdrawal(pint).setVisible(true);
			
		}else if (e.getSource()==fastcash) {
			setVisible(false);
			new Fast_Cash(pint).setVisible(true);
		}else if (e.getSource()==ministatement) {
			
			new Mini_Statement(pint).setVisible(true);
		}else if (e.getSource()==pinchange) {
			setVisible(false);
			new Change_your_pin(pint).setVisible(true);
		}else if (e.getSource()==balanceenquiry) {
			setVisible(false);
			new Balance_Enquiery(pint).setVisible(true);;
		}
		
	}
	
	public static void main(String[] args) {

		
		new Transactions("");
		
		
		
	}

	

}

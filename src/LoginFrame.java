
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class LoginFrame extends Test{
	private JButton but = new JButton("Connet");
	private JLabel Jl = new JLabel("Enter your IP Address:") ;
	private JTextField jt = new JTextField(25);
	Client c = new Client();
	
	public void login(){
		JFrame jf = new JFrame("IP Address");
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//add the red cross button on the right hand top side of the window to allowed exit the window.
  		jf.setSize(400,100);
  		jf.setLocationRelativeTo(null);
 		but.setToolTipText("Click here to connect with server");
  		jf.add(Jl,BorderLayout.NORTH);
  		jf.add(jt,BorderLayout.WEST);
  		jf.add(but,BorderLayout.EAST);
  		jf.setVisible(true);
  		but.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String input = "Player"+player;
				String IP = jt.getText();
				c.start(IP,input);
				//f.setVisible(true);
				//board();
				jf.setVisible(false);  
				
				    
			}
  			
  		});
  		
  		
	}
	 
   
}

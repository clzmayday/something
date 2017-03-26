import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;



public class Test{
	 JButton b = new JButton("Roll Dice");
	 JTextField jt = new JTextField(25);
   	 SnakesAndLaddersGUI gui=new SnakesAndLaddersGUI();
   	 JFrame f=new JFrame("Game Snake and Ladder");
   	int[]pos=new int[4];
   	 int dice=0;
   	 int player;
   	 Scanner in = new Scanner(System.in);
   	 boolean game = true;
   	 
   	 public void board(){
   		
      	f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//add the red cross button on the right hand top side of the window to allowed exit the window.
  		f.setSize(450,450);
  		f.setLocationRelativeTo(null);//
      	f.getContentPane().add(gui);
      	b.addActionListener(new Dice());
      	b.setToolTipText("Click here to rolling the dice");
      	JPanel panel1 = new JPanel();
      	panel1.add(b);
      	panel1.add(jt);
      	f.add(panel1,BorderLayout.SOUTH);
      	
      	f.setVisible(true);
   	 }
public void Player(){
  	gui.setNumberOfPlayers(5);
  	for(int i=0;i<4;i++){
    	pos[i]=1;
    	gui.setPosition(i,0);
    	player=i;
  	}
		try{
			Thread.sleep(1500);
		}catch(Exception e){e.printStackTrace();}

		try{
   			
   			Thread.sleep(500);
   			while(game){
   				System.out.println("Who:");
   				
   				int a = in.nextInt();
   				int num=dice;
   				System.out.println(num);
   				while(num>0){
   					gui.setPosition(a,pos[a]++);
   					num--;
   				}
   				num = dice;
   				status();
   				Thread.sleep(100);
   					
     	
   			}
   			
     	  }catch(Exception ex){ex.printStackTrace();}
		
  }
 
  public void connect(){
   		String input = "Player"+player;
		String IP = jt.getText();
		Client c = new Client();
		c.start(IP,input);
   	 }
  
   public static void main(String[] a){
    	 	LoginFrame l = new LoginFrame();
    	 	l.login();
    	 	Test t = new Test();
    	 	t.board();
	        t.Player();
	        
   }
   
   private void status(){
	   for(int i = 0; i < 4; i++){
		   if(pos[i] == 100){
			   jt.setText(i + " Win!");
			   game = false;
		   }
		   else{
			   game = true;
		   }
	   }	
   }
   private class Dice implements ActionListener{
     	   @Override	
     		
     	public void actionPerformed(ActionEvent e) {
     	  

     	   if(e.getSource()==b){
     			
     			dice=(int)(Math.random()*6+1);
     			jt.setText("");
     			jt.setText(jt.getText()+"The number you rolled is:" +dice);
     			
     		    	
     		
     	 }
        }
   }
}

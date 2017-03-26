package origin;


import javax.swing.*;
import java.awt.*;
import java.awt.image.*;


public class start{
	
	public void setscreen(){
		JFrame f=new JFrame("Game Snack and Ladder");
      	f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//add the red cross button on the right hand top side of the window to allowed exit the window.
  		f.setSize(450,450);
  		f.setLocationRelativeTo(null);//
      	SnakesAndLaddersGUI gui=new SnakesAndLaddersGUI();
      	f.getContentPane().add(gui);
      	f.setLayout(new FlowLayout());
      	Button b = new Button("Roll Dice");
      	
      	
      	f.add(b);
      	f.setVisible(true);
	
	}
	
    public static void main(String[] a){

          	JFrame f=new JFrame("Game Snack and Ladder");
          	
          	f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//add the red cross button on the right hand top side of the window to allowed exit the window.
	  		f.setSize(450,450);
	  		f.setLocationRelativeTo(null);//
          	SnakesAndLaddersGUI gui=new SnakesAndLaddersGUI();
          	f.getContentPane().add(gui);
          
          	JButton b = new JButton("Dice");
          	b.setToolTipText("Click here to rolling the dice");
          	b.setSize(10, 5);
        	f.setLayout(new GridLayout(2,5));
          	JPanel panel1 = new JPanel();
          	panel1.add(b);
          	panel1.setSize(100, 50);
          	//panel1.add(gui);
          	
          	
          	f.add(panel1);
          	
          	f.setVisible(true);


          	gui.setNumberOfPlayers(5);
          	int[]pos=new int[5];
          	for(int i=0;i<5;i++){
            	pos[i]=1;
            	gui.setPosition(i,1);
          	}
	  		try{
	  			Thread.sleep(1500);
	  		}catch(Exception e){e.printStackTrace();}

          	while(true){
            	try{
              			int dice;
              			Thread.sleep(500);
              			for(int i=0;i<5;i++){
                			dice=(int)(Math.random()*6);
                		while(dice>0){
                  			gui.setPosition(i,pos[i]++);
                  			dice--;
                  			Thread.sleep(100);

            			}
              		}
            	}
            	catch(Exception e){e.printStackTrace();}
          	}
        }
}


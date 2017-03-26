import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.JOptionPane;

public class Client extends Test{
	
	
	public void start(String ip,String i){
		 Socket s =null;
		 PrintWriter out = null; 
		 BufferedReader in = null;
		
		try{
			s = new Socket(ip,8888);
			out=new PrintWriter(s.getOutputStream(),true);
		    in=new BufferedReader(new InputStreamReader(s.getInputStream()));
			out.println(i);
			String rec = in.readLine();
			if(rec!=null){
				JOptionPane.showMessageDialog(f, "It is now " + rec+"'s turn");
		}

		    out.close();
			
		}catch(UnknownHostException e){
			System.out.println(e.toString());
			
		}catch (IOException e)
		{
			System.out.println(e.toString());
		}
		finally{
			try{
				if(s!=null){
					s.close();
				}
			}catch(IOException e){
				System.out.println(e.toString());
			}
		}
	}
	
}


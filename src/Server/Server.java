package Server;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class Server {
	ArrayList <serverThread> arr = new ArrayList();
	PrintWriter out = null; 
	BufferedReader in = null;
	String line = null;
	
	public void TurnOn(){
		ServerSocket s = null;
		Socket socket =null;
		

		try{
			s=new ServerSocket(8888);

			while(true){
				socket = s.accept();//connected to client by socke
				serverThread st = new serverThread(socket);
				new Thread(st).start();
				
			}
		}catch(IOException e){
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
		System.out.println("over");

	}
	public void send(){
		for(serverThread st:arr){
			out.println(line);
		}
	}
	public static void main(String[] arg) throws IOException{
		Server ser = new Server();
		ser.TurnOn();
	}

  private class serverThread implements Runnable{
		Socket s = null;
		PrintWriter out; 
		BufferedReader in;
		
		public serverThread(Socket socket) throws IOException{
			s= socket;
			out = new PrintWriter(s.getOutputStream(),true);
			in = new BufferedReader(new InputStreamReader(s.getInputStream()));
			arr.add(this);
		}
		public void receive() throws IOException{
			
			while((line = in.readLine()) != null){
				
				System.out.println("Connected to "+line+": "+s.getPort()+"'"+s.getInetAddress()); //Prints it out
				out.println(line);
			}
		}
		@Override
		public void run() {
			// TODO Auto-generated method stub
		    try{
				while(true){
					receive();		
					}
			}catch(Exception e){
				System.out.println(e.toString());
			}finally{
					try {
						if(s!=null)
						s.close();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
	}
}			
	


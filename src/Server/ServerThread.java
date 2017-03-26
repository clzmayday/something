package Server;

import java.io.PrintStream;
import java.net.Socket;
import java.util.ArrayList;

public class ServerThread extends Thread{
	private Socket socket;
	ArrayList<Player> players;
	private PrintStream toClient;
	
	public ServerThread(Socket _socket, ArrayList<Player> _players){
		this.socket = _socket;
		this.players = _players;
	}
	
	public void run(){
		
	}
	
	
}

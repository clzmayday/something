package Server;

import java.net.Socket;

public class Player {

	private Socket socket;
	
	public Player(Socket _socket){
		this.socket = socket;
	}
	
	public Socket getSocket(){
		return this.socket;
	}
}

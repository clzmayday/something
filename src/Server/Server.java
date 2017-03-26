package Server;

import java.io.*;
import java.net.*;
import java.util.ArrayList;

public class Server {

	
	public static void main(String[] args){
		
		ArrayList<Player> players = new ArrayList<Player>();
		ServerSocket serverSocket = null;
		try {
			serverSocket = new ServerSocket(8888);
		} catch (IOException e2) {
			e2.printStackTrace();
		}

		try {
			while (true) {

				Socket s = serverSocket.accept(); // Stuck until somebody
													// connects
							
				players.add(new Player(s));
				System.out.println(players.size() + "connected");

				// System.out.println(name);
				ServerThread t = new ServerThread(s,players);
				t.start();

			}
		} catch (Exception e) {
			try {
				serverSocket.close();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
	}
}			
	


import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.net.ServerSocket;
import java.net.Socket;

import javax.swing.JOptionPane;

public class Server {

	Socket socket = null;
	ServerSocket server = null;
	DataInputStream inputStream = null;
	
	public Server(int port) {
		try {
			server = new ServerSocket(port);
			System.out.println("Server started!");
			System.out.println("Waiting for server!");
			socket = server.accept();
			server.close();
			JOptionPane.showMessageDialog(null, "Client accepted!", "wow", JOptionPane.PLAIN_MESSAGE);
			System.out.println("Client accepted!");
			inputStream = new DataInputStream(new BufferedInputStream(socket.getInputStream())); 
		}catch(Exception e) {
			System.out.println("Error has occurred!");
			JOptionPane.showMessageDialog(null, "Error!", "wow", JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		Server serv = new Server(5000);
	}
	
}

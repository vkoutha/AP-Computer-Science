import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.Socket;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Collections;
import java.util.Enumeration;
import static java.lang.System.out;

import javax.swing.JOptionPane;

public class Client {
	
	Socket socket;
	DataOutputStream outputStream = null;
	DataInputStream inputStream = null;
	
	public Client(String address, int port) {
		
		try {
			socket = new Socket(address, port);
			JOptionPane.showMessageDialog(null, "Connected!", "wow", JOptionPane.PLAIN_MESSAGE);
			outputStream = new DataOutputStream(socket.getOutputStream());
			inputStream = new DataInputStream(System.in);
		}catch(Exception e) {
			System.out.println("Error");
			JOptionPane.showMessageDialog(null, "Error!", "wow", JOptionPane.ERROR_MESSAGE);
		}
		
	}
	
	public static void main(String[] args) {

	try {
		  Enumeration<NetworkInterface> nets = NetworkInterface.getNetworkInterfaces();
	        for (NetworkInterface netint : Collections.list(nets))
	            displayInterfaceInformation(netint);
	} catch (SocketException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
        
        
		try {
	//		System.out.println(InetAddress.getLocalHost().getHostAddress());
	//		System.out.println(InetAddress.getLoopbackAddress().getHostAddress());
	//		System.out.println(InetAddress.getLocalHost().getAddress());
			new Client(InetAddress.getLocalHost().getHostAddress().toString(), 5000);
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	 static void displayInterfaceInformation(NetworkInterface netint) throws SocketException {
		 out.printf("Display name: %s\n", netint.getDisplayName());
	        out.printf("Name: %s\n", netint.getName());
	        Enumeration<InetAddress> inetAddresses = netint.getInetAddresses();
	        for (InetAddress inetAddress : Collections.list(inetAddresses)) {
	            out.printf("InetAddress: %s\n", inetAddress);
	        }
	        out.printf("\n");
	 }

}

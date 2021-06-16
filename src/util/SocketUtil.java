package util;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

import model.Receiver;

public class SocketUtil {
	private static Socket socket;
	private static Receiver receiver;
	
	public static void starServer(){
		ServerSocket server;
		
		try {
			server=new ServerSocket(8855);
			new Thread(new Runnable() {
				
				@Override
				public void run() {
					try {
						socket=server.accept();
						System.out.println("server accept client!");
						receiver.startThread();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}).start();			
		} catch (IOException e) {
			;
		}
	}
	
	public static void setSocket(Socket socket){
		SocketUtil.socket=socket;
		System.out.println("client request success!");
		receiver.startThread();
	}
	
	public static Socket getSocket(){
		return socket;
	}
	
	public static void setReceiver(Receiver t){
		receiver=t;
	}
	
	public static void sendMessage(Object message){
		ObjectOutputStream out;
		try {
			out=new ObjectOutputStream(socket.getOutputStream());
			out.writeObject(message);
			out.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

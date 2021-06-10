package model;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;

public class Receiver {
private Socket socket;
	
	public void startThread(){
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				ObjectInputStream in;
				Object message;
				try {
					in=new ObjectInputStream(socket.getInputStream());
					while(true){
						message=in.readObject();
						
					}
				} catch (IOException | ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}).start();
	}

	
}

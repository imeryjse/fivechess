package model;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.Observable;

import util.SocketUtil;

public class Receiver extends Observable{

	public void startThread(){
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				ObjectInputStream in;
				Object message;
				try {					
					while(true){
						in=new ObjectInputStream(SocketUtil.getSocket().getInputStream());
						message=in.readObject();
						setChanged();
						notifyObservers(message);
					}
				} catch (IOException | ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}).start();
	}

	
}

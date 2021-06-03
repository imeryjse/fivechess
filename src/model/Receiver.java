package model;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;

import controller.Controll;
import util.StateCode;
import view.MainFrame;

public class Receiver {
	private Socket socket;
	private Controll ctl;
	public Receiver(Socket socket,Controll ctl) {
		this.socket = socket;
		this.ctl=ctl;
	}
	
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
						if(message instanceof Integer){
							manageCommand((int)message);
						}
					}
				} catch (IOException | ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}).start();
	}

	protected void manageCommand(int message) {
		switch (message) {
		case StateCode.REQUESTLINK:
			int f=MainFrame.showConfirm("有人请求联机，同意吗？");
			if(f==0)
			{
				Controll.sendMessage(StateCode.AGREELINK);
				ctl.enableLoginButton();
			}
			else Controll.sendMessage(StateCode.DISAGREELINK);
			break;
		case StateCode.AGREELINK:
			ctl.hideLoginPanel();
			break;
		case StateCode.DISAGREELINK:
			MainFrame.showConfirm("对方拒绝了您的请求！");
			break;
		default:
			break;
		}
	}
	
}

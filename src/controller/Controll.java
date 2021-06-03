package controller;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

import model.Receiver;
import util.LoginListener;
import util.Server;
import view.ChessPanel;
import view.GridPanel;
import view.InfoPanel;
import view.LoginPanel;

public class Controll{
	private LoginPanel loginPanel;
	private ChessPanel chessPanel;
	private GridPanel gridPanel;
	private InfoPanel infoPanel;
	private static Socket socket=null;
	private Controll ctl;
	public Controll(LoginPanel loginPanel, ChessPanel chessPanel, GridPanel gridPanel, InfoPanel infoPanel) {
		this.loginPanel = loginPanel;
		this.chessPanel = chessPanel;
		this.gridPanel = gridPanel;
		this.infoPanel = infoPanel;
		ctl=this;
		loginPanel.setLoginListener(new LoginListener() {
			
			@Override
			public void setSocket(Socket soc) {
				socket=soc;
				System.out.println("客户端连接成功");
				new Receiver(soc,ctl).startThread();
			}
		});
	}
	
	public void setSocket(){
		ServerSocket server=Server.start(loginPanel);
		if(server!=null){
			new Thread(new Runnable() {
				
				@Override
				public void run() {
					try {
						socket=server.accept();
						System.out.println("服务器接收到客服端连接！");
						new Receiver(socket,ctl).startThread();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}).start();
		}
	}
	
	public static void sendMessage(Object message){
		if(socket==null){
			System.out.println("还没联机呢");
		}
		try {
			ObjectOutputStream out=new ObjectOutputStream(socket.getOutputStream());
			out.writeObject(message);
			out.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void hideLoginPanel(){
		loginPanel.setVisible(false);
	}
	
	public void enableLoginButton(){
		loginPanel.enableComponent();
	}
	
}

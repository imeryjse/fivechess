package util;

import java.io.IOException;
import java.net.ServerSocket;

public class Server {
	
	public static ServerSocket start(ServerListener sl){
		ServerSocket server=null;
		try {
			server=new ServerSocket(8855);
			sl.success();
		} catch (IOException e) {
			System.out.println("已经有一个服务在运行！");
		}
		return server;
	}
}

package controller;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;

import model.Receiver;
import util.SocketUtil;
import view.ChessPanel;
import view.InfoPanel;
import view.LoginPanel;

public class MainFrame extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public MainFrame() {
		setLayout(new BorderLayout());
		
		ChessPanel chessPanel=new ChessPanel();		
		add(chessPanel);
		
		InfoPanel infoPanel=new InfoPanel();
		add(infoPanel,BorderLayout.EAST);
				
		LoginPanel loginPanel=new LoginPanel();
		setGlassPane(loginPanel);
		loginPanel.setVisible(true);
		
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(1000, 700);
//		setResizable(false);
		
		
		Receiver receiver=new Receiver();
		receiver.addObserver(loginPanel);
		
		SocketUtil.setReceiver(receiver);
		SocketUtil.starServer();
	}
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				try {
					UIManager.setLookAndFeel(new NimbusLookAndFeel());
				} catch (UnsupportedLookAndFeelException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				new MainFrame();
			}
		});
	}
}

package view;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;

import controller.Controll;

public class MainFrame extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static MainFrame mainFrame=null;
	public MainFrame() {
		setLayout(new BorderLayout());
		
		ChessPanel chessPanel=new ChessPanel();		
		add(chessPanel);
		
		InfoPanel infoPanel=new InfoPanel();
		add(infoPanel,BorderLayout.EAST);
		
		GridPanel gridPanel=new GridPanel();
		chessPanel.add(gridPanel);
		gridPanel.repaint();
		
		LoginPanel loginPanel=new LoginPanel();
		setGlassPane(loginPanel);
		loginPanel.setVisible(true);
		
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(1000, 700);
		setResizable(false);
		
		Controll ctl=new Controll(loginPanel, chessPanel, gridPanel, infoPanel);
		ctl.setSocket();
		
		mainFrame=this;
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
	
	public static int showConfirm(String message){
		int f=JOptionPane.showConfirmDialog(mainFrame, message, "提示信息", JOptionPane.YES_NO_OPTION);
		return f;
	}
	
	public static void showMessage(String message){
		JOptionPane.showMessageDialog(mainFrame, message);
	}
}

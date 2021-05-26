package view;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Composite;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class LoginPanel extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField[] tf=new JTextField[2];
	public LoginPanel() {
		setLayout(new GridBagLayout());
		setOpaque(false);
		Font font=new Font("微软雅黑", Font.TRUETYPE_FONT, 18);
		
		String[] s1={"昵  称","对方IP"},s2={"登录","关闭"};
		GridBagConstraints gbc=new GridBagConstraints();
		for(int i=0;i<s1.length;i++){
			JLabel label=new JLabel(s1[i]);
			label.setFont(font);
			gbc.gridx=0; gbc.gridy=i;
			gbc.insets=new Insets(10, 10, 10, 0);
			add(label, gbc);
			//
			tf[i]=new JTextField(10); 
			tf[i].setFont(font);
			gbc.gridx=1;			
			add(tf[i], gbc);
			//
			JButton bt=new JButton(s2[i]);			
			bt.setFont(new Font("微软雅黑", Font.TRUETYPE_FONT, 14));
			gbc.gridx=i; gbc.gridy=2;	
			gbc.anchor=GridBagConstraints.CENTER;
			add(bt, gbc);
		}
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		super.paintComponent(g);
		Graphics2D g2=(Graphics2D) g;
		Composite composite=g2.getComposite();
		g2.setColor(Color.gray);
		g2.setComposite(AlphaComposite.SrcOver.derive(0.9f));
		g2.fillRect(0, 0, getWidth(), getHeight());
		g2.setComposite(composite);
	}
}

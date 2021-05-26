package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * 
 * @author Administrator
 *
 */
public class ChessPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ChessPanel() {
		setBackground(new Color(0xc0c0c0));
		setLayout(new BorderLayout());
		setOpaque(false);
		
		JPanel bottom = new JPanel();
		bottom.setOpaque(false);
		String[] s1 = { "开始", "悔棋", "认输", "回放" };
		for (int i = 0; i < s1.length; i++) {
			JButton bt = new JButton(s1[i]);
			bottom.add(bt);
		}
		add(bottom, BorderLayout.SOUTH);

		JPanel top = new JPanel();
		top.setOpaque(false);
		JLabel title = new JLabel("网络五子棋");
		title.setFont(new Font("华文琥珀", Font.TRUETYPE_FONT, 24));
		title.setForeground(new Color(0x123456));
		JLabel author = new JLabel("             华信智原");
		author.setFont(new Font("华文行楷", Font.TRUETYPE_FONT, 14));
		author.setForeground(Color.RED);
		top.add(title);
		top.add(author);
		add(top, BorderLayout.NORTH);

		String[] s2 = { "玩家1", "玩家2" };
		JPanel[] lr=new JPanel[2];
		for (int i = 0; i < s2.length; i++) 
		{
			lr[i] = new JPanel();
			lr[i].setOpaque(false);
			lr[i].setLayout(new GridBagLayout());
			GridBagConstraints gbc = new GridBagConstraints();
			JLabel image = new JLabel("图片");
			JLabel player1 = new JLabel(s2[i]);
			gbc.gridx = 0;
			gbc.gridy = 0;
			gbc.insets = new Insets(10, 20, 10, 20);
			lr[i].add(image, gbc);
			gbc.gridy = 1;
			lr[i].add(player1, gbc);
		}
		add(lr[0], BorderLayout.WEST);
		add(lr[1], BorderLayout.EAST);
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		super.paintComponent(g);
		Image img=new ImageIcon(getClass().getResource("../image/3.jpg")).getImage();
		g.drawImage(img, 0, 0,getWidth(),getHeight(),null);
	}
}

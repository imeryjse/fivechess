package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class InfoPanel extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public InfoPanel() {
		setBackground(Color.yellow);
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		JPanel top=new JPanel();
		top.setLayout(new GridBagLayout());
		GridBagConstraints gbc=new GridBagConstraints();
		JLabel label1=new JLabel();		
		label1.setIcon(new ImageIcon(getClass().getResource("../image/infoPanel.png")));
		gbc.gridx=0;
		gbc.gridy=0;
		gbc.insets=new Insets(20, 0, 10, 0);
		top.add(label1,gbc);
		JLabel label2=new JLabel("玩家x");
		gbc.gridy=1;
		top.add(label2,gbc);
		add(top);
		
		JPanel middle=new JPanel();
		middle.setLayout(new BorderLayout());
		DefaultTableModel dtm=new DefaultTableModel(new Object[][]{},new String[]{"昵称","IP","联机时间"});
		JTable table=new JTable(dtm);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		JScrollPane sp=new JScrollPane(table);
		sp.setPreferredSize(new Dimension(230, 200));
		middle.add(sp);
		add(middle);
		
		JPanel bottom=new JPanel();
		bottom.setLayout(new BorderLayout());
		JTextArea chat=new JTextArea();
		chat.setPreferredSize(new Dimension(200, 500));
		JPanel panel=new JPanel();
		panel.setLayout(new BorderLayout());
		JTextField tf=new JTextField();
		JButton send=new JButton("发送");
		panel.add(tf); panel.add(send,BorderLayout.EAST);
		bottom.add(chat); bottom.add(panel,BorderLayout.SOUTH);
		add(bottom);
		
	}
}

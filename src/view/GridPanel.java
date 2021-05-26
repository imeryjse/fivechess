package view;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Composite;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

public class GridPanel extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public GridPanel() {
		super();		
		setBackground(new Color(0xB2DFEE));
		setOpaque(false);
	}
	
	@Override
	public void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		super.paintComponent(g);
		Graphics2D g2=(Graphics2D) g;		
		Composite composite=g2.getComposite();
		g2.setColor(new Color(0xB2DFEE));
		g2.setComposite(AlphaComposite.SrcOver.derive(0.8f));
		g2.fillRect(0, 0, getWidth(), getHeight());
		g2.setComposite(composite);
		drawGrid(g2);		
	}

	private void drawGrid(Graphics2D g2) {
		int width=getWidth();
		int height=getHeight();
		int chessw=width/15;
		int chessh=height/15;
		int bw=(width%15+chessw)/2,bh=(height%15+chessh)/2;
		int x=bw,y=bh;
		g2.setColor(Color.black);
		for(int i=0;i<15;i++){
			g2.drawLine(x+i*chessw, y, x+i*chessw,height-bh );
			g2.drawLine(x, y+i*chessh, width-bw, bh+i*chessh);
		}
	}
}

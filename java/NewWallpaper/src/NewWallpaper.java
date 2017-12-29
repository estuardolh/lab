import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;
import javax.swing.JPanel;


public class NewWallpaper extends JFrame{
	GeneradorProcedural gp = null;
	
	public NewWallpaper(){
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(500, 500);
		
		gp = new GeneradorProcedural(this.getWidth(), this.getHeight());
		
		this.getContentPane().add(gp);
		
		this.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				clicked();
			}
		});
	}
	
	public void clicked(){
		System.out.println("clicked");
		this.getContentPane().remove(0);
		
		this.getContentPane().repaint();
		gp = new GeneradorProcedural(this.getWidth(), this.getHeight());
		this.getContentPane().add(gp);

	}

	public static void main(String[] args) {
		NewWallpaper nw = new NewWallpaper();
		nw.setVisible(true);
	}
}

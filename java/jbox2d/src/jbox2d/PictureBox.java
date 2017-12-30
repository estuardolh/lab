package jbox2d;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;

import javax.swing.JPanel;

public class PictureBox extends JPanel{
	
	public int cx = 0;
	public int cy = 0;
	public int cw = 0;
	public int ch = 0;
	
	public Color color = Color.BLACK;
	
	public float getDegrees() {
		return degrees;
	}

	public void setDegrees(float degrees) {
		this.degrees = degrees;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	private float degrees = 0;
    /**
	 * Okay... PictureBox serialVersionUID
	 */
	private static final long serialVersionUID = -7276819351897696493L;

    public PictureBox(Color color) {
    	this.color = color;
    }
    boolean transparent = false;
    public void setTransparent(boolean transparent) {
    	this.transparent = transparent;
    }
    
    @Override
    protected void paintComponent(Graphics g) {
    	super.paintComponent(g);
    	
    	this.removeAll();
    	
    	int margin = 5;
    	
    	this.removeAll();
    	if(this.degrees == 0) {
    		this.setBounds(this.cx, this.cy, this.cw, this.ch);
    	}else {
    		this.setBounds(this.cx-margin/2, this.cy-margin/2, this.cw+margin, this.ch+margin);
    	}
    	
		Graphics2D g2d = (Graphics2D)g;
		 
        if(this.degrees > 0) {
        	 // base rectangle
    		Color transparent_color = new Color(255, 255, 255, 127*0);
            g2d.setColor(transparent_color);
            
        	g2d.fillRect(0, 0, getWidth(), getHeight());
        	
        	// rotated 45 degrees around origin
            g2d.rotate(this.degrees,margin/2+(this.cw)/2,margin/2+(this.ch)/2);
            
            g2d.setColor(this.color);
            g2d.fillRect(margin/2, margin/2, this.cw, this.ch);
        }else {
        	g2d.setColor(this.color);
            g2d.fillRect(0, 0, this.cw, this.ch);
        }
        
        g2d.dispose();
    }
    
}

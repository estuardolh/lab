import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import piezas.Pieza;


public class GeneradorProcedural extends JPanel{
	
	ArrayList<Pieza> piezas = null;
	int pieza_width = 16;
	int pieza_height = 16;
	
	public GeneradorProcedural(int w, int h){
		this.setSize(w, h);
		piezas = new ArrayList<Pieza>();
	}
	
	@Override
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		System.out.println("ok");
		genera(20, 0, Pieza.FORMA_AGUA);
		
		Graphics2D g2d = (Graphics2D)g;
		
		BufferedImage img = null;
		BufferedImage img_agua = null;
		BufferedImage img_cesped = null;
		BufferedImage img_tierra = null;
		try {
			img_agua = ImageIO.read(new File("./agua.png"));
		} catch (Exception ex){
			ex.printStackTrace();
		}
		try {
			img_cesped = ImageIO.read(new File("./cesped.png"));
		} catch (Exception ex){
			ex.printStackTrace();
		}
		try {
			img_tierra = ImageIO.read(new File("./tierra.png"));
		} catch (Exception ex){
			ex.printStackTrace();
		}
		
		for(int i = 0; i<piezas.size() ; i++){
			Pieza p = piezas.get(i);
			
			if(p.getForma() == Pieza.FORMA_AGUA){
				img = img_agua;
			}else if(p.getForma() == Pieza.FORMA_CESPED){
				img = img_cesped;
			}else if(p.getForma() == Pieza.FORMA_TIERRA){
				img = img_tierra;
			}
			
			g2d.drawImage(img, p.getX(), p.getY(),null);
		}
	}
	
	private boolean estaLibre(int i, int j){
		for(int x = 0; x<piezas.size() ; x++){
			if( piezas.get(x).getI() == i && piezas.get(x).getJ() == j ){
				return false;
			}
		}
		
		return true;
	}
	
	public void genera(int i, int j, int pieza_forma){
		boolean free = estaLibre(i, j);
		// System.out.println("locx: "+i*pieza_width+" locy: "+j*pieza_height+"w: "+this.getWidth()+" h: "+this.getHeight()+" free: "+free+" "+(pieza_forma == Pieza.FORMA_AGUA?"agua":pieza_forma == Pieza.FORMA_CESPED?"cesped":"tierra"));
		// si es dibujable
		if( free
				&& i > -1 && i*pieza_width < this.getWidth()
				&& j > -1 && j*pieza_height < this.getHeight() ){
			// para dibujar
			piezas.add(new Pieza(i, j, pieza_width, pieza_height, pieza_forma));
			
			// sigue dibujando
			if( pieza_forma == Pieza.FORMA_AGUA ){
				// rodear
				int rand_izquierda = randInt(0,5);
				int rand_derecha = randInt(0,5);
				int rand_arriba = randInt(0,5);
				int rand_abajo = randInt(0,5);
				
				if( rand_izquierda < 1){
					genera( i-1, j, Pieza.FORMA_TIERRA );
				}else{
					genera( i-1, j, Pieza.FORMA_AGUA );
				}
				if( rand_derecha < 1 ){
					genera( i+1, j, Pieza.FORMA_TIERRA );
				}else{
					genera( i+1, j, Pieza.FORMA_AGUA );
				}
				if( rand_arriba < 1 ){
					genera( i, j-1, Pieza.FORMA_TIERRA );
				}else{
					genera( i, j-1, Pieza.FORMA_AGUA );
				}
				if( rand_abajo < 1 ){
					genera( i, j+1, Pieza.FORMA_TIERRA );
				}else{
					genera( i, j+1, Pieza.FORMA_AGUA );
				}
			}else if( pieza_forma == Pieza.FORMA_TIERRA ){
				int rand_izquierda = randInt(0,5);
				int rand_derecha = randInt(0,5);
				int rand_arriba = randInt(0,5);
				int rand_abajo = randInt(0,5);
				
				
				if( rand_arriba < 1 ){
					genera( i, j-1, Pieza.FORMA_CESPED );
				}else{
					genera( i, j-1, Pieza.FORMA_TIERRA );
				}
				if( rand_abajo < 1 ){
					genera( i, j+1, Pieza.FORMA_CESPED );
				}else{
					genera( i, j+1, Pieza.FORMA_TIERRA );
				}
				if( rand_izquierda < 1){
					genera( i-1, j, Pieza.FORMA_CESPED );
				}else{
					genera( i-1, j, Pieza.FORMA_TIERRA );
				}
				if( rand_derecha < 1 ){
					genera( i+1, j, Pieza.FORMA_CESPED );
				}else{
					genera( i+1, j, Pieza.FORMA_TIERRA );
				}
			}else if( pieza_forma == Pieza.FORMA_CESPED ){
				int rand_izquierda = randInt(0,5);
				int rand_derecha = randInt(0,5);
				int rand_arriba = randInt(0,5);
				int rand_abajo = randInt(0,5);
				
				if( rand_arriba < 2 && rand_abajo < 2 ){
					genera( i, j-1, Pieza.FORMA_AGUA );
				}else{
					genera( i, j+1, Pieza.FORMA_CESPED );
				}
				if( rand_izquierda < 1 ){
					genera( i-1, j, Pieza.FORMA_TIERRA );
				}else{
					genera( i-1, j, Pieza.FORMA_CESPED );
				}
				if( rand_derecha < 1 ){
					genera( i+1, j, Pieza.FORMA_TIERRA );
				}else{
					genera( i+1, j, Pieza.FORMA_CESPED );
				}
				
			}
		}
	}
	
	public static int randInt(int min, int max) {
	    Random rand = new Random();

	    int randomNum = rand.nextInt((max - min) + 1) + min;

	    return randomNum;
	}
}

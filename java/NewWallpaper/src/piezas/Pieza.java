package piezas;

public class Pieza {

	private int forma = 0;
	public static final int FORMA_TIERRA = 0;
	public static final int FORMA_AGUA = 1;
	public static final int FORMA_CESPED = 2;
	
	private int i = 0,
			j = 0,
			w = 0,
			h = 0;
	
	public Pieza( int i, int j, int w, int h, int forma ){
		this.i = i;
		this.j = j;
		this.w = w;
		this.h = h;
		this.forma = forma;
	}

	/**
	 * @return the forma
	 */
	public int getForma() {
		return forma;
	}

	/**
	 * @param forma the forma to set
	 */
	public void setForma(int forma) {
		this.forma = forma;
	}

	/**
	 * @return the i
	 */
	public int getI() {
		return i;
	}

	/**
	 * @param i the i to set
	 */
	public void setI(int i) {
		this.i = i;
	}

	/**
	 * @return the j
	 */
	public int getJ() {
		return j;
	}

	/**
	 * @param j the j to set
	 */
	public void setJ(int j) {
		this.j = j;
	}

	/**
	 * @return the x
	 */
	public int getX() {
		return i*w;
	}


	/**
	 * @return the y
	 */
	public int getY() {
		return j*h;
	}


}

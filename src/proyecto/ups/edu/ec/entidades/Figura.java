package proyecto.ups.edu.ec.entidades;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Figura {

	private int id;
	private int x;
	private int y;
	private BufferedImage figura;
	private int mx;
	private int my;

	public Figura(int id, int x, int y, String ruta) {
		this.id = id;
		this.x = x;
		this.y = y;
		setFigura(ruta);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public BufferedImage getFigura() {
		return figura;
	}

	public void setFigura(String ruta) {
		try {
			figura = ImageIO.read(getClass().getClassLoader().getResource(ruta));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public int getMx() {
		return mx;
	}

	public void setMx(int mx) {
		this.mx = mx;
	}

	public int getMy() {
		return my;
	}

	public void setMy(int my) {
		this.my = my;
	}

}

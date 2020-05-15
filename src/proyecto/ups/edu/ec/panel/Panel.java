package proyecto.ups.edu.ec.panel;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import proyecto.ups.edu.ec.entidades.Figura;

public class Panel extends JPanel {

	private static final long serialVersionUID = 1L;
	private int ancho;
	private int alto;
	private int X[] = new int[3];
	private int Y;
	private int posY;
	private boolean drag = false;
	private Figura hueco;
	private Figura figIzq;
	private Figura figDer;
	private Figura fOp1;
	private Figura fOp2;
	private Figura fOp3;
	private int width;
	private int height;
	private String recursos[] = new String[6];
	private int nivel = 1;
	private int a = 0, b = 0, c = 0, d = 0, e = 0, f = 0;
	private int dimension = 1;
	private String colores[] = new String[] { "y", "b", "r" };

	public Panel() {
		setBackground(Color.WHITE);
		genera();
		nivel(nivel);
		setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				drag = true;
				int mx = e.getX();
				int my = e.getY();
				if (mx > fOp1.getX() && mx < fOp1.getX() + ancho && my > fOp1.getY() && my < fOp1.getY() + alto) {
					figuras(width, height);
					fOp1.setX(mx - ancho / 2);
					fOp1.setY(my - alto / 2);
					fOp1.setMx(mx);
					fOp1.setMy(my);
				} else if (mx > fOp2.getX() && mx < fOp2.getX() + ancho && my > fOp2.getY()
						&& my < fOp2.getY() + alto) {
					figuras(width, height);
					fOp2.setX(mx - ancho / 2);
					fOp2.setY(my - alto / 2);
				} else if (mx > fOp3.getX() && mx < fOp3.getX() + ancho && my > fOp3.getY()
						&& my < fOp3.getY() + alto) {
					figuras(width, height);
					fOp3.setX(mx - ancho / 2);
					fOp3.setY(my - alto / 2);
				}
				if (fOp1.getMx() > hueco.getX() && fOp1.getMx() < hueco.getX() + ancho && fOp1.getMy() > hueco.getY()
						&& fOp1.getMy() < hueco.getY() + alto && hueco.getId() == fOp1.getId()) {
					fOp1.setX(X[0]);
					fOp1.setY(Y);
					JOptionPane.showMessageDialog(null, "GANO!!!", "Game Over", 1);
					genera();
					drag = false;
					nivel(++nivel);
					componentes(width, height);
					if (nivel == 3) {
						nivel = 0;
						dimension = dimension > 2 ? 1 : ++dimension;
					}
				}
			}
		});
	}

	public void paint(Graphics g) {
		super.paint(g);
		width = getWidth();
		height = getHeight();
		componentes(width, height);
		g.drawImage(new ImageIcon("res/w4.jpg").getImage(), 0, 0, getWidth(), getHeight(), null);
		g.drawImage(figIzq.getFigura(), figIzq.getX(), figIzq.getY(), this);
		g.drawImage(hueco.getFigura(), hueco.getX(), hueco.getY(), this);
		g.drawImage(figDer.getFigura(), figDer.getX(), figDer.getY(), this);
		g.drawImage(fOp2.getFigura(), fOp2.getX(), fOp2.getY(), this);
		g.drawImage(fOp1.getFigura(), fOp1.getX(), fOp1.getY(), this);
		g.drawImage(fOp3.getFigura(), fOp3.getX(), fOp3.getY(), this);
		repaint();
	}

	protected void componentes(int width, int height) {
		hueco = new Figura(1, X[0], Y, recursos[0]);
		ancho = hueco.getFigura().getWidth();
		alto = hueco.getFigura().getHeight();
		X[a] = (width / 2) - ancho / 2;
		X[b] = (width / 3) - ancho;
		X[c] = 2 * (width / 3);
		Y = (height / 2) - alto;
		posY = (height - (alto + 5));
		if (!drag) {
			figIzq = new Figura(1, X[1], Y, recursos[1]);
			figDer = new Figura(1, X[2], Y, recursos[2]);
			figuras(width, height);
		}

	}

	protected void figuras(int width, int height) {
		fOp1 = new Figura(1, X[a], posY, recursos[3]);
		fOp2 = new Figura(2, X[b], posY, recursos[4]);
		fOp3 = new Figura(3, X[c], posY, recursos[5]);
	}

	protected void nivel(int nivel) {
		switch (nivel) {
		case 1:
			recursos[0] = "cuadrados/S_h_" + dimension + ".png";
			recursos[d] = "cuadrados/S_" + colores[a] + "_" + dimension + ".png";
			recursos[e] = "cuadrados/S_" + colores[b] + "_" + dimension + ".png";
			recursos[f] = "cuadrados/S_" + colores[c] + "_" + dimension + ".png";
			recursos[4] = "circulos/C_" + colores[d - 1] + "_" + dimension + ".png";
			recursos[5] = "triangulos/T_" + colores[e - 1] + "_" + dimension + ".png";
			break;
		case 2:
			recursos[0] = "circulos/C_h_" + dimension + ".png";
			recursos[d] = "circulos/C_" + colores[a] + "_" + dimension + ".png";
			recursos[e] = "circulos/C_" + colores[b] + "_" + dimension + ".png";
			recursos[f] = "circulos/C_" + colores[c] + "_" + dimension + ".png";
			recursos[4] = "cuadrados/S_" + colores[d - 1] + "_" + dimension + ".png";
			recursos[5] = "triangulos/T_" + colores[f - 1] + "_" + dimension + ".png";
			break;
		case 3:
			recursos[0] = "triangulos/T_h_" + dimension + ".png";
			recursos[d] = "triangulos/T_" + colores[a] + "_" + dimension + ".png";
			recursos[e] = "triangulos/T_" + colores[b] + "_" + dimension + ".png";
			recursos[f] = "triangulos/T_" + colores[c] + "_" + dimension + ".png";
			recursos[4] = "cuadrados/S_" + colores[e - 1] + "_" + dimension + ".png";
			recursos[5] = "circulos/C_" + colores[f - 1] + "_" + dimension + ".png";
			break;
		}
	}

	protected void genera() {
		a = b = c = 0;
		d = e = f = 0;
		while (a == b || b == c || c == a) {
			a = (int) (Math.random() * 3);
			b = (int) (Math.random() * 3);
			c = (int) (Math.random() * 3);
		}
		while (d == e || e == f || f == d) {
			d = (int) (Math.random() * 3) + 1;
			e = (int) (Math.random() * 3) + 1;
			f = (int) (Math.random() * 3) + 1;
		}
	}

}
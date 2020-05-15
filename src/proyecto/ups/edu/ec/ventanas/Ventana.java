package proyecto.ups.edu.ec.ventanas;

import java.awt.AWTException;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.MouseInfo;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;

import proyecto.ups.edu.ec.panel.Panel;

/**
 * 
 * @author fmont
 *
 */
public class Ventana extends JFrame implements KeyListener {

	private static final long serialVersionUID = 1L;
	private Panel panel;
	Robot Nro16;
	int x = 0;
	int y = 0;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		new Ventana().setVisible(true);
	}

	/**
	 * Create the frame.
	 */
	public Ventana() {
		setTitle("Juego");
		Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(d.width, d.height - 40);
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		getContentPane().setLayout(new BorderLayout());
		setLocationRelativeTo(null);
		try {
			Nro16 = new Robot();
		} catch (AWTException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		addKeyListener(this);

		panel = new Panel();
		getContentPane().add(panel, BorderLayout.CENTER);
	}

	@Override
	public void keyPressed(KeyEvent e) {
		x = MouseInfo.getPointerInfo().getLocation().x;
		y = MouseInfo.getPointerInfo().getLocation().y;
		if (e.getKeyCode() == KeyEvent.VK_7) {
			y += 5;
		}
		if (e.getKeyCode() == KeyEvent.VK_1) {
			y -= 5;
		}
		if (e.getKeyCode() == KeyEvent.VK_3) {
			x -= 5;
		}
		if (e.getKeyCode() == KeyEvent.VK_9) {
			x += 5;
		}
		if (e.getKeyCode() == KeyEvent.VK_7 && e.getKeyCode() == KeyEvent.VK_3) {
			y += 5;
			x -= 5;
		}
		if (e.getKeyCode() == KeyEvent.VK_1 && e.getKeyCode() == KeyEvent.VK_3) {
			y -= 5;
			x -= 5;
		}
		if (e.getKeyCode() == KeyEvent.VK_7 && e.getKeyCode() == KeyEvent.VK_9) {
			y += 5;
			x += 5;
		}
		if (e.getKeyCode() == KeyEvent.VK_1 && e.getKeyCode() == KeyEvent.VK_9) {
			y -= 5;
			x += 5;
		}
		if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
			System.exit(0);
		}
		Nro16.mouseMove(x, y);

	}

	@Override
	public void keyReleased(KeyEvent e) {

	}

	@Override
	public void keyTyped(KeyEvent e) {

	}

}

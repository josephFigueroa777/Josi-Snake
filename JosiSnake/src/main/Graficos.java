package main;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Graficos extends JPanel implements ActionListener, KeyListener{
	
	private Timer t = new Timer(100, this);
	public String estado;
	
	private Snake s;
	private Comida c;
	private Juego juego;
	
	private Main main = new Main();
	
	public Graficos(Juego j) {
		t.start();
		estado = "EMPEZO";
		
		juego = j;
		s = j.getJugador();
		c = j.getComida();
		
		//keyListener
		this.addKeyListener(j);
		this.setFocusable(true);
		this.setFocusTraversalKeysEnabled(false);
	}
	
	public void paintComponent(java.awt.Graphics g) {
		super.paintComponent(g);
		
		Graphics2D g2D = (Graphics2D) g;
		
		switch(juego.getId()) {
		case 1:
			g2D.setColor(Color.black);
			g2D.fillRect(0, 0, Juego.ANCHO * Juego.ESCALA + 5, Juego.ALTO * Juego.ESCALA + 5);
			break;
			
		case 2:
			g2D.setColor(Color.black);
			g2D.fillRect(0, 0, Juego.ANCHO * Juego.ESCALA + 5, Juego.ALTO * Juego.ESCALA + 5);
			
			g2D.setColor(Color.green);
			g2D.fillRect(140, 0, 20, 200);
			
			g2D.setColor(Color.green);
			g2D.fillRect(460, 0, 20, 200);
			
			g2D.setColor(Color.green);
			g2D.fillRect(140, (Juego.ALTO * Juego.ESCALA + 5) - 200, 20, 200);
			
			g2D.setColor(Color.green);
			g2D.fillRect(460, (Juego.ALTO * Juego.ESCALA + 5) - 200, 20, 200);
			break;
			
		case 3:
			g2D.setColor(Color.black);
			g2D.fillRect(0, 0, Juego.ANCHO * Juego.ESCALA + 5, Juego.ALTO * Juego.ESCALA + 5);
			
			g2D.setColor(Color.green);
			g2D.fillRect(140, 100, 100, 20);
			
			g2D.setColor(Color.green);
			g2D.fillRect(140, 100, 20, 100);
			
			//lado superior derecho
			g2D.setColor(Color.green);
			g2D.fillRect(360, 100, 100, 20);
			
			g2D.setColor(Color.green);
			g2D.fillRect(440, 100, 20, 100);
			
			//lado inferior izquierdo
			g2D.setColor(Color.green);
			g2D.fillRect(140, 400, 100, 20);
			
			g2D.setColor(Color.green);
			g2D.fillRect(140, 300, 20, 100);
			
			//lado inferior derecho
			g2D.setColor(Color.green);
			g2D.fillRect(360, 400, 100, 20);
					
			g2D.setColor(Color.green);
			g2D.fillRect(440, 300, 20, 100);
			break;
			
		case 4:
			g2D.setColor(Color.black);
			g2D.fillRect(0, 0, Juego.ANCHO * Juego.ESCALA + 5, Juego.ALTO * Juego.ESCALA + 5);
			
			g2D.setColor(Color.green);
			g2D.fillRect(juego.getVentana().getWidth()/2, (juego.getVentana().getHeight()/2) - 90, 20, 200);
			
			g2D.setColor(Color.green);
			g2D.fillRect((juego.getVentana().getWidth()/2) - 100, (juego.getVentana().getHeight()/2) - 110, 220, 20);
			
			g2D.setColor(Color.green);
			g2D.fillRect((juego.getVentana().getWidth()/2) - 140, (juego.getVentana().getHeight()/2) + 110, 160, 20);
			break;
		}
//		//fondo
//		g2D.setColor(Color.black);
//		g2D.fillRect(0, 0, Juego.ANCHO * Juego.ESCALA + 5, Juego.ALTO * Juego.ESCALA + 5);
		
		//////////////////////////////////////////////////
		///empieza el mapa uno
		//////////////////////////////////////////////////
//		g2D.setColor(Color.green);
//		g2D.fillRect(140, 0, 20, 200);
//		
//		g2D.setColor(Color.green);
//		g2D.fillRect(460, 0, 20, 200);
//		
//		g2D.setColor(Color.green);
//		g2D.fillRect(140, (Juego.ALTO * Juego.ESCALA + 5) - 200, 20, 200);
//		
//		g2D.setColor(Color.green);
//		g2D.fillRect(460, (Juego.ALTO * Juego.ESCALA + 5) - 200, 20, 200);
		//////////////////////////////////////////////////
		///termina el mapa uno
		//////////////////////////////////////////////////
		
		//////////////////////////////////////////////////
		///empieza el mapa dos
		//////////////////////////////////////////////////
		
		//lado superior izquierdo
//		g2D.setColor(Color.green);
//		g2D.fillRect(140, 100, 100, 20);
//		
//		g2D.setColor(Color.green);
//		g2D.fillRect(140, 100, 20, 100);
//		
//		//lado superior derecho
//		g2D.setColor(Color.green);
//		g2D.fillRect(360, 100, 100, 20);
//		
//		g2D.setColor(Color.green);
//		g2D.fillRect(440, 100, 20, 100);
//		
//		//lado inferior izquierdo
//		g2D.setColor(Color.green);
//		g2D.fillRect(140, 400, 100, 20);
//		
//		g2D.setColor(Color.green);
//		g2D.fillRect(140, 300, 20, 100);
//		
//		//lado inferior derecho
//		g2D.setColor(Color.green);
//		g2D.fillRect(360, 400, 100, 20);
//				
//		g2D.setColor(Color.green);
//		g2D.fillRect(440, 300, 20, 100);
		
		//////////////////////////////////////////////////
		///termina el mapa sgundo
		//////////////////////////////////////////////////
		
		//////////////////////////////////////////////////
		///empieza el mapa tercera
		//////////////////////////////////////////////////
		
//		g2D.setColor(Color.green);
//		g2D.fillRect(juego.getVentana().getWidth()/2, (juego.getVentana().getHeight()/2) - 90, 20, 200);
//		
//		g2D.setColor(Color.green);
//		g2D.fillRect((juego.getVentana().getWidth()/2) - 100, (juego.getVentana().getHeight()/2) - 110, 220, 20);
//		
//		g2D.setColor(Color.green);
//		g2D.fillRect((juego.getVentana().getWidth()/2) - 140, (juego.getVentana().getHeight()/2) + 110, 160, 20);
		
		//////////////////////////////////////////////////
		///termina el mapa tercero
		//////////////////////////////////////////////////
		
		if(estado == "EMPEZO") {
			g2D.setColor(Color.yellow);
			g2D.drawString("Presiona una tecla", Juego.ANCHO/2 * Juego.ESCALA - 40, Juego.ALTO/2 * Juego.ESCALA - 20);
		} else if(estado == "CORRIENDO") {
			
			//dibujar puntuacion 
			g2D.setColor(Color.yellow);
			g2D.drawString("Score: " + (s.getCuerpo().size() - 1) + "\t\t\t\t\tHora: " + Juego.horaActual(), Juego.ANCHO/2 * Juego.ESCALA - 70 , 40);
			// dibuja la cabeza
			g2D.setColor(Color.red);
			g2D.fillRect(c.getX()* Juego.ESCALA, c.getY()* Juego.ESCALA, Juego.ESCALA, Juego.ESCALA);
		
			//dibuja el cuerpo
			g2D.setColor(Color.yellow);
			for(Rectangle r : s.getCuerpo()) {
				g2D.fill(r);
			}
		} else {
			g2D.setColor(Color.yellow);
			g2D.drawString("Score: " + (s.getCuerpo().size() - 1), Juego.ANCHO/2 * Juego.ESCALA - 40, Juego.ALTO/2 * Juego.ESCALA - 20);
			
			keyPressed(null);
		}	
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		repaint();
		
		juego.actualizar();
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		int codigoDelTeclado = e.getKeyCode();
		
		if(codigoDelTeclado == KeyEvent.VK_ENTER) {
			Main main = new Main();
			main.setVisible(true);
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

}

package main;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JDialog;
import javax.swing.JFrame;

public class Juego implements KeyListener{
	
	private Snake jugador;
	private Comida comida;
	private Graficos grafico;
	
	private JFrame ventana;
	
	private int id = 0;
	
	//dimensiones 
	public static final int ANCHO = 30;
	public static final int ALTO = 30;
	public static final int ESCALA = 20;
	
	public Juego(int _id) {
		id = _id;
		ventana = new JFrame();
		
		jugador = new Snake();
		comida = new Comida(jugador);
		grafico = new Graficos(this);
		
		ventana.add(grafico);
		
		ventana.setTitle("Josi Snake");
		ventana.setSize(ANCHO * ESCALA + 2, ALTO * ESCALA + ESCALA + 4);
		ventana.setVisible(true);
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public static String horaActual() {
		
		DateFormat dateFormat;
		Date date;
		
		dateFormat = new SimpleDateFormat("HH:mm:ss");
		date = new Date();
		
		return  dateFormat.format(date);
	}
	
	public void start() {
		grafico.estado = "CORRIENDO";
	}
	
	public void actualizar() {
		
		switch(getId()) {
		case 1:
			if(grafico.estado == "CORRIENDO") {
				if(colisionConComida()) {
					jugador.comiendo();
					comida.respaneo(jugador);
				} else if (colisionConPared() || colisionContigo()) {
				grafico.estado = "FINAL";
				} else {
					jugador.move();
				}
			}
			break;
		case 2:
			if(grafico.estado == "CORRIENDO") {
				if(colisionConComida()) {
					jugador.comiendo();
					comida.respaneo(jugador);
				} else if (colisionConPared() || colisionContigo() || mapaUnoColision()) {
				grafico.estado = "FINAL";
				} else {
					jugador.move();
				}
			}
			break;
		case 3:
			if(grafico.estado == "CORRIENDO") {
				if(colisionConComida()) {
					jugador.comiendo();
					comida.respaneo(jugador);
				} else if (colisionConPared() || colisionContigo() || mapaDosColision()) {
				grafico.estado = "FINAL";
				} else {
					jugador.move();
				}
			}
			break;
		case 4:
			if(grafico.estado == "CORRIENDO") {
				if(colisionConComida()) {
					jugador.comiendo();
					comida.respaneo(jugador);
				} else if (colisionConPared() || colisionContigo() || mapaTresColision()) {
				grafico.estado = "FINAL";
				} else {
					jugador.move();
				}
			}
			break;
		}
			
	}
	/*Cuando este el mapa numero uno dibujado debemos llamar la funcion MapaUnoColsion
	 * en el if de el metodo actualizar con un OR (||)*/
	public boolean mapaUnoColision() {
		if((jugador.obtenerX() == 140 || jugador.obtenerX() == 460) && (jugador.obtenerY() >= 0 && jugador.obtenerY() <= 180)) {
			return true;
		}
		else if((jugador.obtenerX() == 140 || jugador.obtenerX() == 460) && (jugador.obtenerY() >= (Juego.ALTO * Juego.ESCALA + 5) - 220 && jugador.obtenerY() <= (Juego.ALTO * Juego.ESCALA + 5))) {
			return true;
		}
		return false;
	}
	
	public boolean mapaDosColision() {
		if((jugador.obtenerX() == 140 && jugador.obtenerY() >= 100 && jugador.obtenerY() <= 180) || (jugador.obtenerY() == 100 && jugador.obtenerX() >= 140 && jugador.obtenerX() <= 220)) {
			return true;
		}
		else if((jugador.obtenerX() == 440 && jugador.obtenerY() >= 100 && jugador.obtenerY() <= 180) || (jugador.obtenerY() == 100 && jugador.obtenerX() <= 440 && jugador.obtenerX() >= 360)) {
			return true; 
		}
		else if((jugador.obtenerX() == 140 && jugador.obtenerY() >= 300 && jugador.obtenerY() <= 400) || (jugador.obtenerY() == 400 && jugador.obtenerX() <= 220 && jugador.obtenerX() >= 140)) {
			return true;
		}
		else if((jugador.obtenerX() == 440 && jugador.obtenerY() >= 300 && jugador.obtenerY() <= 400) || (jugador.obtenerY() == 400 && jugador.obtenerX() <= 440 && jugador.obtenerX() >= 360)) {
			return true;
		}
		return false;
	}
	
	public boolean mapaTresColision() {
		if((jugador.obtenerY() == 200 && (jugador.obtenerX() >= 200 && jugador.obtenerX() <= 400)) || ((jugador.obtenerY() >= 220 && jugador.obtenerY() <= 420) && jugador.obtenerX() == 300) || (jugador.obtenerY() == 420 && (jugador.obtenerX() >= 160 && jugador.obtenerX() <= 300))) {
			return true;
		}
		return false;
	}
	
	public boolean colisionConPared() {
		if(jugador.obtenerX() < 0 || jugador.obtenerX() >= ALTO * ESCALA || jugador.obtenerY() < 0 || jugador.obtenerY() >= ALTO * ESCALA) {
			return true;
		}
		return false;
	}
	
	public boolean colisionConComida() {
		if(jugador.obtenerX() == comida.getX() * ESCALA && jugador.obtenerY() == comida.getY() * ESCALA) {
			return true;
		}
		return false;
	}
	
	public boolean colisionContigo() {
		//empieza en uno por que 0 es tu cabeza
		for(int i = 1; i < jugador.getCuerpo().size(); i++) {
			if(jugador.obtenerX() == jugador.getCuerpo().get(i).x && jugador.obtenerY() == jugador.getCuerpo().get(i).y) {
				return true;
			}
		}
		return false;
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		int codigoDelTeclado = e.getKeyCode();
		
		if(grafico.estado == "CORRIENDO") {
			if(codigoDelTeclado == KeyEvent.VK_W && jugador.getMove() != "ABAJO") {
				jugador.arriba();
			} else if(codigoDelTeclado == KeyEvent.VK_S && jugador.getMove() != "ARRIBA") {
				jugador.abajo();
			} else if(codigoDelTeclado == KeyEvent.VK_A && jugador.getMove() != "DERECHA") {
				jugador.izquierda();
			} else if(codigoDelTeclado == KeyEvent.VK_D && jugador.getMove() != "IZQUIERDA") {
				jugador.derecha();
			}
		} else {
			this.start();
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
	}

	public Snake getJugador() {
		return jugador;
	}

	public void setJugador(Snake jugador) {
		this.jugador = jugador;
	}

	public Comida getComida() {
		return comida;
	}

	public void setComida(Comida comida) {
		this.comida = comida;
	}

	public JFrame getVentana() {
		return ventana;
	}

	public void setVentana(JFrame ventana) {
		this.ventana = ventana;
	}
	
	public int getId() { return id;}

}

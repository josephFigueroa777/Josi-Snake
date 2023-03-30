package main;

import java.awt.Rectangle;
import java.util.ArrayList;

public class Snake {
	
	private ArrayList<Rectangle> cuerpo;
	
	//Los valores de esta cadena son {NADA, ARRIBA, ABAJO, DERECHA, IZQUIERDA}
	private String movimiento; 
	
	public Snake() {
		cuerpo = new ArrayList<>();
		
		Rectangle temporal = new Rectangle(Juego.ESCALA, Juego.ESCALA);
		//temporal.setLocation(Juego.ANCHO/2 * Juego.ESCALA, Juego.ALTO/2 * Juego.ESCALA);
		temporal.setLocation(0, 0);
		cuerpo.add(temporal);
		
		movimiento = "NADA";
		
	}
	
	public void move() {
		if(movimiento != "NADA") {
			Rectangle primero = cuerpo.get(0);
			Rectangle temporal = new Rectangle(Juego.ESCALA, Juego.ESCALA);
			
			if(movimiento == "ARRIBA") {
				temporal.setLocation(primero.x, primero.y - Juego.ESCALA);
			} else if (movimiento == "ABAJO") {
				temporal.setLocation(primero.x, primero.y + Juego.ESCALA);
			} else if (movimiento == "IZQUIERDA") {
				temporal.setLocation(primero.x - Juego.ESCALA, primero.y);
			} else if (movimiento == "DERECHA") {
				temporal.setLocation(primero.x + Juego.ESCALA, primero.y);
			}
			cuerpo.add(0, temporal);
			cuerpo.remove(cuerpo.size() - 1);
		}
	}
	
	public void comiendo() {
		if(movimiento != "NADA") {
			Rectangle primero = cuerpo.get(0);
			Rectangle temporal = new Rectangle(Juego.ESCALA, Juego.ESCALA);
			
			if(movimiento == "ARRIBA") {
				temporal.setLocation(primero.x, primero.y - Juego.ESCALA);
			} else if (movimiento == "ABAJO") {
				temporal.setLocation(primero.x, primero.y + Juego.ESCALA);
			} else if (movimiento == "IZQUIERDA") {
				temporal.setLocation(primero.x - Juego.ESCALA, primero.y);
			} else if (movimiento == "DERECHA") {
				temporal.setLocation(primero.x + Juego.ESCALA, primero.y);
			}
			cuerpo.add(0, temporal);
		}
	}

	public ArrayList<Rectangle> getCuerpo() {
		return cuerpo;
	}

	public void setCuerpo(ArrayList<Rectangle> cuerpo) {
		this.cuerpo = cuerpo;
	}
	
	public int obtenerX() {
		return cuerpo.get(0).x;
	}
	public int obtenerY() {
		return cuerpo.get(0).y;
	}
	public String getMove() {
		return movimiento;
	}
	
	public void arriba() {
		if (movimiento != "ABAJO")
			movimiento = "ARRIBA";
	}
	public void abajo() {
		if (movimiento != "ARRIBA")
			movimiento = "ABAJO";
	}
	public void derecha() {
		if (movimiento != "IZQUIERDA")
			movimiento = "DERECHA";
	}
	public void izquierda() {
		if (movimiento != "DERECHA")
			movimiento = "IZQUIERDA";
	}
	
}

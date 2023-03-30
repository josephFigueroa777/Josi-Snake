package main;

import java.awt.Rectangle;

public class Comida {

	//corrdenadas
	private int x;
	private int y;
	
	public Comida(Snake jugador) {
		this.respaneo(jugador);
	}
	public void respaneo(Snake jugador) {
	
		
		boolean onSnake = true;
		while(onSnake) {
			onSnake = false;
			
			x = (int)(Math.random() * Juego.ANCHO - 1);
			y = (int)(Math.random() * Juego.ALTO - 1);
			for(Rectangle r : jugador.getCuerpo()) {
				if(r.x == x && r.y == y) {
					onSnake = true;
				}
			}
		}
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
}

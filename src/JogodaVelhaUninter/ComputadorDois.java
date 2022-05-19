package JogodaVelhaUninter;

import java.util.Random;

public class ComputadorDois extends Computador{
	Random qualquerNumero = new Random();

	@Override
	public void operar(String[][] grafico) {
		// Posi��o aleatoria � gerada para a marca��o
		int x,y;
		while(true){
			x = qualquerNumero.nextInt(3);
			y = qualquerNumero.nextInt(3);
			if(grafico[x][y].equals(" ")){
				grafico[x][y] = "O";
				return;
			}
		}

	}
}

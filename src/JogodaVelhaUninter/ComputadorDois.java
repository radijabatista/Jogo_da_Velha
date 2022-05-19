package JogodaVelhaUninter;

import java.util.Random;

public class ComputadorDois extends Computador{
	Random qualquerNumero = new Random();

	@Override
	public void operar(String[][] grafico) {
		// Posição aleatoria é gerada para a marcação
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

package JogodaVelhaUninter;


public class ComputadorUm {
	public void operar(String grafico[][]){
		//aqui � localizado o primeiro espa�o n�o marcado, fazendo uma limpeza horizontal e marcando logo em seguida
		for(int t = 0; t < 3; t++) {
			for(int g = 0; g < 3; g++){
				if(grafico[t][g].equals(" ")){
					grafico[t][g] = "O";
					return;
				}
			}
		}
	}
}

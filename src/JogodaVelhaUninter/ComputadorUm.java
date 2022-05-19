package JogodaVelhaUninter;


public class ComputadorUm {
	public void operar(String grafico[][]){
		//aqui é localizado o primeiro espaço não marcado, fazendo uma limpeza horizontal e marcando logo em seguida
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

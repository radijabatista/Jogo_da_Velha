package JogodaVelhaUninter;

import java.util.Random;


public class ComputadorTres extends Computador{

	Random qualquerNumero = new Random();
	@Override
	public void operar(String[][] grafico) {
		// aqui a maquina impedira que o jogador ven�a, marcando sempre ao redor do mesmo
		// caso n�o seja possivel jogar em nenhum lado nesse modelo, � usado um modelo aleatorio de marca��o
		for(int t = 0; t < 3; t++){
			for(int g = 0; g < 3; g++){
				if(grafico[t][g].equals("X")){
					//verifica se os lados horizontais foram marcados e realizando a marca��o caso negativo
					try {
						if(grafico[t+1][g].equals(" ")){
							grafico[t=1][g] = "O";
							return;
						}
					}catch(Exception e){

					}

					try{
						if(grafico[t-1][g].equals(" ")){
							grafico[t-1][g] = "O";
							return;	
						}
					}catch(Exception e){

					}      

					//verifica se existe marca��o nos lados verticais, se n�o houver a mesma � realizada
					try{
						if(grafico[t][g+1].equals(" ")){
							grafico[t][g+1] = "O";
							return;
						}
					}catch(Exception e){

					}
					
					try{
						if(grafico[t][g-1].equals(" ")){
							grafico[t][g-1] = "O";
							return;
						}
					}catch(Exception e){

					}
				}
			}
		}

		//se o modelo acima falhar ser� usada um outro aleat�rio
		int x;
		while(true){
			x = qualquerNumero.nextInt(3);
			for(int g = 0; g < 3; g++){
				if(grafico[x][g].equals(" ")){
					grafico[x][g] = "O";
					return;
				}
			}
		}
	}

}
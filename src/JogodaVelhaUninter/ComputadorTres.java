package JogodaVelhaUninter;

import java.util.Random;


public class ComputadorTres extends Computador{

	Random qualquerNumero = new Random();
	@Override
	public void operar(String[][] grafico) {
		// aqui a maquina impedira que o jogador vença, marcando sempre ao redor do mesmo
		// caso não seja possivel jogar em nenhum lado nesse modelo, é usado um modelo aleatorio de marcação
		for(int t = 0; t < 3; t++){
			for(int g = 0; g < 3; g++){
				if(grafico[t][g].equals("X")){
					//verifica se os lados horizontais foram marcados e realizando a marcação caso negativo
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

					//verifica se existe marcação nos lados verticais, se não houver a mesma é realizada
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

		//se o modelo acima falhar será usada um outro aleatório
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
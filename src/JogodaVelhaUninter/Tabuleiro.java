package JogodaVelhaUninter;


public class Tabuleiro {
	//X - HUMANO | O - COMPUTADOR
	public String localizacoesTabuleiro[][] = new String[3][3];//mapa do tabuleiro
	public int numeroDeLances;
	private String marcaDoGanhador; //armazenar a marca (X ou O) 

	public Tabuleiro(){
		this.numeroDeLances = 0;
		iniciarPosicoes();
		this.marcaDoGanhador = "";
	}

	private void iniciarPosicoes(){
		//começa todas as localizacoes
		for(int t = 0; t < 3; t++){
			for(int g = 0; g < 3; g++){
				this.localizacoesTabuleiro[t][g] = " ";
			}
		}
	}

	private void renovarTela(){
		for(int t = 0; t < 30; t++){
			System.out.println();
		}
		System.out.println("\t\tJOGO DA VELHA");
		System.out.println("X - VOCÊ | O - COMPUTADOR\n");
	}

	public void mostrarTabuleiro(){
		renovarTela(); // padroniza a tela 

		// mostra as marcações do tabuleiro e a jogada realizada
		for(int t = 0; t < 3; t++){
			for(int g = 0; g < 3; g++){
				System.out.print(this.localizacoesTabuleiro[t][g]);
				if(g<2){
					System.out.print("|");
				}

			}
			if(t<2){
				System.out.println("\n-|-|-");
			}
		}
		System.out.println("\n");
	}

	public boolean analisarVitoria(){
		//Verificação de possibilidade de uma vitoria por número de jogadas
		if(numeroDeLances < 5){
			return false;
		}
		// se acontecer uma vitoria a variavel "marcaDoGanhador" ira armazenar a marca do jogador
		//Verificação de vitoria diagonal 1 
		if(localizacoesTabuleiro[0][0].equals(localizacoesTabuleiro[1][1]) && localizacoesTabuleiro[1][1].equals(localizacoesTabuleiro[2][2]) && !(localizacoesTabuleiro[1][1].equals(" "))){
			this.marcaDoGanhador = localizacoesTabuleiro[0][0];
			return true;
		}

		if(localizacoesTabuleiro[2][0].equals(localizacoesTabuleiro[1][1]) && localizacoesTabuleiro[1][1].equals(localizacoesTabuleiro[0][2]) && !(localizacoesTabuleiro[1][1].equals(" "))){
			this.marcaDoGanhador = localizacoesTabuleiro[2][0];
			return true;

		}

		//loop que analisa as possibilidades de vitoria verticais e horizontais
		for(int t = 0; t < 3; t++){
			//Verificar vitoria VERTICAL
			if(localizacoesTabuleiro[t][0].equals(localizacoesTabuleiro[t][1]) && localizacoesTabuleiro[t][1].equals(localizacoesTabuleiro[t][2]) && !(localizacoesTabuleiro[t][1].equals(" "))){
				this.marcaDoGanhador = localizacoesTabuleiro[t][0];
				return true;
			}

			// Verificar vitoria HORIZONTAL
			if(localizacoesTabuleiro[0][t].equals(localizacoesTabuleiro[1][t]) && localizacoesTabuleiro[1][t].equals(localizacoesTabuleiro[2][t]) && !(localizacoesTabuleiro[1][t].equals(" "))){
				this.marcaDoGanhador = localizacoesTabuleiro[0][t];
				return true;
			}

		}
		return false;
	}

	public String status(){
		//mostra status atual da partida
		boolean statusVitoria = analisarVitoria();
		if(statusVitoria == false && numeroDeLances == 9){
			return "EMPATE";
		}else if(statusVitoria == false){
			return "INCOMPLETO";
		}else{
			if(this.marcaDoGanhador == "X"){
				return "JOGADOR VENCEU";
			}else{
				return "COMPUTADOR VENCEU";
			}
		}
	}
}
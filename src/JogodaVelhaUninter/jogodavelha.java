package JogodaVelhaUninter;
import java.util.Scanner;

public class jogodavelha {

	public static void main(String[] args){

		//invocando componentes importantes ao jogo
		Scanner teclado = new Scanner(System.in);

		Jogador jogador = new Jogador();
		ComputadorUm pc1 = new ComputadorUm();
		ComputadorDois pc2 = new ComputadorDois();
		ComputadorTres pc3 = new ComputadorTres();

		while(true){
			Tabuleiro tab = new Tabuleiro();
			int nivel = menu();//exibe o menu e retorna a escolha de n�veis
			boolean triunfoJogador;

			//inicia o jogo com o n�vel selecionado
			do{
				//se o tabuleiro for completado o loop termina
				if(tab.numeroDeLances == 9){
					break;
				}
				String x,y; // variaveis para o jogador come�ar
				x = y = "";
				tab.mostrarTabuleiro();
				//obriga o usu�rio a digitar um numero
				do{
					System.out.print("Disposi��o de linha: "); x = teclado.next();
					System.out.print("Disposi��o de coluna: "); y  = teclado.next();
				}while(!(jogador.operar(tab.localizacoesTabuleiro, x, y)));
				tab.numeroDeLances++;//adicionando numero de jogadas

				// verifica��o se ap�s a jogada anterior houve uma vit�ria para mostrar o tabuleiro sem jogadas adicionais da m�quina
				triunfoJogador = tab.analisarVitoria();
				if(!(triunfoJogador)){
					//fazendo uma jogada com o n�vel selecionado
					switch(nivel){
					case 1:
						pc1.operar(tab.localizacoesTabuleiro);
						break;
					case 2:
						pc2.operar(tab.localizacoesTabuleiro);
						break;
					case 3:
						pc3.operar(tab.localizacoesTabuleiro);
						break;
					}
					tab.numeroDeLances++;//acrescentando numero de jogadas
				}
			}

			while(!(tab.analisarVitoria()));// se acontecer a vit�ria o loop encerra

			//fazendo amostras finais
			tab.mostrarTabuleiro();
			System.out.println(tab.status());
			System.out.println("Digite algo e pressione enter para operar novamente");
			teclado.next();
		}
	}

	public static int menu(){
		//este menu � resposavel pela escolha do nivel
		Scanner teclado = new Scanner(System.in);
		int nivel = 0;

		//loop que s� termina selecionando um dos 3 n�veis dispon�veis
		while(true){
			try{
				System.out.print("\nEscolha o n�vel (1-3): ");
				nivel = Integer.parseInt(teclado.next());

				switch(nivel){
				case 1:
					return 1;
				case 2:
					return 2;
				case 3:
					return 3;
				default:
					System.out.println("O N�vel selecionado n�o � v�lido");
				}
				teclado.close();
			}catch(Exception e){
				System.out.println("Dados n�o � validos");
			}
		}
	}
}

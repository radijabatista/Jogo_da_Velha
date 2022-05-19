package JogodaVelhaUninter;


public class Jogador {

	public boolean operar(String grafico[][], String horizontal, String vertical){
		//faz a analise de posições ocupadas, caso tenha alguma que não esteja ela é marcada com um X
		try{
			//transforma os dados que foram inseridos pelo usuário para servirem de índices
			int x = Integer.parseInt(horizontal);
			int y = Integer.parseInt(vertical);
			if(grafico[x-1][y-1].equals(" ")){
				grafico[x-1][y-1] = "X";
				return true;
			}else{
				//aparece mensagem caso a posição esteja ocupada
				System.out.println("Posição ocupada");
				return false;
			}
		}catch(Exception e){
			System.out.println("Valor não é valido");
			return false;		
		}
	}
}
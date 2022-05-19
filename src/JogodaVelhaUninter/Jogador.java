package JogodaVelhaUninter;


public class Jogador {

	public boolean operar(String grafico[][], String horizontal, String vertical){
		//faz a analise de posi��es ocupadas, caso tenha alguma que n�o esteja ela � marcada com um X
		try{
			//transforma os dados que foram inseridos pelo usu�rio para servirem de �ndices
			int x = Integer.parseInt(horizontal);
			int y = Integer.parseInt(vertical);
			if(grafico[x-1][y-1].equals(" ")){
				grafico[x-1][y-1] = "X";
				return true;
			}else{
				//aparece mensagem caso a posi��o esteja ocupada
				System.out.println("Posi��o ocupada");
				return false;
			}
		}catch(Exception e){
			System.out.println("Valor n�o � valido");
			return false;		
		}
	}
}
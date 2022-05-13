/**
*@author v.hofmeister@edu.pucrs.br
*@version 2022-05-08
*/
import java.util.Random;
import java.util.Scanner;

public class JogoDeAzarMelhor{

	public static String Titulo(String titulo){
		System.out.printf(titulo.toUpperCase() + "!\n\n");
		return "";
	}
	public static String FimDeJogo(){
		System.out.printf("\nFIM DE JOGO!\n\n");
		return "";
	}
	public static String ParImpar(int numero){
		String valor = "";

		if (numero % 2 == 0){
			valor = "par";
		} else {
			valor = "impar";
		}

		return valor;
	}
	public static boolean Par(String resposta){

	 	return resposta.equalsIgnoreCase("par");
	}
	public static boolean Impar(String resposta){

		return resposta.equalsIgnoreCase("impar");
	}
	public static boolean Fim(String resposta){

		return resposta.equalsIgnoreCase("fim");
	}
	public static boolean TentativaValida(String resposta){

		return Par(resposta) || Impar(resposta) || Fim(resposta);
	}
	public static boolean Igualdade(String valor1, String valor2){

		return Par(valor1) && Par(valor2) || Impar(valor1) && Impar(valor2);
	}
	public static int EntrarAposta(Scanner sc){
		System.out.printf("\nQuanto voce deseja apostar?\n");
		return sc.nextInt();
	}
	public static String EntrarTentativa(Scanner sc){
		System.out.printf("Adivinhe se o numero sorteado é 'par' ou 'impar'\n\n");
		String tentativa = sc.next();

		while (!TentativaValida(tentativa)){
				
			System.out.printf("\nInsira uma resposta valida!\n\n");
			tentativa = sc.next();
		}
		return tentativa;		
	}
	public static int GeraAleatorio(Random r, int quantidade){
		
		return r.nextInt(quantidade);
	}
	public static String Placar(int pontos1, int pontos2){
		System.out.printf("%d x %d\n", pontos1, pontos2);
		return "";
	}
	public static String Saldo(int saldo){
		System.out.printf("Seu saldo é %d\n\n",saldo);
		return "";
	}
	public static boolean ChecaSaldo(int saldo){

		return saldo <= 0;
	}

	public static void main(String args[]){
		Scanner teclado;
		Random aleatorio;
		String tentativa, gabarito;
		int numero, saldo, pontosPrograma, pontosUsuario, aposta;

		teclado = new Scanner(System.in);
		aleatorio = new Random();
		pontosPrograma = 0;
		pontosUsuario = 0;		
		saldo = 100;
		tentativa = "";

		Titulo("jogo de azar");
		Saldo(saldo);

		while (true){

			numero = GeraAleatorio(aleatorio, 10);
			gabarito = ParImpar(numero);
			tentativa = EntrarTentativa(teclado);

			if (Fim(tentativa)){
				FimDeJogo();
				break;
			}

			aposta = EntrarAposta(teclado);

			if (Igualdade(tentativa, gabarito)){
				System.out.printf("\nACERTOU!\n");
				//System.out.printf("\n%d\n", numero);
				pontosUsuario++;
				saldo += aposta;

			} else {
				System.out.printf("\nERROU!\n");
				//System.out.printf("\n%d\n", numero);
				pontosPrograma++;
				saldo -= aposta;
			}

			Placar(pontosUsuario, pontosPrograma);
			Saldo(saldo);

			if(ChecaSaldo(saldo)){
				FimDeJogo();
				break;
			}
		}

		teclado.close();
	}
}
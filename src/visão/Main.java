package visão;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

import entidade.Barco;
import entidade.BarcoEnorme;
import entidade.BarcoGrande;
import entidade.BarcoMedio;
import entidade.BarcoPequeno;
import entidade.Jogador;
import exception.CoordenadaInvalidaException;
import exception.DirecaoInvalidaException;


public class Main {
	public static void main(String args[]) throws FileNotFoundException, IOException{
		
		int opcao, tamanho=2;
		String aux="";
		String jog[] = {"jogador1", "jogador2"};
		String barcoTam[] = {"pequeno", "medio", "grande", "enorme"}; 
		int contaBarco=0, contaJog=0, i=0, j=0;
		int linha[] = new int[5];
		int coluna[] = new int[5];
		boolean test = false;
		int coord[][]= new int[5][2];
		
		Scanner in = new Scanner(System.in);
		ControleJogo cj = new ControleJogo();
		
		//array de objetos jogador
		Jogador jogador[] = new Jogador[2];
		jogador[0] = new Jogador();
		jogador[1] = new Jogador();
		
		//array polimorfo de objetos Barco
		Barco frota1[] = new Barco[4];
		frota1[0]= new BarcoPequeno();
		frota1[1]= new BarcoMedio();
		frota1[2]= new BarcoGrande();
		frota1[3]= new BarcoEnorme();
		
		//array polimorfo2
		Barco frota2[] = new Barco[4];
		frota2[0]= new BarcoPequeno();
		frota2[1]= new BarcoMedio();
		frota2[2]= new BarcoGrande();
		frota2[3]= new BarcoEnorme();

		try{
			int opc=0;
			while(opc != 3){
				System.out.println("        Batalha Naval\n\n");
				System.out.println("        1- dois Jogadores");
				System.out.println("        2- Instruções");
				System.out.println("        3- Sair");
				opc = in.nextInt();
				switch(opc){
					case 1:
						for (int a=0; a<2;a++){
							System.out.println("["+jog[contaJog]+"]\nEscolha as coordenadas dos seus barcos.");
							i=0;
							contaBarco = 0;
							tamanho=2;
							
							for (int b=0; b<4;b++){
								test = false;
								
								System.out.println("[Barco "+barcoTam[contaBarco]+"]");
								System.out.println("Digite a primeira linha: ");
								linha[0] =in.nextInt();
								
								cj.validaCoordenada(linha[0]);
								
								System.out.println("Digite a primeira coluna: ");
								//aux =in.next();
								//coluna[0] = cj.Converte(aux);
								coluna[0] =in.nextInt();
								
								cj.validaCoordenada(coluna[0]);
								
								System.out.println("As demais coordenadas:\n 1-Cima\n 2-Baixo\n 3-Direita\n 4-Esquerda");
								opcao = in.nextInt();
								
								cj.validaDirecao(opcao);//Exception opcao
								
								test = cj.direcao(opcao); //coluna ou linha serão estáticos?
								
								if(test == true){       //se linha for estática...
									coluna = cj.cordEstático(linha[0], coluna[0], test, tamanho);
								}
								else{					//se coluna for estática...
									linha = cj.cordEstático(linha[0], coluna[0], test, tamanho);
								}
								
								
								if(test == true){		//se linha for variável...
									linha = cj.cordVariavel(tamanho, opcao, linha[0], coluna[0], test);
								}
								else{					//se coluna for variável...
									coluna = cj.cordVariavel(tamanho, opcao, linha[0], coluna[0], test);
								}
								
								//converte dois arrays unidimensionais e um bidimensional
								coord = cj.tornandoCoordenada(linha, coluna, test, tamanho);
								//set array bidimensional no barco pequeno
								if(j == 0){
									frota1[i].setCoordenada(coord);
								}else if(j ==1){
									frota2[i].setCoordenada(coord);
								}
								
								i++;
								contaBarco++;
								tamanho++;
								
							}
							if(j == 0){
								jogador[j].setFrota(frota1);
							}else if(j ==1){
								jogador[j].setFrota(frota2);
							}
							
							contaJog++;
							j++;
							
						}
						// imprimindo coordenadas dos barcos com get
						int cont1 = 2;
						int p=0;
						for(int w=0; w<4;w++){
							int barcoP2[][] = new int[cont1][2];
							frota1 = jogador[p].getFrota();
							barcoP2 = frota1[w].getCoordenada();
							for (int g=0;g<cont1;g++){
								for(int z=0; z<2;z++){
									System.out.print("cord"+g+z+": "+barcoP2[g][z]);
									z++;
									System.out.println("	cord"+g+z+": "+barcoP2[g][z]);
								}
							}
							System.out.println("\n");
							cont1++;
						}
							
						
						cont1 =2;
						for(int w=0; w<4;w++){
							int barcoP2[][] = new int[cont1][2];
							frota2 = jogador[1].getFrota();
							barcoP2 = frota2[w].getCoordenada();
							for (int g=0;g<cont1;g++){
								for(int z=0; z<2;z++){
									System.out.print("cord"+g+z+": "+barcoP2[g][z]);
									z++;
									System.out.println("	cord"+g+z+": "+barcoP2[g][z]);
								}
							}
							System.out.println("\n");
							cont1++;
						}
						
						System.out.println("vamos jogar!");
						tamanho=2;		
						boolean uma = false;
						int contadorJogo = 14, contador = 0;
						int linhA = 0, colunA=0;
						
						//Desenha o Tabuleiro
						cj.desenharTabuleiro();
						
						int sabendoJogador=2;
						int qualJogador=0;
						
						while(contador<contadorJogo){
							
							System.out.println("Me deh seu palpite de linha:");
							linhA = in.nextInt();
							cj.validaCoordenada(linhA);//Exception
							
							System.out.println("Me deh seu palpite de coluna:");
							colunA = in.nextInt(); 
							cj.validaCoordenada(colunA);//Exception
							
							if(sabendoJogador%2 == 0)
								qualJogador = 2;
								//Acertou? ou Errou?ou afundou?
								uma = cj.acertoOuErro(frota2, linhA, colunA);
							if(sabendoJogador%2 == 1){
								qualJogador = 1;
								//Acertou? ou Errou?ou afundou?
								uma = cj.acertoOuErro(frota1, linhA, colunA);
							}
							if(uma == true){
								contador++;
							}
							System.out.println("qualjogador: "+qualJogador);
							//Redesenha Tabuleiro com acertos ou erros.
							cj.RedesenhaTabuleiro(uma, linhA, colunA, qualJogador);
							
							sabendoJogador++;
						}
						opc =3;  //finaliza o jogo
						break;
					case 2:
						cj.Instruções();
						int opc2;
						System.out.println("Mais um exemplo?\n 1-Sim\n 2-Nao");
						opc2 = in.nextInt();
						if(opc2 == 1){
							cj.Innstruções2();
						}
						break;
					case 3:
						break;
					default:
						System.out.println("Opção Inválida!");
							
				}
			}
			System.out.println("Fim");
		}
		catch(CoordenadaInvalidaException ex1){
			ex1.printStackTrace();
		}
		catch(DirecaoInvalidaException ex2){
			ex2.printStackTrace();
		}
	}
}

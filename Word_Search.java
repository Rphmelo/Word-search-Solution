package wordSearch;

import java.io.IOException;

public class Word_Search {

	public static void main(String[] args) {
		
		try {
			
			//Instanciando um objeto da classe Metodos.
			Methods cacapalavra = new Methods();
			
			//Imprimindo o tamanho da matriz e a quantidade de palavras
			//a serem procuradas.
			System.out.println
			("Tamanho: " + cacapalavra.getTamanho() + 
					"\nQtdePalavras: " + cacapalavra.getQtde_Palavras());
			
			//Imprimindo as palavras a serem procuradas.
			System.out.println("PALAVRAS:");
			for(String lst : cacapalavra.getPalavras()){
				System.out.println(lst);
			}
			
			//Imprimindo a matriz.
			System.out.println("\nMATRIZ:");
			System.out.println();
			for(int i = 0; i < cacapalavra.getMatriz().length; i++){
				for(int j = 0; j < cacapalavra.getMatriz()[0].length; j++){
					System.out.print("|" + cacapalavra.getMatriz()[i][j] + "|" + " ");
				}
				System.out.println();
			}
			
			/*Variáveis responsaveis por guardar a posicao, 
			o sentido e o nome da palavra encontrada na matriz.*/
			
			int[] vetor_linha = new int[cacapalavra.getQtde_Palavras()];
			int[] vetor_coluna = new int[cacapalavra.getQtde_Palavras()];
			String[] vetor_sentido = new String[cacapalavra.getQtde_Palavras()];
			String[] vetor_palavra = new String[cacapalavra.getQtde_Palavras()];
			
			//Procurando as palavras na matriz
			for(int contador_Palavra = 0;
					contador_Palavra < cacapalavra.getQtde_Palavras(); 
					contador_Palavra++) { //Laço que irá direcionar qual palavra será procurada
				for(int lin = 0; lin < cacapalavra.getMatriz().length; lin++) { //Laço que irá direcionar a linha a ser procurada
					for(int col = 0; col < cacapalavra.getMatriz().length; col++) {//Laço que irá direcionar a coluna a ser procurada
						//Caso a primeira letra da palavra procurada
						//seja igual ao valor da matriz[lin][col]
						if(cacapalavra.getMatriz()[lin][col] == 
							cacapalavra.getPalavras().get(contador_Palavra).charAt(0)){
							
							//Caso o metodo leste seja verdadeiro
							if(cacapalavra.leste(cacapalavra.getMatriz(), lin, col, cacapalavra.getPalavras().get(contador_Palavra))){
								vetor_linha[contador_Palavra] = lin;
								vetor_coluna[contador_Palavra] = col;
								vetor_sentido[contador_Palavra] = "Leste";
								vetor_palavra[contador_Palavra] = cacapalavra.getPalavras().get(contador_Palavra);
							}
							
							//Caso o metodo oeste seja verdadeiro
							else if(cacapalavra.oeste(cacapalavra.getMatriz(), lin, col, cacapalavra.getPalavras().get(contador_Palavra))){
								vetor_linha[contador_Palavra] = lin;
								vetor_coluna[contador_Palavra] = col;
								vetor_sentido[contador_Palavra] = "Oeste";
								vetor_palavra[contador_Palavra] = cacapalavra.getPalavras().get(contador_Palavra);
							}
							
							//Caso o metodo norte seja verdadeiro
							else if(cacapalavra.norte(cacapalavra.getMatriz(), lin, col, cacapalavra.getPalavras().get(contador_Palavra))){
								vetor_linha[contador_Palavra] = lin;
								vetor_coluna[contador_Palavra] = col;
								vetor_sentido[contador_Palavra] = "Norte";
								vetor_palavra[contador_Palavra] = cacapalavra.getPalavras().get(contador_Palavra);
							}
							
							//Caso o metodo sul seja verdadeiro
							else if(cacapalavra.sul(cacapalavra.getMatriz(), lin, col, cacapalavra.getPalavras().get(contador_Palavra))){
								vetor_linha[contador_Palavra] = lin;
								vetor_coluna[contador_Palavra] = col;
								vetor_sentido[contador_Palavra] = "Sul";
								vetor_palavra[contador_Palavra] = cacapalavra.getPalavras().get(contador_Palavra);
							}
							
							//Caso o metodo nordeste seja verdadeiro
							else if(cacapalavra.nordeste(cacapalavra.getMatriz(), lin, col, cacapalavra.getPalavras().get(contador_Palavra))){
								vetor_linha[contador_Palavra] = lin;
								vetor_coluna[contador_Palavra] = col;
								vetor_sentido[contador_Palavra] = "Nordeste";
								vetor_palavra[contador_Palavra] = cacapalavra.getPalavras().get(contador_Palavra);
							}
							
							//Caso o metodo sudeste seja verdadeiro
							else if(cacapalavra.sudeste(cacapalavra.getMatriz(), lin, col, cacapalavra.getPalavras().get(contador_Palavra))){
								vetor_linha[contador_Palavra] = lin;
								vetor_coluna[contador_Palavra] = col;
								vetor_sentido[contador_Palavra] = "Sudeste";
								vetor_palavra[contador_Palavra] = cacapalavra.getPalavras().get(contador_Palavra);
							}
							
							//Caso o metodo noroeste seja verdadeiro
							else if(cacapalavra.noroeste(cacapalavra.getMatriz(), lin, col, cacapalavra.getPalavras().get(contador_Palavra))){
								vetor_linha[contador_Palavra] = lin;
								vetor_coluna[contador_Palavra] = col;
								vetor_sentido[contador_Palavra] = "Noroeste";
								vetor_palavra[contador_Palavra] = cacapalavra.getPalavras().get(contador_Palavra);
							}
							
							//Caso o metodo sudoeste seja verdadeiro
							else if(cacapalavra.sudoeste(cacapalavra.getMatriz(), lin, col, cacapalavra.getPalavras().get(contador_Palavra))){
								vetor_linha[contador_Palavra] = lin;
								vetor_coluna[contador_Palavra] = col;
								vetor_sentido[contador_Palavra] = "Sudoeste";
								vetor_palavra[contador_Palavra] = cacapalavra.getPalavras().get(contador_Palavra);
							}
							
							//Caso a palavra não seja encontrada
							else{
								vetor_palavra[contador_Palavra] = cacapalavra.getPalavras().get(contador_Palavra);
							}
							
						}
					}
				}
			}
			
			//Teste
			for (int i = 0; i < cacapalavra.getQtde_Palavras(); i++) {
				if (vetor_sentido[i] == null) {
					System.out.println();
					System.out.println("Palavra ".concat(vetor_palavra[i].toUpperCase())
							.concat(" não encontrada!"));
				} else {
					System.out.println();
					System.out.println("Palavra: ".concat(vetor_palavra[i].toUpperCase()));
					System.out.println("Linha: " + vetor_linha[i]);
					System.out.println("Coluna: " + vetor_coluna[i]);
					System.out.println("Sentido: " + vetor_sentido[i]);
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}

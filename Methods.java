package wordSearch;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Methods {

	// Atributos da matriz
	private int tamanho;
	private char[][] matriz;
	private int qtde_Palavras;
	private List<String> palavras;

	// Método para ler o arquivo e preencher os valores dos atributos da matriz
	public Methods() throws IOException {
		
		//Lendo o arquivo .txt
		FileReader fr = new FileReader("cacapalavra.txt");
		BufferedReader br = new BufferedReader(fr);
		
		//Atribuindo o valor da primeira linha ao tamanho da matriz
		String linha = br.readLine();
		this.tamanho = Integer.parseInt(linha);

		//Preenchendo a matriz  nas n posições da matriz
		matriz = new char[tamanho][tamanho];
		for (int lin = 0; lin < tamanho; lin++) {
			linha = br.readLine();
			for (int col = 0; col < tamanho; col++) {
				matriz[lin][col] = linha.charAt(col);
			}
		}
		
		/* Atribuindo o valor da próxima linha à 
		quantidade de palavras a serem encontradas */
		linha = br.readLine();
		this.qtde_Palavras = Integer.parseInt(linha);
		
		// Atribuindo as proximas linhas à Lista de palavras
		palavras = new ArrayList<String>();
		int contador = 1;
		while(contador <= this.qtde_Palavras){
			linha = br.readLine();
			this.palavras.add(linha);
			contador++;
		}
		br.close();
	}

	// Métodos getters para retornar os valores dos atributos da matriz
	public int getTamanho() {
		return tamanho;
	}
	public char[][] getMatriz() {
		return matriz;
	}
	public int getQtde_Palavras() {
		return qtde_Palavras;
	}
	public List<String> getPalavras() {
		return palavras;
	}
	
	//Métodos de comparacao
	
	//Comparacao Leste
	public boolean leste(char[][] matriz, int pos_lin, int pos_col,
			String palavra) {
		String procurado = "";
		
		/* A Variável i será igual a variavel pos_col dada como parametro,
		 * e ela irá percorrer a matriz nesse sentido quantas vezes for
		 * o tamanho da palavra. Como ela já inicia com um valor, é necessário
		 * somar esse valor à palavra.length.*/
		for (int i = pos_col; i < palavra.length() + pos_col 
				&& i < matriz[0].length; i++) { /* &&... -> Condicao
		responsavel por nao deixar o metodo apontar para uma posicao fora
		da matriz */
			procurado = procurado + String.valueOf(matriz[pos_lin][i]);
		}
		//Comparando palavra dada como parâmetro com a palavra retirada da matriz
		if(palavra.equals(procurado)){ // Se forem iguais retorna True
			return true;
		} // Senao, retorna False
		return false;
	}
	
	//Comparacao Oeste
	public boolean oeste(char[][] matriz, int pos_lin, int pos_col,
			String palavra) {
		String procurado = "";
		
		/* A variavel i será igual a variavel pos_col dada como parâmetro,
		 * e ela irá percorrer a matriz nesse sentido quantas vezes for o
		 * tamanho da palavra. Como ela já inicia com um valor, é necessário
		 * subtrair esse valor à palavra.length*/
		
		for (int i = pos_col; i > pos_col - palavra.length()
				&& i >= 0; i--) { /* &&... -> Condicao
			responsavel por nao deixar o metodo apontar para uma posicao fora
			da matriz */
			procurado = procurado + String.valueOf(matriz[pos_lin][i]);
		}
		//Comparando palavra dada como parâmetro com a palavra retirada da matriz
		if (palavra.equals(procurado)) {
			return true;
		}
		return false;
	}
	
	//Comparacao Sul
	public boolean sul(char[][] matriz, int pos_lin, int pos_col,
			String palavra) {
		String procurado = "";
		
		/* A Variável i será igual a variavel pos_lin dada como parametro,
		 * e ela irá percorrer a matriz nesse sentido quantas vezes for
		 * o tamanho da palavra. Como ela já inicia com um valor, é necessário
		 * somar esse valor à palavra.length.*/
		for (int i = pos_lin; i < palavra.length() + pos_lin 
				&& i < matriz.length; i++) { /* &&... -> Condicao
		responsavel por nao deixar o metodo apontar para uma posicao fora
		da matriz */
			procurado = procurado + String.valueOf(matriz[i][pos_col]);
		}
		//Comparando palavra dada como parâmetro com a palavra retirada da matriz
		if(palavra.equals(procurado)){ // Se forem iguais retorna True
			return true;
		} // Senao, retorna False
		return false;
	}
	
	//Comparacao Norte
		public boolean norte(char[][] matriz, int pos_lin, int pos_col,
				String palavra) {
			String procurado = "";
			
			/* A variavel i será igual a variavel pos_lin dada como parâmetro,
			 * e ela irá percorrer a matriz nesse sentido quantas vezes for o
			 * tamanho da palavra. Como ela já inicia com um valor, é necessário
			 * subtrair esse valor à palavra.length*/
			for (int i = pos_lin; i > pos_lin - palavra.length()
					&& i >= 0; i--) { /* &&... -> Condicao
				responsavel por nao deixar o metodo apontar para uma posicao fora
				da matriz */
				procurado = procurado + String.valueOf(matriz[i][pos_col]);
			}
			//Comparando palavra dada como parâmetro com a palavra retirada da matriz
			if (palavra.equals(procurado)) {
				return true;
			}
			return false;
		}
		
	//Comparacao Sudeste
		public boolean sudeste(char[][] matriz, int pos_lin, int pos_col,
				String palavra) {
			String procurado = "";
			
			/* A Variável i será igual a variavel pos_lin dada como parametro,
			 * e ela irá percorrer a matriz nesse sentido quantas vezes for
			 * o tamanho da palavra. Como ela já inicia com um valor, é necessário
			 * somar esse valor à palavra.length.*/
			for (int i = pos_lin; i < palavra.length() + pos_lin 
					&& i < matriz.length && pos_col < matriz.length; i++) { /* &&... -> Condicao
			responsavel por nao deixar o metodo apontar para uma posicao fora
			da matriz */
				procurado = procurado + String.valueOf(matriz[i][pos_col]);
				pos_col++;
			}
			//Comparando palavra dada como parâmetro com a palavra retirada da matriz
			if(palavra.equals(procurado)){ // Se forem iguais retorna True
				return true;
			} // Senao, retorna False
			return false;
		}
		
		//Comparacao Nordeste
		public boolean nordeste(char[][] matriz, int pos_lin, int pos_col,
				String palavra) {
			String procurado = "";
			
			/* A variavel i será igual a variavel pos_lin dada como parâmetro,
			 * e ela irá percorrer a matriz nesse sentido quantas vezes for o
			 * tamanho da palavra. Como ela já inicia com um valor, é necessário
			 * subtrair esse valor à palavra.length*/
			for (int i = pos_lin; i > pos_lin - palavra.length()
					&& i >= 0 && pos_col < matriz.length; i--) { /* &&... -> Condicao
				responsavel por nao deixar o metodo apontar para uma posicao fora
				da matriz */
				procurado = procurado + String.valueOf(matriz[i][pos_col]);
				pos_col++;
			}
			//Comparando palavra dada como parâmetro com a palavra retirada da matriz
			if (palavra.equals(procurado)) {
				return true;
			}
			return false;
		}
		
		//Comparacao Noroeste
		public boolean noroeste(char[][] matriz, int pos_lin, int pos_col,
				String palavra) {
			String procurado = "";
			
			/* A variavel i será igual a variavel pos_col dada como parâmetro,
			 * e ela irá percorrer a matriz nesse sentido quantas vezes for o
			 * tamanho da palavra. Como ela já inicia com um valor, é necessário
			 * subtrair esse valor à palavra.length*/
			for (int i = pos_col; i > pos_col - palavra.length()
					&& i >= 0 && pos_lin >= 0; i--) { /* &&... -> Condicao
				responsavel por nao deixar o metodo apontar para uma posicao fora
				da matriz */
				procurado = procurado + String.valueOf(matriz[pos_lin][i]);
				pos_lin--;
			}
			//Comparando palavra dada como parâmetro com a palavra retirada da matriz
			if (palavra.equals(procurado)) {
				return true;
			}
			return false;
		}
		
		//Comparacao Sudoeste
		public boolean sudoeste(char[][] matriz, int pos_lin, int pos_col,
				String palavra) {
			String procurado = "";
			
			/* A Variável i será igual a variavel pos_lin dada como parametro,
			 * e ela irá percorrer a matriz nesse sentido quantas vezes for
			 * o tamanho da palavra. Como ela já inicia com um valor, é necessário
			 * somar esse valor à palavra.length.*/
			for (int i = pos_lin; i < palavra.length() + pos_lin 
					&& i < matriz.length && pos_col >= 0; i++) { /* &&... -> Condicao
			responsavel por nao deixar o metodo apontar para uma posicao fora
			da matriz */
				procurado = procurado + String.valueOf(matriz[i][pos_col]);
				pos_col--;
			}
			//Comparando palavra dada como parâmetro com a palavra retirada da matriz
			if(palavra.equals(procurado)){ // Se forem iguais retorna True
				return true;
			} // Senao, retorna False
			return false;
		}
}

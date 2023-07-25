/*
 * Copyright (C) 2023 Thiago Magalhães <https://github.com/thiagomagh>
 *  
 * This code is licensed under the GNU GPL v2.0 or any later version.
 * For details, see the COPYING file at the root of this distribution
 * or at <https://www.gnu.org/licenses/old-licenses/gpl-2.0.txt>.
 */

package com.github.thiagomagh.batalhanaval.model;

// Uncomment the following line if you wish to use @NonNull annotation.
// import org.eclipse.jdt.annotation.NonNull;

import com.github.thiagomagh.batalhanaval.factory.FactoryNavio;

import java.util.Locale;
import java.util.Random;
import java.util.Scanner;

public class Tabuleiro {
	private final int TAMANHO;
	private Quadrado[][] matrizQuadrados;
	private int coordLinha;
	private int coordColuna;
	private FactoryNavio fabricaNavio;
	private Navio[] vetorNavios;
	private int indiceVetorNavios;
	
	public Tabuleiro() {
		TAMANHO = 10;
		matrizQuadrados = new Quadrado[TAMANHO][TAMANHO];
		fabricaNavio = new FactoryNavio();
		vetorNavios = fabricaNavio.criarNavio();
	}
	
	public int getTAMANHO() {
		return TAMANHO;
	}

	public Quadrado[][] getMatrizQuadrados() {
		return matrizQuadrados;
	}

	public void setMatrizQuadrados(Quadrado[][] matrizQuadrados) {
		this.matrizQuadrados = matrizQuadrados;
	}

	public int getCoordLinha() {
		return coordLinha;
	}

	public void setCoordLinha(int coordLinha) {
		this.coordLinha = coordLinha;
	}

	public int getCoordColuna() {
		return coordColuna;
	}

	public void setCoordColuna(int coordColuna) {
		this.coordColuna = coordColuna;
	}
	
	public Navio[] getVetorNavios() {
		return vetorNavios;
	}

	public void setVetorNavios(Navio[] vetorNavios) {
		this.vetorNavios = vetorNavios;
	}

	public void configurarTabuleiro() {
		System.out.println("O tabuleiro está sendo iniciado. Aguarde um instante.");
		
		for (int i = 0; i < TAMANHO; i++) {
			for (int j = 0; j < TAMANHO; j++) {
				Quadrado quadrado = new Quadrado();
				quadrado.setSimbolo('.');
				matrizQuadrados[i][j] = quadrado;
			}
		}
	}
	
	public void configurarNavios() {
		Random rand = new Random();
		
		for (indiceVetorNavios = 0; indiceVetorNavios < vetorNavios.length; indiceVetorNavios++) {
			for (int quantNavios = 0; quantNavios < vetorNavios[indiceVetorNavios].getQuantMaxima();) {
				int posI = rand.nextInt(TAMANHO);
				int posJ = rand.nextInt(TAMANHO);
				
				if (inserirNavio(posI, posJ)) {
					quantNavios++;
				}
			}
		}
	}
	
	public boolean inserirNavio(int i, int j) {
		if (i + vetorNavios[indiceVetorNavios].getTamanho() <= TAMANHO) {
			if (!verificarNavioColuna(i, j)) {
				posicionarNavio(i, j, false);
				return true;
			}
		} else if (j + vetorNavios[indiceVetorNavios].getTamanho() <= TAMANHO) {
			if (!verificarNavioLinha(i, j)) {
				posicionarNavio(j, i, true);
				return true;
			}
		}
		
		return false;
	}
	
	public boolean verificarNavioColuna(int i, int j) {
		return contarPartesNavioColuna(i, j, '#') != 0;
	}
	
	public int contarPartesNavioColuna(int i, int j, char simbolo) {
		int contarPartesNavio = 0;
		
		for (int k = i; k < (i + vetorNavios[indiceVetorNavios].getTamanho()); k++) {
			if (matrizQuadrados[k][j].getSimbolo() == simbolo) {
				contarPartesNavio++;
			}
		}
		
		return contarPartesNavio;
	}
	
	
	public boolean verificarNavioLinha(int i, int j) {
		return contarPartesNavioLinha(i, j, '#') != 0;
	}
	
	public int contarPartesNavioLinha(int i, int j, char simbolo) {
		int contarPartesNavio = 0;
		
		for (int k = j; k < (j + vetorNavios[indiceVetorNavios].getTamanho()); k++) {
			if (matrizQuadrados[i][k].getSimbolo() == simbolo) {
				contarPartesNavio++;
			}
		}
		
		return contarPartesNavio;
	}
	
	public void posicionarNavio(int i, int j, boolean isLinha) {
		for (int k = i; k < (i + vetorNavios[indiceVetorNavios].getTamanho()); k++) {
			if (isLinha) {
				matrizQuadrados[j][k].setSimbolo('#');
			} else {
				matrizQuadrados[k][j].setSimbolo('#');
			}
		}
	}
	
	public void imprimirTabuleiro() {
		char[] vetorSimbolos = new char[TAMANHO];
			
		for (int i = 0; i < TAMANHO; i++) {
			System.out.print((char)(i + 65) + " |");
			
			for (int j = 0; j < TAMANHO; j++) {
				vetorSimbolos[j] = matrizQuadrados[i][j].getSimbolo();
			}
			
			imprimirLinha(vetorSimbolos);
		}
		
		imprimirLinhaInferior();
	}
	
	// Uncomment the following line if you wish to use @NonNull annotation.
	public void imprimirLinha(char /* @NonNull */ [] tab) {
		for (int i = 0; i < tab.length; i++) {
			if (tab[i] == '#') {
				System.out.print(". ");
			} else {
				System.out.print(tab[i] + " ");
			}
		}
		
		System.out.println();
	}
	
	public void imprimirLinhaInferior() {
		System.out.print("---------------------------\n  |");
		
		for (int i = 0; i < TAMANHO; i++) {
			System.out.print((i + 1) + " ");
		}
		
		System.out.println("\n");
	}
	
	public void lerCoordenadas() {	
		Scanner scanner = new Scanner(System.in);
		
		do {
			System.out.println("Digite as coordenadas da sua jogada separadas " +
					"por espaço: (Ex: A 2)");
			coordLinha = scanner.next().toUpperCase(Locale.ROOT).charAt(0) - 65;
			coordColuna = scanner.nextInt();
			coordColuna = coordColuna - 1;
		} while (validarJogada());
	}
	
	public boolean validarJogada() {
		if (coordLinha < 0 || coordLinha >= TAMANHO || coordColuna < 0 || coordColuna >= TAMANHO) {
			System.out.println("Coordenas inválidas!");
			return true;
		}
		
		if (matrizQuadrados[coordLinha][coordColuna].getSimbolo() == '~' || matrizQuadrados[coordLinha][coordColuna].getSimbolo() == 'x') {
			System.out.println("Você já escolheu essa casa em outra jogada. Não é possível" +
					" jogar duas bombas no mesmo lugar.");
			return true;
		}
		
		return false;
	}
	
	public void jogarBomba() {
		System.out.println("Lançando bomba...");
		if (matrizQuadrados[coordLinha][coordColuna].getSimbolo() == '.') {
			matrizQuadrados[coordLinha][coordColuna].setSimbolo('~');
		} else {
			matrizQuadrados[coordLinha][coordColuna].setSimbolo('x');
		}
		
		imprimirTabuleiro();
	}
}

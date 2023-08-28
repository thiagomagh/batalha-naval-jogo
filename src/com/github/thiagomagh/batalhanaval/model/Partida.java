/*
 * Copyright (C) 2023 Thiago Magalhães <https://github.com/thiagomagh>
 *  
 * This code is licensed under the GNU GPL v2.0 or any later version.
 * For details, see the COPYING file in the root of this project
 * or at <https://www.gnu.org/licenses/old-licenses/gpl-2.0.txt>.
 */

package com.github.thiagomagh.batalhanaval.model;

import java.util.Scanner;

public class Partida {
	private short podeIniciar;
	private int rodada;
	private int partesNaviosAfundados;
	private Tabuleiro tabuleiro;

	public Partida() {
		rodada = 0;
		partesNaviosAfundados = 0;
	}
	
	public short getPodeIniciar() {
		return podeIniciar;
	}

	public void setPodeIniciar(short podeIniciar) {
		this.podeIniciar = podeIniciar;
	}

	public int getRodada() {
		return rodada;
	}

	public void setRodada(int rodada) {
		this.rodada = rodada;
	}

	public int getPartesNaviosAfundados() {
		return partesNaviosAfundados;
	}

	public void setPartesNaviosAfundados(int partesNaviosAfundados) {
		this.partesNaviosAfundados = partesNaviosAfundados;
	}
	
	public Tabuleiro getTabuleiro() {
		return tabuleiro;
	}

	public void setTabuleiro(Tabuleiro tabuleiro) {
		this.tabuleiro = tabuleiro;
	}

	public void jogarNovaPartida() {
		Scanner scanner = new Scanner(System.in);
		tabuleiro = new Tabuleiro();
		
		do {
			tabuleiro.configurarTabuleiro();
			tabuleiro.configurarNavios();
			tabuleiro.imprimirTabuleiro();
			iniciarPartida();
			System.out.println("Jogar nova partida? [1 para sim, outro número para sair!]");
			podeIniciar = scanner.nextShort();
		} while (podeIniciar == 1);
		
		System.out.println("Jogo finalizado!");
	}
	
	public void iniciarPartida() {
		Quadrado[][] matrizQuadrados = tabuleiro.getMatrizQuadrados();
		Navio[] vetorNavios = tabuleiro.getVetorNavios();
		int totalNavios = 0;
		int totalPartesNavios = 0;
		int coordLinha;
		int coordColuna;
		
		for (int indice = 0; indice < vetorNavios.length; indice++) {
			totalPartesNavios = totalPartesNavios + vetorNavios[indice].getQuantMaxima() * vetorNavios[indice].getTamanho();
			totalNavios = totalNavios + vetorNavios[indice].getQuantMaxima();
		}
					
		do {
			tabuleiro.lerCoordenadas();
			System.out.println("------------------------------------------------" + 
					"-----------------");
			System.out.printf("Tentativa: %d\n-------------------\n", ++rodada);
			tabuleiro.jogarBomba();
			
			coordLinha = tabuleiro.getCoordLinha();
			coordColuna = tabuleiro.getCoordColuna();
			
			if (matrizQuadrados[coordLinha][coordColuna].getSimbolo() == 'x') {
				partesNaviosAfundados++;
			}
			
			System.out.println("Total de navios: " + totalNavios);
			System.out.println("Total de quadrados ocupados por navios: " + totalPartesNavios);
			System.out.println("Quantidade de partes atingidas: " + partesNaviosAfundados + "\n");
		} while (partesNaviosAfundados < totalPartesNavios);
		
		System.out.printf("Parabéns! Você afundou todos os navios!" +
				"\nTentativas utilizadas: %d \n", rodada);
	}
}

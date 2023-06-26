/*
 * Copyright (C) 2023 by Thiago Magalhães <https://github.com/thiagomagh>
 * 
 * This program is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation; either version 2 of the License, or
 * (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License along
 * with this program; if not, write to the Free Software Foundation, Inc.,
 * 51 Franklin Street, Fifth Floor, Boston, MA 02110-1301 USA.
 *
 * Original source code: https://github.com/thiagomagh/batalha-naval-jogo
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

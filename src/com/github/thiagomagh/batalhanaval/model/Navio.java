/*
 * Copyright (C) 2023 Thiago Magalhães <https://github.com/thiagomagh>
 *  
 * This code is licensed under the GNU GPL v2.0 or any later version.
 * For details, see the COPYING file at the root of this distribution
 * or at <https://www.gnu.org/licenses/old-licenses/gpl-2.0.txt>.
 */

package com.github.thiagomagh.batalhanaval.model;

public class Navio {
	protected String categoria;
	protected int tamanho;
	protected int quantMaxima;
	
	public Navio() {
		categoria = "Navio";
		tamanho = 4;
		quantMaxima = 4;
	}

	public String getCategoria() {
		return categoria;
	}

	public int getTamanho() {
		return tamanho;
	}

	public int getQuantMaxima() {
		return quantMaxima;
	}	
}

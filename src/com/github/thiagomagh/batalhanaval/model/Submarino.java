/*
 * Copyright (C) 2023 by Thiago Magalhães <https://github.com/thiagomagh>
 *  
 * This program is licensed under the GNU GPL v2.0 or any later version.
 * 
 * For more details, see COPYING file or 
 * <https://www.gnu.org/licenses/old-licenses/gpl-2.0.txt>.
 */

package com.github.thiagomagh.batalhanaval.model;

public class Submarino extends Navio {
	public Submarino() {
		categoria = "Submarino";
		tamanho = 3;
		quantMaxima = 5;
	}
}

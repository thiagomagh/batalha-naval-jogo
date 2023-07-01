/*
 * Copyright (C) 2023 by Thiago Magalhães <https://github.com/thiagomagh>
 *  
 * This program is licensed under the GNU GPL v2.0 or any later version.
 * 
 * For more details, see COPYING file or 
 * <https://www.gnu.org/licenses/old-licenses/gpl-2.0.txt>
 */

package com.github.thiagomagh.batalhanaval.factory;

import com.github.thiagomagh.batalhanaval.model.Navio;
import com.github.thiagomagh.batalhanaval.model.Submarino;

public class FactoryNavio {
	public Navio[] criarNavio() {
		Navio[] vetorNavios = new Navio[2];
		
		for (int indice = 0; indice < vetorNavios.length; indice++) {
			if (indice == 0) {
				vetorNavios[indice] = new Navio();
			} else if (indice == 1) {
				vetorNavios[indice] = new Submarino();
			}
		}
		
		return vetorNavios;
	}
}

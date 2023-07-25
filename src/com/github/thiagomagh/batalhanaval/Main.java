/*
 * Copyright (C) 2023 Thiago Magalhães <https://github.com/thiagomagh>
 *  
 * This code is licensed under the GNU GPL v2.0 or any later version.
 * For details, see the COPYING file at the root of this distribution
 * or at <https://www.gnu.org/licenses/old-licenses/gpl-2.0.txt>.
 */

package com.github.thiagomagh.batalhanaval;

import com.github.thiagomagh.batalhanaval.model.Partida;

public class Main {

	public static void main(String[] args) {
		Partida partida = new Partida();
		partida.jogarNovaPartida();
	}

}

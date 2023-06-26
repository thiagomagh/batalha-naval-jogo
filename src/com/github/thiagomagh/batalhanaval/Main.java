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

package com.github.thiagomagh.batalhanaval;

import com.github.thiagomagh.batalhanaval.model.Partida;

public class Main {

	public static void main(String[] args) {
		Partida partida = new Partida();
		partida.jogarNovaPartida();
	}

}

/*
 * Copyright (C) 2018 tama
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License
 * as published by the Free Software Foundation; either version 2
 * of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place - Suite 330, Boston, MA  02111-1307, USA.
 */

package forrogue.map;

import charva.awt.Dimension;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Vector;

/**
 *
 * @author tama
 */
class Dungeon {
    
    private Dimension dimension;
    private char[][] matrix;

    public Dungeon(String pathname){
        Scanner f = new Scanner(pathname);

    }

    private void setMatrix(Scanner f){
        ArrayList<String> lines = new ArrayList();
        int max = 0, i = 0, j;
        while(f.hasNextLine()) {
            lines.add(f.nextLine());
            if (lines.get(i).length() > max) max = lines.get(i).length();
            i++;
        }

        this.dimension = new Dimension(max, lines.size());
        this.matrix = new char[lines.size()][max];

        i = j = 0;
        for(String str : lines){
            for(char c : str.toCharArray()){
                this.matrix[i][j] = c;
                j++;
            } i++; j = 0;
        }
    }

    public Dimension getDimension(){
        return this.dimension;
    }

    public char[][] getMatrix(){
        return this.matrix;
    }
}

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

import charva.awt.Point;
import forrogue.game.GameConstant;

/**
 *
 * @author tama
 */

public class Map {

    private char[][] matrix;
    private long seed;
    
    public Map(long seed, char[][] matrix){
        this.seed = seed;
        this.matrix = matrix;
    }

    public char[][] getMatrix(){
        return this.matrix;
    }

    public boolean movePlayer(Point move, Point coord_player) {
        if(this.matrix[coord_player.y+move.y][coord_player.x+move.x] == GameConstant.SKIN_VOID){
            this.matrix[coord_player.y][coord_player.x] = GameConstant.SKIN_VOID;
            this.matrix[coord_player.y+move.y][coord_player.x+move.x] = GameConstant.SKIN_PLAYER;
            return true;
        }

        else return false;
    }

    public Point getPlayerPosition() {
        int x = 0, y = 0;
        for(char[] line : this.matrix){
            for(char c : line){
                if(c == GameConstant.SKIN_PLAYER){
                    return new Point(x, y);
                }
                x++;
            } y++; x = 0;
        } return new Point(-1,-1);
    }

    public void setMatrix(char[][] matrix){
        this.matrix = matrix;
    }

}

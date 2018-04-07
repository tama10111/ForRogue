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
import forrogue.GameObject;
import forrogue.character.Player;
import forrogue.game.GameConstant;
import forrogue.game.GameEngine;

import java.util.Random;

/**
 *
 * @author tama
 */

public class Map {

    private Object[][] matrix;
    private GameEngine gEngine;

    public Map(GameEngine gEngine){
        this.gEngine = gEngine;
        this.matrix = gEngine.getHub().getMatrix();
    }

    public Object[][] getMatrix(){
        return this.matrix;
    }

    public void movePlayer(Point move) {

        Point coord_player = this.gEngine.getPlayer().getPosition();

        Object target = this.matrix[coord_player.y+move.y][coord_player.x+move.x];

        if(!(target instanceof GameObject)){
            if((char) target == GameConstant.SKIN_VOID) {
                this.matrix[coord_player.y][coord_player.x] = GameConstant.SKIN_VOID;
                this.matrix[coord_player.y + move.y][coord_player.x + move.x] = GameConstant.SKIN_PLAYER;
                this.gEngine.getPlayer().getPosition().x += move.x;
                this.gEngine.getPlayer().getPosition().y += move.y;
            }
        }

        else if(target instanceof Dungeon){
            this.matrix[coord_player.y][coord_player.x] = GameConstant.DUNGEON_PLAYER_POS;
            this.matrix[coord_player.y + move.y][coord_player.x + move.x] = new Dungeon(((Dungeon) target).getDifficulty(), gEngine.getHub(), gEngine.getRandom());
            this.setMatrix(((Dungeon) target).getMatrix());
            this.setPlayerPosition();
        }

        else if(target instanceof  Hub){
            this.setMatrix(((Hub) target).getMatrix());
            this.setPlayerPosition();
        }
    }

    public Point getPlayerPosition() {
        int x = 0, y = 0;
        for(Object[] line : this.matrix){
            for(Object o : line){
                if(o.getClass() == Player.class){
                    return new Point(x, y);
                } x++;
            } y++; x = 0;
        } return new Point(-1,-1);
    }

    public void setPlayerPosition(){
        int x = 0, y = 0;
        for(Object[] line : this.matrix){
            for(Object o : line){
                if(o != null) { // TODO : Vérifier pourquoi ça fait null
                    if (!(o instanceof GameObject)) {
                        if (((char) o) == GameConstant.DUNGEON_PLAYER_POS) {
                            this.gEngine.getPlayer().setPosition(new Point(x, y));
                            this.matrix[y][x] = this.gEngine.getPlayer();
                        }
                    }
                    x++;
                }
            } y++; x = 0;
        }
    }

    public void setMatrix(Object[][] matrix){
        this.matrix = matrix;
    }

}

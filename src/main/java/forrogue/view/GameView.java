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

package forrogue.view;

import charva.awt.Component;
import charva.awt.Dimension;
import charva.awt.Point;
import charva.awt.Toolkit;

import forrogue.GameObject;
import forrogue.character.Player;
import forrogue.game.GameEngine;

/**
 *
 * @author tama
 */

public class GameView extends Component{

    private Dimension dimension;
    private Toolkit term;
    private GameEngine gEngine;

    public GameView(Dimension dimension, Point origin, GameEngine gEngine) {
        this.dimension = dimension;
        this.gEngine = gEngine;
        this._origin = origin;
        this.term = Toolkit.getDefaultToolkit();
        this._visible = true;
        this.term.drawBox(_origin, dimension);
    }


    @Override
    public boolean isFocusTraversable(){
        return false;
    }

    @Override
    public void draw() {

        Point mem_p = this.term.getCursor();
        int max = 0;
        Object[][] matrix = this.gEngine.getMap().getMatrix();

        for (Object[] aMatrix : matrix) if (aMatrix.length > max) max = aMatrix.length;

        int cx = (this.dimension.width-max)/2;
        int cy = (this.dimension.height-matrix.length)/2;

        for(int y = 0; y < matrix.length; y++){
            for(int x = 0; x < matrix[y].length; x++){
                this.term.setCursor(x+cx, y+cy);
                if(matrix[y][x] != null) { // TODO : Vérifier pourquoi ça fait null
                    if (matrix[y][x] instanceof GameObject) {
                        this.term.addChar(((GameObject) matrix[y][x]).getSkin(), 0, 0);
                    } else {
                        this.term.addChar(((char) matrix[y][x]), 0, 0);
                    }
                }
            }
        }

        Player player = this.gEngine.getPlayer();

        String stat = String.format("HP : %s / ATK : %s / DEF : %s / SPD : %s",
                player.getHp(),
                player.getAttack(),
                player.getDefense(),
                player.getSpeed()
        );

        String equip = String.format("Weapon : [%c] %s / Protection : [%c] %s",
                player.getWeapon().getSkin(),
                player.getWeapon().getName(),
                player.getProtection().getSkin(),
                player.getProtection().getName()
        );

        String name = String.format("[%s - %s] %s",
                player.getSkin(),
                player.getGender().charAt(0),
                player.getName()
        );

        this.term.setCursor(this._origin.x + 2, this._origin.y + this.dimension.height - 4);
        this.term.addString(name, 0, 0);

        this.term.setCursor(this._origin.x + 2, this._origin.y + this.dimension.height - 3);
        this.term.addString(stat, 0, 0);

        this.term.setCursor(this._origin.x + 2, this._origin.y + this.dimension.height - 2);
        this.term.addString(equip, 0, 0);

        this.term.setCursor(mem_p);
        this.term.redrawWin();
        this.term.sync();
    }

    @Override
    public Dimension getSize() {
        return this.dimension;
    }

    @Override
    public int getWidth() {
        return this.dimension.width;
    }

    @Override
    public int getHeight() {
        return this.dimension.height;
    }

    @Override
    public Dimension minimumSize() {
        return this.dimension;
    }

    @Override
    public void debug(int i) {
    }

    public void refreshMap() {
        this.draw();
    }

    public void clearMap(){
        Point mem_p = this.term.getCursor();
        Object[][] matrix = this.gEngine.getMap().getMatrix();
        int width = 0;
        for(Object[] line : matrix){
            if(line.length > width) width = line.length;
        }
        int height = matrix.length;

        for(int y = 0; y<height; y++){
            for(int x = 0; x<width; x++){
                this.term.setCursor(x,y);
                this.term.addChar(' ', 0, 0);
            }
        }

        this.term.setCursor(mem_p);
        this.term.redrawWin();
        this.term.sync();
    }

    public void addChar(int x, int y, char c){
        Point mem_p = this.term.getCursor();
        this.term.setCursor(x, y);
        this.term.addChar(c,0,0);
        this.term.setCursor(mem_p);
    }
}

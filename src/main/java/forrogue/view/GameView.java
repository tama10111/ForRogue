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
import forrogue.map.Map;

/**
 *
 * @author tama
 */

public class GameView extends Component{

    private Dimension dimension;
    private Toolkit term;
    private Map map;

    public GameView(Dimension dimension, Point origin, Map map) {
        this.dimension = dimension;
        this.map = map;
        this._origin = origin;
        this.term = Toolkit.getDefaultToolkit();
        this._visible = true;
    }


    @Override
    public boolean isFocusTraversable(){
        return false;
    }

    @Override
    public void draw() {

        Point mem_p = this.term.getCursor();
        this.term.drawBox(_origin, dimension);
        int max = 0;
        char[][] matrix = this.map.getMatrix();

        for (char[] aMatrix : matrix) if (aMatrix.length > max) max = aMatrix.length;

        int cx = (this.dimension.width-max)/2;
        int cy = (this.dimension.height-matrix.length)/2;

        for(int y = 0; y < matrix.length; y++){
            for(int x = 0; x < matrix[y].length; x++){
                this.term.setCursor(x+cx, y+cy);
                this.term.addChar(matrix[y][x], 0, 0);
            }
        }

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
}

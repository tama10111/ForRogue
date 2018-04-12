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
package forrogue;

import charva.awt.Component;
import charva.awt.Dimension;
import charva.awt.Point;
import charva.awt.Toolkit;
import forrogue.game.GameConstant;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author tama
 */
public class Home extends Component {
    
    Dimension dimension;
    Toolkit term;
    char[][] matrix;
    int maxlen;

    public Home() {
        this._origin = new Point(0,0);
        this.term = Toolkit.getDefaultToolkit();
        this._visible = true;
        this.dimension = this.term.getScreenSize();
        this.term.drawBox(_origin, dimension);
        InputStream stream = this.getClass().getClassLoader().getResourceAsStream("home");
        Scanner f = new Scanner(stream);

        ArrayList<String> lines = new ArrayList();
        int max = 0, i = 0, j;
        while(f.hasNextLine()){
            lines.add(f.nextLine());
            if(lines.get(i).length() > max) max = lines.get(i).length();
            i++;
        }

        this.maxlen = max;

        this.matrix = new char[lines.size()][max];

        for(i = 0; i< lines.size(); i++){
            for(j = 0; j<max; j++){
                if(j < lines.get(i).length()){
                    this.matrix[i][j] = lines.get(i).charAt(j);
                } else{
                    this.matrix[i][j] = '\00';
                }
            }
        }
    }

    @Override
    public void draw() {
        int cx = 7;
        int cy = (this.dimension.height-matrix.length)/2;

        for(int y = 0; y < matrix.length; y++) {
            for (int x = 0; x < matrix[y].length; x++) {
                this.term.setCursor(x + cx, y + cy);
                this.term.addChar(matrix[y][x], 0, 0);
            }
        }
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

}

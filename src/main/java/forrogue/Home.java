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

import charva.awt.Toolkit;
import forrogue.game.GameConstant;

/**
 *
 * @author tama
 */
public class Home {
    
    public Home(){
        Toolkit term = Toolkit.getDefaultToolkit();
        int x = 0; int y = 0;
        for(int i = 0; i<GameConstant.home.length(); i++){
            if(GameConstant.home.charAt(i) == '\n'){
                x = 0; y++;
            } else{
                term.addChar(GameConstant.home.charAt(i),0,0);
                y++;
            }
        }       
    }
    
}

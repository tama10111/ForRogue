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

import charva.awt.BorderLayout;
import charvax.swing.JLabel;
import charvax.swing.JPanel;
import forrogue.character.Character;

/**
 *
 * @author tama
 */
class StatView extends JPanel{

    public StatView(Character player) {
        this.setLayout(new BorderLayout());
        this.add(new JLabel("Name : "+player.getName()+"\n"));
        this.add(new JLabel("Gender : "+player.getGender()+"\n"));
        this.add(new JLabel("Class : "+player.getType()+"\n"));
    }
    
}

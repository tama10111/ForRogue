/* class MainWindow
 *
 * Copyright (C) 2003  R M Pitman
 *
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 2.1 of the License, or (at your option) any later version.
 *
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA  02111-1307  USA
 */

/**
 *
 * @author tama
 */

package forrogue.game;

import charva.awt.BorderLayout;
import charva.awt.Container;
import charva.awt.Dimension;
import charva.awt.Point;
import charvax.swing.JFrame;
import charvax.swing.JPanel;
import charvax.swing.border.TitledBorder;
import forrogue.view.CommandPrompt;
import forrogue.view.GameView;
import forrogue.view.InventoryView;


public class GameWindow extends JFrame{
            
    private final InventoryView iView;
    private final CommandPrompt cmd;
    private final GameEngine gEngine;
    private final GameView gView;
    
    public GameWindow(String title, GameEngine gEngine){

        super(title+" -- TAB to switch between panels");
        
        Container mCont = this.getContentPane();
        
        this.gEngine = gEngine;
        
        JPanel iPanel = new JPanel();
        iPanel.setBorder(new TitledBorder("Inventory"));
        this.iView = new InventoryView(gEngine.getPlayer().getInventory(), this._term.getScreenRows()-2);  
        this.iView.setHeight(this._term.getScreenRows()-2);
        iPanel.add(this.iView);
        
        JPanel cPanel = new JPanel();
        cPanel.setBorder(new TitledBorder("Command -- ENTER to execute"));
        this.cmd = new CommandPrompt(this, "", this._term.getScreenColumns()-4);
        cPanel.add(this.cmd);
        
        Dimension dimension = new Dimension();
        dimension.height = this._term.getScreenRows()-7;
        dimension.width = this._term.getScreenColumns()-this.iView.getWidth()-3;
        this.gView = new GameView(dimension, new Point(3,3), gEngine.getMap());
        
        mCont.add(gView);
        mCont.add(iPanel, BorderLayout.EAST);
        mCont.add(cPanel, BorderLayout.SOUTH);

        this.pack();
        this.setVisible(true);        
        validate();
        this.gView.draw();

    }

    public void sendMovePlayerSignal(Point move){
        this.gEngine.movePlayer(move);
    }

    public void refreshMap() {
        this.gView.refreshMap();
    }
}

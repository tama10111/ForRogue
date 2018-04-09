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

import charva.awt.*;

import charvax.swing.JFrame;
import charvax.swing.JPanel;
import charvax.swing.border.TitledBorder;

import forrogue.character.Player;
import forrogue.item.protection.IronShield;
import forrogue.item.weapon.Sword;
import forrogue.view.*;

import java.io.Serializable;


public class GameWindow extends JFrame implements Serializable {

    private final InventoryView iView;
    private final CommandPrompt cmd;
    private final GameEngine gEngine;
    private final GameView gView;

    public GameWindow(String title, Player player, long seed){

        super(title+" -- TAB to switch between panels");
        Container mCont = this.getContentPane();

        this.gEngine = new GameEngine(player, seed, "filename.save");
        this.gEngine.setGameWindow(this);

        JPanel iPanel = new JPanel();
        iPanel.setBorder(new TitledBorder("Inventory"));
        this.iView = new InventoryView(this, gEngine.getPlayer().getInventory(), this._term.getScreenRows()-2);
        this.iView.setHeight(this._term.getScreenRows()-2);
        iPanel.add(this.iView);

        JPanel cPanel = new JPanel();
        cPanel.setBorder(new TitledBorder("Command -- ENTER to execute"));
        this.cmd = new CommandPrompt(this, "", this._term.getScreenColumns()-4);
        cPanel.add(this.cmd);

        Dimension dimension = new Dimension();
        dimension.height = this._term.getScreenRows()-7;
        dimension.width = this._term.getScreenColumns()-this.iView.getWidth()-3;
        this.gView = new GameView(dimension, new Point(3,3), gEngine);

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
        this.gView.draw();
    }

    public void updateInventory() {
        this.iView.updateInventory();
    }

    public GameView getGameView() {
        return this.gView;
    }

    public GameEngine getGameEngine(){
        return this.gEngine;
    }


    public CommandPrompt getCommandPrompt() {
        return this.cmd;
    }
}

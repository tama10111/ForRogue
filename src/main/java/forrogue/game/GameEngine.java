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
package forrogue.game;

import charva.awt.Point;
import forrogue.character.Player;
import forrogue.map.Hub;
import forrogue.map.Map;

import java.io.*;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

public class GameEngine implements Serializable {

    private Player player;
    private long seed;
    private Map map;
    private String savefile_name;

    private transient GameWindow gWindow;
    private Hub hub;
    private Random random;




    public GameEngine(Player player, long seed, String file) {
        this.player = player;
        this.seed = seed;
        this.savefile_name = file;
        this.random = new Random();
        this.random.setSeed(seed);
        this.hub = new Hub(this);
        this.map = new Map(this);
        this.map.setPlayerPosition();
    }


    public Player getPlayer(){
        return this.player;
    }

    public Map getMap(){
        return this.map;
    }

    public Random getRandom() {
        return this.random;
    }

    public Hub getHub() {
        return this.hub;
    }





    public void movePlayer(Point move){
        this.map.movePlayer(move);
    }

    public void sendUpdateInventorySignal() {
        this.gWindow.updateInventory();
    }

    public void setGameWindow(GameWindow gWindow) {
        this.gWindow = gWindow;
    }

    public GameWindow getGameWindow() {
        return this.gWindow;
    }

    public int getRandomNumber() {
        return Math.abs(this.random.nextInt());
    }

    public String getSaveFileName() { return savefile_name; }
}

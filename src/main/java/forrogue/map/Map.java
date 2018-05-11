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

import charva.awt.Component;
import charva.awt.Point;
import charva.awt.Toolkit;
import charvax.swing.JOptionPane;
import forrogue.Chest;
import forrogue.GameObject;
import forrogue.character.Player;
import forrogue.character.enemy.Enemy;
import forrogue.character.friendly.QuestMan;
import forrogue.game.GameConstant;
import forrogue.game.GameEngine;
import forrogue.item.Item;
import forrogue.item.ItemStack;
import forrogue.item.quest.Gem;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;

import static charvax.swing.JOptionPane.YES_NO_OPTION;
import static charvax.swing.JOptionPane.YES_OPTION;


public class Map implements Serializable {
    private  Object[][] matrix;
    private  GameEngine gEngine;
    private ArrayList<Enemy> l_enemy;

    public Map(GameEngine gEngine){
        this.gEngine = gEngine;
        this.matrix = gEngine.getHub().getMatrix();
        this.setPlayerPosition();
        this.l_enemy = new ArrayList<>();
        this.setEnemyList();
    }

    public void movePlayer(Point move){

        Point coord_player = this.gEngine.getPlayer().getPosition();

        Object target = this.matrix[coord_player.y+move.y][coord_player.x+move.x];

        if(!(target instanceof GameObject)){
            if((char) target == GameConstant.SKIN_VOID) {
                this.matrix[coord_player.y][coord_player.x] = GameConstant.SKIN_VOID;
                this.matrix[coord_player.y + move.y][coord_player.x + move.x] = this.gEngine.getPlayer();
                this.gEngine.getPlayer().move(move);
            }
        }

        else if(target instanceof Dungeon){
            this.matrix[coord_player.y][coord_player.x] = GameConstant.DUNGEON_PLAYER_POS;
            this.matrix[coord_player.y + move.y][coord_player.x + move.x] = new Dungeon(((Dungeon) target).getDifficulty(), gEngine.getHub(), gEngine.getRandom());
            this.setMatrix(((Dungeon) target).getMatrix());
            this.setPlayerPosition();
            this.setEnemyList();
            this.gEngine.getGameWindow().getGameView().repaint();
        }

        else if(target instanceof Hub){
            this.setMatrix(((Hub) target).getMatrix());
            this.setPlayerPosition();
            this.setEnemyList();
            this.gEngine.getGameWindow().getGameView().repaint();
        }

        else if(target instanceof Enemy){
            Enemy enemy = (Enemy) target;

            if(enemy.getSpeed() > gEngine.getPlayer().getSpeed()){
                enemy.attack(gEngine.getPlayer());
                gEngine.getPlayer().attack(enemy);
            } else{
                gEngine.getPlayer().attack(enemy);
                enemy.attack(gEngine.getPlayer());
            }

            if(enemy.getHp() <= 0){
                this.matrix[coord_player.y + move.y][coord_player.x + move.x] = GameConstant.SKIN_VOID;
                this.gEngine.getPlayer().addGems(
                        Gem.values()[this.gEngine.getRandomNumber()%Gem.values().length].getColor(),
                        this.gEngine.getRandomNumber()%5+1
                );
                this.l_enemy.remove(enemy);
            }

            if(gEngine.getPlayer().getHp() <= 0){

                Toolkit.getDefaultToolkit().close();
                System.out.println("Vous êtes mort");
                System.exit(0);
            }

        }

        else if(target instanceof Chest){
            Player player = gEngine.getPlayer();
            for(ItemStack iStack : ((Chest) target).getChestContent()){
                player.getInventory().addStack(iStack);
            }
            this.matrix[coord_player.y + move.y][coord_player.x + move.x] = GameConstant.SKIN_VOID;
            this.gEngine.sendUpdateInventorySignal();
        }

        else if(target instanceof QuestMan){

            QuestMan questMan = (QuestMan) target;

            Object[] objString = {
                    GameConstant.STRING_QUESTMAN_0,
                    GameConstant.STRING_QUESTMAN_1,
                    GameConstant.STRING_QUESTMAN_2,
                    " ",
                    String.format("Hey ! I need %s %s gem.", questMan.getQuestQuantity(), questMan.getQuestItem()),
                    "Have any ?"
            };

            int resp = JOptionPane.showConfirmDialog(
                    (Component) gEngine.getGameWindow().getCommandPrompt(),
                    objString,
                    "The QuestMan",
                    YES_NO_OPTION);

            if(resp == YES_OPTION){
                objString[4] = "Thanks bro !";
                objString[5] = "Here is your reward";
                if(questMan.checkPlayerGems(this.gEngine.getPlayer().getInventory(), this.gEngine.getPlayer().getGems())){
                    JOptionPane.showMessageDialog(
                            (Component) gEngine.getGameWindow().getCommandPrompt(),
                            objString,
                            "The QuestMan",
                            0
                    );
                    questMan.generateQuest(Math.abs(this.gEngine.getRandomNumber()));
                    gEngine.getGameWindow().updateInventory();

                } else{
                    objString[4] = "Haha u suck";
                    objString[5] = "GTFO xD";

                    JOptionPane.showMessageDialog(
                            (Component) gEngine.getGameWindow().getCommandPrompt(),
                            objString,
                            "The QuestMan",
                            0
                    );
                }
            } else{
                objString[4] = "Oh...";
                objString[5] = "Come back when you want !";
                JOptionPane.showMessageDialog(
                        (Component) gEngine.getGameWindow().getCommandPrompt(),
                        objString,
                        "The QuestMan",
                        0
                );
            }
        }

        if(!this.l_enemy.isEmpty() && !(target instanceof Dungeon)){
            for(Enemy e : this.l_enemy) this.moveEnemy(e, e.pathFinder(gEngine.getPlayer().getPosition(), this.matrix));
        }
    }

    public void moveEnemy(Enemy enemy, Point move){
        Object target = this.matrix[enemy.getPosition().y+move.y][enemy.getPosition().x+move.x];

        if(!(target instanceof GameObject)){
            if((char) this.matrix[enemy.getPosition().y+move.y][enemy.getPosition().x+move.x] != GameConstant.SKIN_WALL){
                this.matrix[enemy.getPosition().y][enemy.getPosition().x] = GameConstant.SKIN_VOID;
                this.matrix[enemy.getPosition().y+move.y][enemy.getPosition().x+move.x] = enemy;
                enemy.move(move);
            }
        } else if(target instanceof Player){
            enemy.attack((Player) target);
            Point coord_player = this.gEngine.getPlayer().getPosition();

            if(enemy.getHp() <= 0){
                this.matrix[coord_player.y + move.y][coord_player.x + move.x] = GameConstant.SKIN_VOID;
                this.gEngine.getPlayer().addGems(
                        Gem.values()[this.gEngine.getRandomNumber()%Gem.values().length].getColor(),
                        this.gEngine.getRandomNumber()%5+1
                );
                this.l_enemy.remove(enemy);
            }

            if(((Player) target).getHp() <= 0){
                Toolkit.getDefaultToolkit().close();
                System.out.println("Vous êtes mort");
                System.exit(0);
            }
        }
    }

    private void setEnemyList() {
        this.l_enemy.clear();
        for(Object[] line : this.matrix){
            for(Object o : line){
                if(o instanceof Enemy) this.l_enemy.add((Enemy) o);
            }
        }
    }

    public void setPlayerPosition(){
        int x = 0, y = 0;
        for(Object[] line : this.matrix){
            for(Object o : line){
                if(o != null) {
                    if (!(o instanceof GameObject)) {
                        if (((char) o) == GameConstant.DUNGEON_PLAYER_POS) {
                            this.gEngine.getPlayer().setPosition(new Point(x, y));
                            this.matrix[y][x] = this.gEngine.getPlayer();
                        }
                    } x++;
                }
            } y++; x = 0;
        }
    }

    public Object[][] getMatrix(){
        return this.matrix;
    }

    public void setMatrix(Object[][] matrix){
        this.matrix = matrix;
    }



}

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

import charva.awt.Dimension;

import charva.awt.Point;
import forrogue.Chest;
import forrogue.GameObject;
import forrogue.character.enemy.Enemy;
import forrogue.character.enemy.chevalier.*;
import forrogue.character.enemy.samurais.*;
import forrogue.character.enemy.vikings.*;
import forrogue.game.GameConstant;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author tama
 */

class Dungeon extends GameObject {
    
    private Dimension dimension;
    private Object[][] matrix;
    private int difficulty;

    public Dungeon(int difficulty, Hub hub, Random random){

        String path = null;
        int r;
        int mod;

        if(difficulty == 0){
            r = random.nextInt();
            mod = 11;
            path = "easy/"+Long.toString(Math.abs(r%mod)+1)+".map";
            this.setSkin(GameConstant.SKIN_DUNGEON_0);
        }

        else if(difficulty == 1){
            r = random.nextInt();
            mod = 6;
            path = "intermediate/"+Long.toString(Math.abs(r%mod)+1)+".map";
            this.setSkin(GameConstant.SKIN_DUNGEON_1);
        }

        else if(difficulty == 2){
            r = random.nextInt();
            mod = 7;
            path = "hard/"+Long.toString(Math.abs(r%mod)+1)+".map";
            this.setSkin(GameConstant.SKIN_DUNGEON_2);
        }

        InputStream stream = getClass().getClassLoader().getResourceAsStream(path);

        if(stream == null){
            stream = getClass().getClassLoader().getResourceAsStream("dungeon_failure.map");
        }

        Scanner f = new Scanner(stream);
        this.difficulty = difficulty;

        ArrayList<String> lines = new ArrayList();
        int max = 0, i = 0, j;
        while(f.hasNextLine()){
            lines.add(f.nextLine());
            if(lines.get(i).length() > max) max = lines.get(i).length();
            i++;
        }

        this.dimension = new Dimension(max, lines.size());
        this.matrix = new Object[lines.size()][max];

        i = 0; j = 0;
        for(String str : lines){
            for(char c : str.toCharArray()){
                switch(c){

                    case GameConstant.SKIN_WALL :
                        this.matrix[i][j] = GameConstant.SKIN_WALL;
                        break;

                    case GameConstant.SKIN_VOID :
                        this.matrix[i][j] = GameConstant.SKIN_VOID;
                        break;

                    case GameConstant.ENEMY :
                        r = Math.abs(random.nextInt());

                        if(this.difficulty == 0){
                            switch(r%4){
                                case 0 :
                                    this.matrix[i][j] = new Gladiateur();
                                    break;

                                case 1 :
                                    this.matrix[i][j] = new Shinobi();
                                    break;

                                case 2 :
                                    this.matrix[i][j] = new Berserker();
                                    break;

                                case 3 :
                                    this.matrix[i][j] = new Fanatique();
                                    break;
                            }
                        } else if(this.difficulty == 1){
                            switch(r%10){
                                case 0 :
                                    this.matrix[i][j] = new GardePaix();
                                    break;

                                case 1 :
                                    this.matrix[i][j] = new Aramusha();
                                    break;

                                case 2 :
                                    this.matrix[i][j] = new Orochi();
                                    break;

                                case 3 :
                                    this.matrix[i][j] = new Valkyrie();
                                    break;

                                case 4 :
                                    this.matrix[i][j] = new Shaman();
                                    break;

                                case 5 :
                                    this.matrix[i][j] = new Highlander();
                                    break;

                                case 6 :
                                    this.matrix[i][j] = new Kensei();
                                    break;

                                case 7 :
                                    this.matrix[i][j] = new Centurion();
                                    break;

                                case 8 :
                                    this.matrix[i][j] = new Sentinelle();
                                    break;

                                case 9 :
                                    this.matrix[i][j] = new Nobushi();
                                    break;

                            }
                        } else if(this.difficulty == 2){
                            switch(r%3){
                                case 0 :
                                    this.matrix[i][j] = new Jarl();
                                    break;

                                case 1 :
                                    this.matrix[i][j] = new Shugoki();
                                    break;

                                case 2 :
                                    this.matrix[i][j] = new Conquerant();
                                    break;
                            }
                        }
                        ((Enemy) this.matrix[i][j]).setPosition(new Point(j,i));
                        break;

                    case GameConstant.SKIN_HUB :
                        this.matrix[i][j] = hub;
                        break;

                    case GameConstant.SKIN_CHEST :
                        this.matrix[i][j] = new Chest(this.difficulty);
                        break;

                    case GameConstant.DUNGEON_PLAYER_POS :
                        this.matrix[i][j] = GameConstant.DUNGEON_PLAYER_POS;
                        break;

                    case '\n' :
                        this.matrix[i][j] = ' ';
                        break;

                    case ' ' :
                        this.matrix[i][j] = ' ';
                        break;

                    default:
                        this.matrix[i][j] = '?';
                        break;
                } j++;
            } i++; j = 0;
        }
    }

    public Dimension getDimension(){
        return this.dimension;
    }

    public Object[][] getMatrix(){
        return this.matrix;
    }

    public int getDifficulty(){
        return this.difficulty;
    }
}

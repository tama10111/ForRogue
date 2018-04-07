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

import forrogue.Chest;
import forrogue.GameObject;
import forrogue.character.ennemy.Berserker;
import forrogue.game.GameConstant;

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

        /**
         * Chercher dans les ressources aléatoirement
         * La difficulté déterminera le dossier
         * Un nombre aléatoire déterminera le fichier
         */

        if(difficulty == 0){
            this.setSkin(GameConstant.SKIN_DUNGEON_0);
        }

        if(difficulty == 1){
            this.setSkin(GameConstant.SKIN_DUNGEON_1);
        }

        if(difficulty == 2){
            this.setSkin(GameConstant.SKIN_DUNGEON_2);
        }

        Scanner f = new Scanner(getClass().getClassLoader().getResourceAsStream("dungeon_test.map"));
        this.difficulty = difficulty;

        ArrayList<String> lines = new ArrayList();
        int max = 0, i = 0, j;
        while(f.hasNextLine()) {
            lines.add(f.nextLine());
            if (lines.get(i).length() > max) max = lines.get(i).length();
            i++;
        }

        this.dimension = new Dimension(max, lines.size());
        this.matrix = new Object[lines.size()][max];

        i = j = 0;
        for(String str : lines){
            for(char c : str.toCharArray()){
                switch(c){

                    case GameConstant.SKIN_WALL :
                        this.matrix[i][j] = GameConstant.SKIN_WALL;
                        break;

                    case GameConstant.SKIN_VOID :
                        this.matrix[i][j] = GameConstant.SKIN_VOID;
                        break;

                    case GameConstant.ENNEMY :
                        this.matrix[i][j] = new Berserker();
                        /*
                        int r = random.nextInt();

                        if(this.difficulty == 0){

                        }

                        if(this.difficulty == 1){

                        }

                        if(this.difficulty == 2){

                        }*/

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

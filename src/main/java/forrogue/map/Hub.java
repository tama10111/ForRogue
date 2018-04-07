package forrogue.map;

import charva.awt.Dimension;
import forrogue.Chest;
import forrogue.GameObject;
import forrogue.character.ennemy.Berserker;
import forrogue.game.GameConstant;
import forrogue.game.GameEngine;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Hub extends GameObject {

    private Dimension dimension;
    private Object[][] matrix;
    private GameEngine gEngine;

    public Hub(GameEngine gEngine){
        this.gEngine = gEngine;
        this.setSkin(GameConstant.SKIN_HUB);

        Scanner f = new Scanner(getClass().getClassLoader().getResourceAsStream("hub.map"));
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

                    case GameConstant.SKIN_DUNGEON_0 :
                        this.matrix[i][j] = new Dungeon(0, this, this.gEngine.getRandom());
                        break;

                    case GameConstant.SKIN_DUNGEON_1 :
                        this.matrix[i][j] = new Dungeon(1, this, this.gEngine.getRandom());
                        break;

                    case GameConstant.SKIN_DUNGEON_2 :
                        this.matrix[i][j] = new Dungeon(2, this, this.gEngine.getRandom());
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
}

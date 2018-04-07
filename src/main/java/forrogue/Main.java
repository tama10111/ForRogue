package forrogue;

import forrogue.game.GameCreator;
import forrogue.game.GameEngine;
import forrogue.game.GameWindow;
import forrogue.character.ennemy.Berserker;
import forrogue.map.Hub;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Objects;
import java.util.Random;

/**
 *
 * @author tama
 */

public class Main {

    /**
     * @param args the command line arguments
     */

    public static void main(String[] args) throws IOException {

        FileReader saveFile = null;

        if(args.length == 1){
            try {
                saveFile = new FileReader(args[0]);
                GameEngine gEngine = new GameEngine(saveFile);
                GameWindow gui = new GameWindow("RogueLike", gEngine);
            } catch (FileNotFoundException ex) {
                System.out.println("File "+args[0]+" not found !");
                System.exit(1);
            }
        } else {
            GameCreator gCreator = new GameCreator();
        }
    }
}

package forrogue;

import forrogue.game.GameCreator;
import forrogue.game.GameEngine;
import forrogue.game.GameWindow;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author tama
 */

public class Main {

    /**
     * @param args the command line arguments
     */

    public static void main(String[] args){

        FileReader saveFile = null;

        if(args.length == 1){
            try {
                saveFile = new FileReader(args[0]);
                GameEngine gEngine = new GameEngine(saveFile);
            } catch (FileNotFoundException ex) {
                System.out.println("File "+args[0]+" not found !");
                System.exit(1);
            }
        } else {
            GameCreator gCreator = new GameCreator();
        }
    }
}

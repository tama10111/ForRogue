package forrogue;

import forrogue.game.GameCreator;
import forrogue.game.GameEngine;

import java.io.FileNotFoundException;
import java.io.FileReader;

/**
 *
 * @author tama
 */

public class Main {

    /**
     * @param args the command line arguments
     */

    public static void main(String[] args) throws InterruptedException {

        Home h = new Home();
        h.draw();

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

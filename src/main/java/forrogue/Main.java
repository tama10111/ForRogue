package forrogue;

import forrogue.game.GameCreator;
import forrogue.game.GameEngine;
import forrogue.game.GameWindow;

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
    
    public static void main(String[] args){

        FileReader saveFile = null;
        
        for(int i = 0; i<args.length; i++){
            if(args[i].equals("-f")){
                try {
                    saveFile = new FileReader(args[i+1]);
                } catch (FileNotFoundException ex) {
                    System.out.println("File "+args[i+1]+" not found !");
                    System.exit(1);
                }
            }
        }        

        if(saveFile == null){
            GameCreator gCreator = new GameCreator();
        } else{
            GameEngine gEngine = new GameEngine(saveFile);
            GameWindow gui = new GameWindow("RogueLike", gEngine);
        }
    }    
}

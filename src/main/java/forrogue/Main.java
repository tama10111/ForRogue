package forrogue;


import forrogue.game.GameCreator;
import forrogue.game.GameWindow;


import java.io.*;


public class Main {

    /**
     * @param args the command line arguments
     */

    public static void main(String[] args){

        Home h = new Home();
        h.draw();

        if(args.length == 1) {
            GameWindow gameWindow = new GameWindow("ForRogue",
                    null,
                    0,
                    args[0],
                    true
            );
        } else{
            GameCreator gc= new GameCreator();
        }
    }
}

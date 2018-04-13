package forrogue;

import charva.awt.Point;
import forrogue.character.Player;
import forrogue.character.enemy.Enemy;
import forrogue.game.GameCreator;
import forrogue.game.GameEngine;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;

/**
 *
 * @author tama
 */

public class Main {

    /**
     * @param args the command line arguments
     */

    public static void main(String[] args) throws InterruptedException, FileNotFoundException {

        if(false) {
            Player p = new Player("salut", "salut", "salut", new Point(0, 0), 'k');

            GameEngine g = new GameEngine(p, 123456789L, "filename.save");
            ArrayList<Enemy> list = new ArrayList<>();

            for (Object[] line : g.getHub().getMatrix()) {
                for (Object o : line) {
                    if (o instanceof Enemy) {
                        list.add((Enemy) o);
                    }
                }
            }

            for (Enemy e : list) {
                System.out.println(e.pathFinder(g.getPlayer().getPosition(), g.getHub().getMatrix()));
            }
        }


        if(true){

            Home h = new Home();
            h.draw();

            FileReader saveFile = null;

            if (args.length == 1) {
                try {
                    saveFile = new FileReader(args[0]);
                    GameEngine gEngine = new GameEngine(saveFile);
                } catch (FileNotFoundException ex) {
                    System.out.println("File " + args[0] + " not found !");
                    System.exit(1);
                }
            } else {
                GameCreator gCreator = new GameCreator();
            }
        }
    }
}

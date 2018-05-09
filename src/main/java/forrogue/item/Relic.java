package forrogue.item;

import forrogue.game.GameConstant;
import forrogue.item.wearable.Wearable;

/**
 *
 * @author user
 */
public abstract class Relic extends Wearable {
    public Relic(){
        super("Relic",GameConstant.SKIN_RELIC,0,-1,0);
    }
}

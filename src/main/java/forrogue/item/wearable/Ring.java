package forrogue.item.wearable;

import forrogue.game.GameConstant;

/**
 *
 * @author user
 */
public abstract class Ring extends Wearable {
    public Ring(){
        super("Ring", GameConstant.SKIN_RING, 0, 0, 2 );
    }
}

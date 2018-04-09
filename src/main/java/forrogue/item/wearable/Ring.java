package forrogue.item.specialitem.wearable;

import forrogue.game.GameConstant;
import forrogue.item.specialitem.OtherStuff;

/**
 *
 * @author user
 */
public abstract class Ring extends OtherStuff {

    private int nb_max;
    public Ring(){
        super("Ring",GameConstant.SKIN_RING,0,0,0,2 );
        this.nb_max=1;
    }


}

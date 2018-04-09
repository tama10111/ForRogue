package forrogue.item.otherStuff;

import forrogue.game.GameConstant;

/**
 *
 * @author user
 */
public abstract class Relic extends OtherStuff{

public int value;
    public Relic(){
        super("Relic",GameConstant.SKIN_RELIC,0,0,-1,0 );
        this.value=40;
    }


}

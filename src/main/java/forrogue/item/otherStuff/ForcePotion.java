package forrogue.item.otherStuff;

import forrogue.game.GameConstant;

/**
 *
 * @author user
 */
public abstract class ForcePotion extends OtherStuff{

    private int nb_max;
    public ForcePotion(){
        super("ForcePotion",GameConstant.SKIN_FORCEPOTION,2,0,0 ,0);
        this.nb_max=1;
    }


}

package forrogue.item.otherStuff;

import forrogue.character.Character;
import forrogue.item.Item;

/**
 *
 * @author user
 */
public abstract class OtherStuff extends Item {

    private int defense;
    private int speed;
    private int max_hp;
    private int attack;

    public OtherStuff(String name, char skin, int attack,int defense, int speed,int max_hp){
        super(name, skin);
        this.defense = defense;
        this.speed = speed;
        this.max_hp=max_hp;
        this.attack=attack;
    }

    @Override
    public void use(Character user) {
        this.defense = this.defense;
        this.max_hp=this.max_hp;
        this.attack=this.attack;
        this.speed=this.speed;
    }
}

package forrogue.item.wearable;

import forrogue.character.Character;
import forrogue.item.Item;

public class Wearable extends Item {

    public Wearable(String name, char skin, int defense, int speed, int hp){
        super(name, skin);
        this.setHp(hp);
        this.setDefense(defense);
        this.setSpeed(speed);
    }

    @Override
    public void use(Character character) {
        character.setWear(this);
    }
}

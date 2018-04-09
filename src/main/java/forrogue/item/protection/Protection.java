/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forrogue.item.protection;

import forrogue.character.Character;
import forrogue.character.Player;
import forrogue.item.Item;

/**
 *
 * @author user
 */

public abstract class Protection extends Item {

    public Protection(String name, char skin, int defense, int speed, int hp){
        super(name, skin);
        this.setHp(hp);
        this.setDefense(defense);
        this.setSpeed(speed);

    }

    @Override
    public void use(Character character){
        character.setProtection(this);
    }
}

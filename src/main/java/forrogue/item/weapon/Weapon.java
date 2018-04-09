/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forrogue.item.weapon;

import forrogue.character.Character;
import forrogue.item.Item;

/**
 *
 * @author user
 */
public abstract class Weapon extends Item {

    public Weapon(String name, char skin, int attack, int speed){
        super(name, skin);
        this.setAttack(attack);
        this.setSpeed(speed);
    }

    @Override
    public void use(Character character){
        character.setWeapon(this);
    }
}

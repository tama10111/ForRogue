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
    int power;
    int speed;
    public Weapon(String name, char skin, int power, int speed){
        super(name, skin);
        this.power=power;
        this.speed= speed;
    }

    @Override
    public void use(Character character){
        character.receiveDamages(this.power);
    }






}

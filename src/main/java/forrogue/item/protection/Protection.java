/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forrogue.item.protection;

import forrogue.character.Character;
import forrogue.item.Item;

/**
 *
 * @author user
 */
public abstract class Protection extends Item {

    private int defense;
    private int speed_malus;

    public Protection(String name, char skin, int defense, int speed_malus){
        super(name, skin);
        this.defense = defense;
        this.speed_malus = speed_malus;
    }

    @Override
    public void use(Character user) {
        this.defense = this.defense;

    }
}

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
    private int speed;
    private int hp;

    public Protection(String name, char skin, int defense, int speed,int hp){
        super(name, skin);
        this.defense = defense;
        this.speed = speed;
        this.hp=hp;
    }

    @Override
    public void use(Character user) {
        this.defense = this.defense;
        this.hp=this.hp;
    }
}

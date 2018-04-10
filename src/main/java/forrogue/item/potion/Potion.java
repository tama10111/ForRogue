/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forrogue.item.potion;

import forrogue.character.Character;
import forrogue.item.Item;

/**
 *
 * @author user, tama
 */

public abstract class Potion extends Item {

    int hp;

    public Potion (String name, char skin, int hp){
        super(name, skin);
        this.hp = hp;
    }

    @Override
    public void use(Character character){
         if(this.hp + character.getHp() >= character.getMaxHp()){
            character.setHp(character.getMaxHp());
        } else{
            character.setHp(character.getHp()+this.hp);
        }
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forrogue.character.enemy.vikings;

import forrogue.character.enemy.vikings.Vikings;

import forrogue.game.GameConstant;

/**
 *
 * @author user
 */
public class Shaman extends Vikings {
    
    public Shaman(){
        this.setHp(11);
        this.setMaxHp(11);
        this.setAttack(3);
        this.setDefense(1);
        this.setPerception(10);
        this.setName("Shaman");
        this.setGender("Male");
        this.setSkin(GameConstant.SKIN_SHAMAN);
        // Rajouter l'inventaire quand Pierre aura implémenté toute les armes
    }
    
}

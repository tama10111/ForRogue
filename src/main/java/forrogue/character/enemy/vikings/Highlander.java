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
public class Highlander extends Vikings {
    
    public Highlander(){
        this.setHp(12);
        this.setMaxHp(12);
        this.setAttack(4);
        this.setDefense(0);
        this.setPerception(11);
        this.setName("Highlander");
        this.setGender("Male");
        this.setSkin(GameConstant.SKIN_HIGHLANDER);
        // Rajouter l'inventaire quand Pierre aura implémenté toute les armes
    }
    
}

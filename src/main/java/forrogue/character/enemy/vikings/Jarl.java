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
public class Jarl extends Vikings {
    
    public Jarl(){
        this.setHp(16);
        this.setMaxHp(16);
        this.setAttack(2);
        this.setDefense(0);
        this.setName("Jarl");
        this.setPerception(15);
        this.setGender("Male");
        this.setSkin(GameConstant.SKIN_JARL);
        // Rajouter l'inventaire quand Pierre aura implémenté toute les armes
    }
    
}

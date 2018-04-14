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
public class Valkyrie extends Vikings {
    
    public Valkyrie(){
        this.setHp(10);
        this.setMaxHp(10);
        this.setAttack(3);
        this.setDefense(1);
        this.setPerception(9);
        this.setName("Valkyrie");
        this.setGender("Female");
        this.setSkin(GameConstant.SKIN_VALKYRIE);
        // Rajouter l'inventaire quand Pierre aura implémenté toute les armes
    }
    
}

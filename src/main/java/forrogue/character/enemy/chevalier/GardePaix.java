/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forrogue.character.enemy.chevalier;

import forrogue.character.enemy.chevalier.Chevaliers;

import forrogue.game.GameConstant;

/**
 *
 * @author user
 */
public class GardePaix extends Chevaliers {
    
    public GardePaix(){
        this.setHp(8);
        this.setMaxHp(8);
        this.setAttack(5);
        this.setDefense(0);
        this.setPerception(7);
        this.setName("Garde-Paix");
        this.setGender("Male");
        this.setSkin(GameConstant.SKIN_GARDEPAIX);
        // Rajouter l'inventaire quand Pierre aura implémenté toute les armes
    }
    
}

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
public class Conquerant extends Chevaliers {
    
    public Conquerant(){
        this.setHp(14);
        this.setMaxHp(14);
        this.setAttack(2);
        this.setDefense(1);
        this.setPerception(13);
        this.setName("Conquerant");
        this.setGender("Male");
        this.setSkin(GameConstant.SKIN_CONQUERANT);
        // Rajouter l'inventaire quand Pierre aura implémenté toute les armes
    }
    
}

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
public class Sentinelle extends Chevaliers {
    
    public Sentinelle(){
        this.setHp(10);
        this.setMaxHp(10);
        this.setAttack(4);
        this.setDefense(1);
        this.setPerception(9);
        this.setName("Sentinelle");
        this.setGender("Male");
        this.setSkin(GameConstant.SKIN_SENTINELLE);
        // Rajouter l'inventaire quand Pierre aura implémenté toute les armes
    }
    
    
    
    
}

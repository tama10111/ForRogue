/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forrogue.character.enemy.samurais;

import forrogue.character.enemy.samurais.Samurais;

import forrogue.game.GameConstant;

/**
 *
 * @author user
 */
public class Shinobi extends Samurais {
    
    public Shinobi(){
        this.setHp(6);
        this.setMaxHp(6);
        this.setAttack(6);
        this.setDefense(-1);
        this.setPerception(5);
        this.setName("Shinobi");
        this.setGender("Male");
        this.setSkin(GameConstant.SKIN_SHINOBI);
        // Rajouter l'inventaire quand Pierre aura implémenté toute les armes
    }
    
}

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
public class Shugoki extends Samurais {
    
    public Shugoki(){
        this.setHp(20);
        this.setMaxHp(20);
        this.setAttack(3);
        this.setDefense(1);
        this.setPerception(19);
        this.setName("Shugoki");
        this.setGender("Male");
        this.setSkin(GameConstant.SKIN_SHUGOKI);
        // Rajouter l'inventaire quand Pierre aura implémenté toute les armes
    }
    
}

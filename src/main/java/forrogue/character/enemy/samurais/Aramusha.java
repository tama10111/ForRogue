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
public class Aramusha extends Samurais {
    
    public Aramusha(){
        this.setHp(8);
        this.setMaxHp(8);
        this.setAttack(4);
        this.setDefense(2);
        this.setName("Aramusha");
        this.setGender("Male");
        this.setSkin(GameConstant.SKIN_ARAMUSHA);
        // Rajouter l'inventaire quand Pierre aura implémenté toute les armes
    }
    
}

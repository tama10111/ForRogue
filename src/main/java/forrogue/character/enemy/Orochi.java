/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forrogue.character.enemy;

import forrogue.game.GameConstant;

/**
 *
 * @author user
 */
public class Orochi extends Samurais{
    
    public Orochi(){
        this.setHp(9);
        this.setMaxHp(9);
        this.setAttack(3);
        this.setDefense(1);
        this.setName("Orochi");
        this.setGender("Male");
        this.setSkin(GameConstant.SKIN_OROCHI);
        // Rajouter l'inventaire quand Pierre aura implémenté toute les armes
    }
    
}

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
public class Centurion extends Chevaliers{
    
    public Centurion(){
        this.setHp(11);
        this.setMaxHp(11);
        this.setAttack(3);
        this.setDefense(1);
        this.setName("Centurion");
        this.setGender("Male");
        this.setSkin(GameConstant.SKIN_CENTURION);
        // Rajouter l'inventaire quand Pierre aura implémenté toute les armes
    }
    
}

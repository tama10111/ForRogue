/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forrogue.character.enemy;

import charva.awt.Point;
import forrogue.game.GameConstant;

/**
 *
 * @author user
 */
public class Nobushi extends Samurais{
    
    public Nobushi(Point position){
        this.setHp(11);
        this.setMaxHp(11);
        this.setAttack(4);
        this.setDefense(1);
        this.setName("Nobushi");
        this.setGender("Female");
        this.setSkin(GameConstant.SKIN_NOBUSHI);
        // Rajouter l'inventaire quand Pierre aura implémenté toute les armes
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forrogue.character.ennemy;

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
        this.setName("Valkyrie");
        this.setGender("Female");
        // Rajouter l'inventaire quand Pierre aura implémenté toute les armes
    }
    
}

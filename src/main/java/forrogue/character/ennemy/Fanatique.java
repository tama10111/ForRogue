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
public class Fanatique extends Lourds {
    
    public Fanatique(){
        this.setHp(6);
        this.setMaxHp(6);
        this.setAttack(4);
        this.setDefense(2);
        this.setName("Fanatique");
        this.setGender("Male");
        // Rajouter l'inventaire quand Pierre aura implémenté toute les armes
    }
    
}

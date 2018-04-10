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
public class Jarl extends Vikings {
    
    public Jarl(){
        this.setHp(16);
        this.setMaxHp(16);
        this.setAttack(2);
        this.setDefense(0);
        this.setName("Jarl");
        this.setGender("Male");
        // Rajouter l'inventaire quand Pierre aura implémenté toute les armes
    }
    
}

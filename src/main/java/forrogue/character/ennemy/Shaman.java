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
public class Shaman extends Assassin{
    
    public Shaman(){
        this.setHp(11);
        this.setMaxHp(11);
        this.setAttack(3);
        this.setDefense(1);
        this.setName("Shaman");
        this.setGender("Male");
        // Rajouter l'inventaire quand Pierre aura implémenté toute les armes
    }
    
}

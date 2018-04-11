/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forrogue.character.enemy;

/**
 *
 * @author user
 */
public class Gladiateur extends Chevaliers{
    
    public Gladiateur(){
        this.setHp(6);
        this.setMaxHp(6);
        this.setAttack(4);
        this.setDefense(0);
        this.setName("Orochi");
        this.setGender("Male");
        // Rajouter l'inventaire quand Pierre aura implémenté toute les armes
    }
    
}

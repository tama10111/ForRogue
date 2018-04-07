/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forrogue.character;

import charva.awt.Point;
import forrogue.Inventory;

/**
 *
 * @author tama
 */
public class Player extends Character {

    public Player(String name, String gender, String type, Point position) {
        this.setInventory(new Inventory());
        this.setName(name);
        this.setGender(gender);
        this.setType(type);
        this.setPosition(position);
    }
}

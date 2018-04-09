/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forrogue.character;

import charva.awt.Point;

import forrogue.Inventory;
import forrogue.game.GameConstant;
import forrogue.item.protection.UnderWear;
import forrogue.item.weapon.Hand;

import java.util.HashMap;

/**
 *
 * @author tama
 */
public class Player extends Character {

    HashMap<String, Integer> gems;

    public Player(String name, String gender, String type, Point position, char skin) {

        GameConstant.SKIN_PLAYER = skin;

        this.gems = new HashMap<String, Integer>();
        this.gems.put("white", 0);
        this.gems.put("black", 0);
        this.gems.put("blue", 1); // TODO : Remettre à zéro - test
        this.gems.put("green", 0);
        this.gems.put("yellow", 0);
        this.gems.put("red", 0);

        // TODO : À virer - test
        this.setWeapon(new Hand());
        this.setProtection(new UnderWear());


        //TODO : Associer des stats à un type donné
        this.setHp(999);
        this.setMaxHp(9999);
        this.setAttack(999);
        this.setDefense(999);
        this.setSpeed(999);

        this.setInventory(new Inventory());

        this.setName(name);
        this.setGender(gender);
        this.setType(type);
        this.setPosition(position);
        this.setSkin(skin);
    }

    public HashMap<String,Integer> getGems() {
        return this.gems;
    }

    public void addGems(String color, int i) {
        this.gems.replace(color, this.gems.get(color) + i);
    }
}

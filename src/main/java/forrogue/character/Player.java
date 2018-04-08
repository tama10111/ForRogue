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

/**
 *
 * @author tama
 */
public class Player extends Character {

    public Player(String name, String gender, String type, Point position) {

        // TODO : À virer - Pour mes tests
        this.setWeapon(new Hand());
        this.setProtection(new UnderWear());


        //TODO : Associer des stats à un type donné
        this.setHp(999);
        this.setAttack(999);
        this.setDefense(999);
        this.setSpeed(999);

        this.setInventory(new Inventory());
        this.setName(name);
        this.setGender(gender);
        this.setType(type);
        this.setPosition(position);
        this.setSkin(GameConstant.SKIN_PLAYER); // TODO : Permettre au joueur de set un skin dans le GameCreator ou associer un skin à un type;
    }
}

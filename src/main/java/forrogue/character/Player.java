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
import forrogue.item.wearable.None;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.HashMap;

/**
 *
 * @author tama
 */
public class Player extends Character {

    private HashMap<String, Integer> gems;

    public Player(String name, String gender, String type,  Point position, char skin) {
        GameConstant.SKIN_PLAYER = skin;
        this.gems = new HashMap<String, Integer>();
        this.gems.put("white", 0);
        this.gems.put("black", 0);
        this.gems.put("blue", 0);
        this.gems.put("green", 0);
        this.gems.put("yellow", 0);
        this.gems.put("red", 0);

        this.setWeapon(new Hand());
        this.setProtection(new UnderWear());
        this.setWear(new None());

        if(type.equals("Chevalier")){
            this.setHp(10);
            this.setAttack(12);
            this.setDefense(2);
            this.setSpeed(8);
        }

        else if(type.equals("Viking")){
            this.setHp(8);
            this.setAttack(14);
            this.setDefense(0);
            this.setSpeed(10);
        }

        else if(type.equals("Assassin")){
            this.setHp(8);
            this.setAttack(12);
            this.setDefense(0);
            this.setSpeed(12);
        }

        else{
            this.setHp(10);
            this.setAttack(10);
            this.setDefense(0);
            this.setSpeed(10);
        }

        this.setMaxHp(100);
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

    private void writeObject(ObjectOutputStream oos)throws IOException {
        oos.defaultWriteObject();
        oos.writeInt(position.x);
        oos.writeInt(position.y);
    }

    private void readObject(ObjectInputStream ois)throws ClassNotFoundException,IOException{
        int a,b;
        ois.defaultReadObject();
        a=ois.readInt();
        b=ois.readInt();
        position=new Point(a,b);
    }
}

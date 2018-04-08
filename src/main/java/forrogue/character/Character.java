/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forrogue.character;

import charva.awt.Point;
import forrogue.GameObject;
import forrogue.Inventory;
import forrogue.item.protection.Protection;
import forrogue.item.weapon.Mace;
import forrogue.item.weapon.Weapon;

/**
 *
 * @author tama
 */
public abstract class Character extends GameObject {
    

    // OBJECTS HELD

    private Inventory inventory;
    private Weapon weapon;
    private Protection protection;

    // SOME INFORMATIONS

    private String gender;
    private String type;
    private String name;

    // STATS

    private int hp;
    private int max_hp;
    private int attack;
    private int defense;
    private int speed;

    public Inventory getInventory(){
        return this.inventory;
    }

    public void setInventory(Inventory inventory){
        this.inventory = inventory;
    }

    public String getName(){
        return this.name;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getGender(){
        return this.gender;
    }

    public void setGender(String gender){
        this.gender = gender;
    }

    public String getType() {
        return this.type;
    }

    public void setType(String type){
        this.type = type;
    }

    public int getDefense() {
        return this.defense;
    }

    public void setDefense(int defense){
        this.defense = defense;
    }

    public int getHp() {
        return this.hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getAttack(){
        return this.attack;
    }

    public int getMaxHp(){
        return this.max_hp;
    }

    public void setMaxHp(int max_hp){
        this.max_hp = max_hp;
    }

    public void setAttack(int attack){
        this.attack = attack;
    }

    public int getSpeed(){
        return this.speed;
    }

    public void setSpeed(int speed){
        this.speed = speed;
    }

    public void move(Point move) {
        this.getPosition().x += move.x;
        this.getPosition().y += move.y;
    }

    public void attack(Character ennemy){
        if(this.holdWeapon()){
            this.weapon.use(ennemy);
        }
    }

    public void receiveDamages(int damages){
        this.setHp(this.getHp() - damages + this.getDefense());
    }

    public boolean holdWeapon() {
        if(this.weapon != null){
            return true;
        } return false;
    }

    protected void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }
}

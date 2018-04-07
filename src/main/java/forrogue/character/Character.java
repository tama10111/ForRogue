/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forrogue.character;

import charva.awt.Point;
import forrogue.GameObject;
import forrogue.Inventory;

/**
 *
 * @author tama
 */
public abstract class Character extends GameObject {
    
    private Inventory inventory;

    private String gender;
    private String type;
    private String name;

    private Point position;
    
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

    public Point getPosition(){
        return this.position;
    }

    public void setPosition(Point playerPosition){
        this.position = playerPosition;
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
        this.position.x += move.x;
        this.position.y += move.y;
    }

    public void attack(Character ennemy){

    }

    public void receiveDamages(int damages){
        this.setHp(this.getHp() - damages + this.getDefense());
    }

}

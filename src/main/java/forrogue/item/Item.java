/*
 * Copyright (C) 2018 tama
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License
 * as published by the Free Software Foundation; either version 2
 * of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place - Suite 330, Boston, MA  02111-1307, USA.
 */

package forrogue.item;

import forrogue.GameObject;
import forrogue.character.Character;



public abstract class Item extends GameObject {

    private int hp;
    private int attack;
    private int defense;
    private int speed;
    private int value;

    public Item(String name, char skin) {
        this.hp = 0;
        this.attack = 0;
        this.defense = 0;
        this.speed = 0;
        this.value = 0;
        this.setName(name);
        super.setSkin(skin);
    }
    
    @Override
    public String toString(){
        return this.getName();
    }

    public abstract void use(Character character);

    public int getHp(){
        return this.hp;
    }

    public void setHp(int hp){
        this.hp = hp;
    }

    public int getAttack() {
        return this.attack;
    }

    public void setAttack(int attack){
        this.attack = attack;
    }

    public int getDefense() {
        return this.defense;
    }

    public void setDefense(int defense){
        this.defense = defense;
    }

    public int getSpeed(){
        return this.speed;
    }

    public void setSpeed(int speed){
        this.speed = speed;
    }
}

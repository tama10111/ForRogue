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
package forrogue;

import forrogue.game.GameConstant;
import forrogue.item.ItemStack;
import forrogue.item.protection.*;
import forrogue.item.weapon.*;
import forrogue.item.potion.*;
import forrogue.item.wearable.*;
import java.util.Random;
import java.util.Vector;

/**
 *
 * @author tama
 */
public class Chest extends GameObject{

    Inventory inventory;

    /**
     *
     * @param level Correspond à la qualité des items dans le coffre. C'est tout simplement la difficulté du donjon qui gère ça.
     */

    public Chest(int level){
        this.setSkin(GameConstant.SKIN_CHEST);
        this.inventory = new Inventory();
        Random rand = new Random();
        int aleaValue = rand.nextInt(7);

        if (level == 0) {

            if (aleaValue == 0) {
                this.inventory.addOne(new LargePotion());

            }

            if (aleaValue == 1) {
                this.inventory.addOne(new Sword());

            }

            if (aleaValue == 2) {
                this.inventory.addOne(new IronShield());

            }

            if (aleaValue == 3) {
                this.inventory.addOne(new LargePotion());
                this.inventory.addOne(new Sword());
            }
            if (aleaValue == 4) {
                this.inventory.addOne(new WoodShield());
                this.inventory.addOne(new Sword());
            }

            if (aleaValue == 5) {
                this.inventory.addOne(new WoodShield());
                this.inventory.addOne(new Sword());
                this.inventory.addOne(new LargePotion());

            }

            if (aleaValue == 6) {
                this.inventory.addOne(new IronShield());
                this.inventory.addOne(new Sword());
                this.inventory.addOne(new SmallPotion());

            }

            if (aleaValue == 7) {
                this.inventory.addOne(new IronShield());
                this.inventory.addOne(new Sword());
                this.inventory.addOne(new SmallPotion());
                this.inventory.addOne(new WoodShield());

            }


        }


        if (level == 1) {

            if (aleaValue == 0) {
                this.inventory.addOne(new DoubleShortSword());


            }

            if (aleaValue == 1) {

                this.inventory.addOne(new Mace());


            }

            if (aleaValue == 2) {

                this.inventory.addOne(new LeatherArmor());

            }

            if (aleaValue == 3) {

                this.inventory.addOne(new Trident());
                this.inventory.addOne(new LeatherArmor());
            }
            if (aleaValue == 4) {
                this.inventory.addOne(new Mace());
                this.inventory.addOne(new LeatherArmor());
            }

            if (aleaValue == 5) {

                this.inventory.addOne(new Mace());
                this.inventory.addOne(new LeatherArmor());
                this.inventory.addOne(new LargePotion());

            }

            if (aleaValue == 6) {

                this.inventory.addOne(new Mace());
                this.inventory.addOne(new LeatherArmor());
                this.inventory.addOne(new SmallPotion());

            }

            if (aleaValue == 7) {
                this.inventory.addOne(new DoubleShortSword());
                this.inventory.addOne(new Mace());
                this.inventory.addOne(new Trident());
                this.inventory.addOne(new LeatherArmor());
                this.inventory.addOne(new SmallPotion());


            }


        }


        if (level == 2) {

            if (aleaValue == 0) {
                this.inventory.addOne(new Halberd());
                this.inventory.addOne(new ChainMail());
                this.inventory.addOne(new Boots());


            }

            if (aleaValue == 1) {

                this.inventory.addOne(new Axe());
                this.inventory.addOne(new ChainMail());
                this.inventory.addOne(new Bracelet());


            }

            if (aleaValue == 2) {

                this.inventory.addOne(new DoubleHandedSword());
                this.inventory.addOne(new ChainMail());


            }

            if (aleaValue == 3) {
                this.inventory.addOne(new LargePotion());
                this.inventory.addOne(new Halberd());
                this.inventory.addOne(new PlateArmor());
            }
            if (aleaValue == 4) {
                this.inventory.addOne(new Halberd());
                this.inventory.addOne(new Axe());
                this.inventory.addOne(new DoubleHandedSword());
                this.inventory.addOne(new ChainMail());

            }

            if (aleaValue == 5) {
                this.inventory.addOne(new Halberd());
                this.inventory.addOne(new Axe());
                this.inventory.addOne(new ChainMail());
                this.inventory.addOne(new LargePotion());

            }

            if (aleaValue == 6) {
                this.inventory.addOne(new Halberd());
                this.inventory.addOne(new DoubleHandedSword());
                this.inventory.addOne(new PlateArmor());
                this.inventory.addOne(new LargePotion());

            }

            if (aleaValue == 7) {
                this.inventory.addOne(new Halberd());
                this.inventory.addOne(new Axe());
                this.inventory.addOne(new DoubleHandedSword());
                this.inventory.addOne(new ChainMail());
                this.inventory.addOne(new PlateArmor());

            }


        }







    }

    public Vector<ItemStack> getChestContent(){
        return this.inventory.getItemList();
    }

}






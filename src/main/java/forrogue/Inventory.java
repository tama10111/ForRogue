/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forrogue;

import forrogue.item.Item;

import java.util.Vector;


/**
 *
 * @author tama
 */

public class Inventory {

    private Vector<Item> item_list;

    public Inventory(){
        this.item_list = new Vector<Item>();
    }

    public void add(Item item){
        this.item_list.add(item);
    }

    public Vector<Item> getItemList() {
        return this.item_list;
    }
}

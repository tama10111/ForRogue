/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forrogue;

import forrogue.item.Item;
import forrogue.item.ItemStack;

import java.io.Serializable;
import java.util.Vector;


/**
 *
 * @author tama
 */

public class Inventory implements Serializable{

    private Vector<ItemStack> item_list;

    public Inventory(){
        this.item_list = new Vector<ItemStack>();
    }

    public void add(Item item, int n){
        for(ItemStack iStack : this.item_list){
            if(iStack.getItemName() == item.getName()){
                iStack.add(n);
                return;
            }
        }
        this.item_list.add(new ItemStack(item, n));
    }

    public void addOne(Item item){
        for(ItemStack iStack : this.item_list){
            if(iStack.getItemName() == item.getName()){
                iStack.addOne();
                return;
            }
        } this.item_list.add(new ItemStack(item));

    }

    public Vector<ItemStack> getItemList() {
        return this.item_list;
    }

    public void remove(int index){
        this.item_list.remove(index);
    }

    public void addStack(ItemStack iStack) {
        for(ItemStack iSt : this.item_list){
            if(iSt.getItemName() == iStack.getItemName()){
                iSt.add(iStack.getQuantity());
                return;
            }
        } this.item_list.add(iStack);
    }
}

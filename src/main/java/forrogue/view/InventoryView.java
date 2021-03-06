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

package forrogue.view;

import charva.awt.BorderLayout;
import charva.awt.Component;
import charva.awt.event.AWTEvent;
import charva.awt.event.KeyEvent;
import charva.awt.event.KeyListener;
import charvax.swing.JList;
import charvax.swing.JOptionPane;
import charvax.swing.JScrollPane;
import forrogue.Inventory;
import forrogue.game.GameWindow;
import forrogue.item.Item;
import forrogue.item.ItemStack;
import forrogue.item.potion.Potion;

import java.io.Serializable;
import java.util.Enumeration;

import static charvax.swing.JOptionPane.YES_NO_OPTION;
import static charvax.swing.JOptionPane.YES_OPTION;

/**
 *
 * @author tama
 */

public class InventoryView extends JScrollPane implements Serializable {

    private JList list;
    private Inventory inventory;
    private GameWindow gWindow;
    
    public InventoryView(GameWindow gWindow, Inventory inventory, int rows) {
        
        this.setLayout(new BorderLayout());

        this.inventory = inventory;
        this.list = new JList();
        this.list.setListData(inventory.getItemList());
        this.list.setVisibleRowCount(rows-5);
        this.gWindow = gWindow;

        int max = 20;
        for(ItemStack iStack : inventory.getItemList()){
            if(iStack.toString().length() > max){
                max = iStack.toString().length();
            }
        }

        this.setWidth(max+3);
        this.list.setColumns(max);
        this.setViewportView(this.list);
        this.addKeyListener(new KeyListener(){
            
           @Override
            public void keyPressed(KeyEvent ke) {}

            @Override
            public void keyTyped(KeyEvent ke) {
                switch(ke.getKeyCode()){
                    case KeyEvent.VK_ENTER :
                        if(inventory.getItemList().size() != 0){
                            if(JOptionPane.showConfirmDialog((Component) gWindow.getCommandPrompt(), "Use this object ?", "", YES_NO_OPTION) == YES_OPTION){
                                ItemStack item = (ItemStack) list.getSelectedValue();
                                item.use(gWindow.getGameEngine().getPlayer());

                                if(item.getQuantity() == 0){
                                    inventory.remove(list.getSelectedIndex());
                                }
                            } gWindow.updateInventory();
                        } break;
                }
            }

            @Override
            public void keyReleased(KeyEvent ke) {}
        });
    }
    
    public void setMaxRow(int maxrow){
        this.list.setVisibleRowCount(maxrow);
        this.setHeight(maxrow+2);
    }

    
    @Override
    public void processKeyEvent(KeyEvent ke_) {
        if (_keyListeners != null) {
            for (Enumeration e = _keyListeners.elements();
                 e.hasMoreElements();) {

                KeyListener kl = (KeyListener) e.nextElement();

                if (ke_.getID() == AWTEvent.KEY_PRESSED){
                    this.list.processKeyEvent(ke_);
                    kl.keyPressed(ke_);
                }

                else if (ke_.getID() == AWTEvent.KEY_TYPED){
                    this.list.processKeyEvent(ke_);
                    kl.keyTyped(ke_);
                }

                if (ke_.isConsumed())
                    break;
            }
        }
    }

    public void updateInventory() {
        this.list.setListData(this.inventory.getItemList());
        int max = 11;
        for(ItemStack iStack : inventory.getItemList()){
            if(iStack.toString().length() > max){
                max = iStack.toString().length();
            }
        }
        this.setWidth(max+3);
        this.repaint();
    }

    public JList getList() {
        return this.list;
    }
}

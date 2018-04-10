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

import charva.awt.Component;
import charva.awt.EventQueue;
import charva.awt.Point;
import charva.awt.Toolkit;
import charva.awt.event.*;
import charvax.swing.JOptionPane;
import static charvax.swing.JOptionPane.YES_NO_OPTION;
import static charvax.swing.JOptionPane.YES_OPTION;
import charvax.swing.JTextField;
import forrogue.game.GameWindow;

import java.util.Enumeration;

/**
 *
 * @author tama
 */
public class CommandPrompt extends JTextField{

    private GameWindow gWindow;
    
    public CommandPrompt(GameWindow gWindow){
        super();
        this.gWindow = gWindow;
        this.build();
    }

    public CommandPrompt(GameWindow gWindow, String text, int n){
        super(text, n);
        this.gWindow = gWindow;
        this.build();
    }


    public CommandPrompt(GameWindow gWindow, String text){
        super(text);
        this.gWindow = gWindow;
        this.build();
    }

    public CommandPrompt(GameWindow gWindow, int n){
        super(n);
        this.gWindow = gWindow;
        this.build();
    }

    private void build() {
        this.addActionListener(ae -> {
            String cmd = ((JTextField) ae.getSource()).getText();
            if("quit".equals(cmd)){
                if(JOptionPane.showConfirmDialog((Component) ae.getSource(), "Do you want to save ?", "EXIT", YES_NO_OPTION) == YES_OPTION){
                //SAVE//
                }
                Toolkit.getDefaultToolkit().close();
                System.exit(0);
            }
            else if("unset weapon".equals(cmd)){
                this.gWindow.getGameEngine().getPlayer().unsetWeapon();
                this.setText("");
            }
            else if("unset protection".equals(cmd)){
                this.gWindow.getGameEngine().getPlayer().unsetProtection();
                this.setText("");
            }
            else{
                while(JOptionPane.showConfirmDialog((Component) ae.getSource(), "This command doesn't exist. Are you dumb ?", "UNKNOWN COMMAND", YES_NO_OPTION) != YES_OPTION);
                this.setText("");
            }
        });
    }

    @Override
    public void processKeyEvent(KeyEvent ke_) {
        int key = ke_.getKeyCode();
        if (key == KeyEvent.VK_LEFT && ke_.getID() == AWTEvent.KEY_TYPED){
            this.gWindow.sendMovePlayerSignal(new Point(-1, 0));
            this.gWindow.refreshMap();

        } else if (key == KeyEvent.VK_RIGHT && ke_.getID() == AWTEvent.KEY_TYPED){
            this.gWindow.sendMovePlayerSignal(new Point(1, 0));
            this.gWindow.refreshMap();

        } else if (ke_.getKeyCode() == KeyEvent.VK_UP && ke_.getID() == AWTEvent.KEY_TYPED) {
            this.gWindow.sendMovePlayerSignal(new Point(0, -1));
            this.gWindow.refreshMap();

        } else if (ke_.getKeyCode() == KeyEvent.VK_DOWN && ke_.getID() == AWTEvent.KEY_TYPED) {
            this.gWindow.sendMovePlayerSignal(new Point(0, 1));
            this.gWindow.refreshMap();

        } else{
            super.processKeyEvent(ke_);
        }
    }
}

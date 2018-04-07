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
package forrogue.game;

import charva.awt.BorderLayout;
import charva.awt.Color;
import charva.awt.Point;
import charva.awt.event.KeyEvent;
import charva.awt.event.KeyListener;
import charvax.swing.JFrame;
import charvax.swing.JList;
import charvax.swing.JPanel;
import charvax.swing.JScrollPane;
import charvax.swing.JTextField;
import charvax.swing.border.LineBorder;
import charvax.swing.border.TitledBorder;
import forrogue.character.Player;
import forrogue.item.Item;
import forrogue.item.protection.IronShield;
import forrogue.item.weapon.Sword;

import java.io.FileNotFoundException;
import java.util.Vector;

/**
 *
 * @author tama
 */

public class GameCreator extends JFrame{

    /**
     * TO IMPLEMENT
     */

    public GameCreator() {
        super("GameCreator -- TAB to switch between panels -- ENTER to select value");                

        Vector<String> gV = new Vector<>();
        gV.add("Male"); gV.add("Female");
        Form gForm = new Form(gV);
        JPanel gPanel = new JPanel();
        gPanel.setBorder(new TitledBorder("Gender"));
        gPanel.add(gForm);
        
        Vector<String> cV = new Vector<>();
        cV.add("Type1"); cV.add("Type2");
        Form cForm = new Form(cV);
        JPanel cPanel = new JPanel();
        cPanel.setBorder(new TitledBorder("Class"));
        cPanel.add(cForm);

        Vector<String> eV = new Vector<>();
        eV.add("Create"); eV.add("Exit");
        Form eForm = new Form(eV);
        
        eForm.addKeyListener(new KeyListener(){
        
            @Override
            public void keyTyped(KeyEvent ke) {
                switch(ke.getKeyCode()){
                    case KeyEvent.VK_ENTER :
                        
                        eForm.getList().processKeyEvent(ke);

                        switch(eForm.getSelected()) {

                            case "Create":
                                try {
                                    long seed = 84164654154L;
                                    Player player = new Player("Provençal Le Gaulois", "Male", "Type1", new Point(-1,-1));
                                    player.getInventory().add(new Sword());
                                    player.getInventory().add(new IronShield());
                                    GameEngine gEngine = new GameEngine(player, seed, "filename.save");
                                    GameWindow gui = new GameWindow("RogueLike", gEngine);
                                    gEngine.setGameWindow(gui);
                                } catch (FileNotFoundException e) {
                                    e.printStackTrace();
                                }
                                break;

                            case "Exit":
                                System.exit(0);
                                break;

                        }
                    break;
                }
            }

            @Override
            public void keyPressed(KeyEvent ke) {}

            @Override
            public void keyReleased(KeyEvent ke) {}
            
        });
        
        JPanel ePanel = new JPanel();
        ePanel.setBorder(new LineBorder(Color.green));
        ePanel.add(eForm);
        
        
        JTextField seedField = new JTextField("84164654154");
        JPanel sPanel = new JPanel();
        sPanel.setBorder(new TitledBorder("Seed"));
        sPanel.add(seedField);
        
        JTextField fileNameField = new JTextField("filename.save");
        JPanel fPanel = new JPanel();
        fPanel.setBorder(new TitledBorder("File name"));
        fPanel.add(fileNameField);

        JTextField playerNameField = new JTextField("Provençal Le Gaulois");
        JPanel pPanel = new JPanel();
        pPanel.setBorder(new TitledBorder("Player name"));
        pPanel.add(playerNameField);

        
        JPanel centerPanel = new JPanel();
        centerPanel.add(fPanel, BorderLayout.NORTH);
        centerPanel.add(sPanel, BorderLayout.SOUTH);
        centerPanel.add(pPanel, BorderLayout.WEST);
        
        
        this.getContentPane().add(gPanel, BorderLayout.WEST);
        this.getContentPane().add(centerPanel, BorderLayout.CENTER);
        this.getContentPane().add(cPanel, BorderLayout.EAST);
        this.getContentPane().add(ePanel, BorderLayout.SOUTH);

        this.pack();
        this.setVisible(true);
        validate();
    }


    public class Form extends JScrollPane{

        private final JList jlist;
        
        public Form(Vector<String> optionList){
            this.jlist = new JList();
            this.jlist.setListData(optionList);
            this.setViewportView(jlist);
        }
                
        public String getSelected(){
            return ((String) this.jlist.getSelectedValue());
        }
        
        public JList getList(){
            return this.jlist;
        }
    }
    
}

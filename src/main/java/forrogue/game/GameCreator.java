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
import charva.awt.Toolkit;
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

import javax.tools.Tool;
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

        //DID YOU JUST ASSUME MY GENDER ?!
        gV.add("Abimegende");
        gV.add("Adamasgende");
        gV.add("Aerogende");
        gV.add("Aesthetigende");
        gV.add("Affectugende");
        gV.add("Agende");
        gV.add("Agenderflu");
        gV.add("Alexigende");
        gV.add("Aliusgende");
        gV.add("Amaregende");
        gV.add("Ambigende");
        gV.add("Ambone");
        gV.add("Amicagende");
        gV.add("Androgyn");
        gV.add("Anesigende");
        gV.add("Angenita");
        gV.add("Anogende");
        gV.add("Anongende");
        gV.add("Antegende");
        gV.add("Anxiegende");
        gV.add("Apagende");
        gV.add("Apconsugende");
        gV.add("Astergende");
        gV.add("Astralgende");
        gV.add("Autigende");
        gV.add("Autogende");
        gV.add("Axigende");
        gV.add("Bigende");
        gV.add("Biogende");
        gV.add("Blurgende");
        gV.add("Boyflu");
        gV.add("Burstgende");
        gV.add("Caelgende");
        gV.add("Cassgende");
        gV.add("Cassflu");
        gV.add("Cavusgende");
        gV.add("Cendgende");
        gV.add("Ceteroflui");
        gV.add("Ceterogende");
        gV.add("Cisgende");
        gV.add("Cloudgende");
        gV.add("Collgende");
        gV.add("Colorgende");
        gV.add("Commogende");
        gV.add("Condigende");
        gV.add("Deliciagende");
        gV.add("Demiflui");
        gV.add("Demiflu");
        gV.add("Demigende");
        gV.add("Domgende");
        gV.add("Duragende");
        gV.add("Egogende");
        gV.add("Epicen");
        gV.add("Espigende");
        gV.add("Exgende");
        gV.add("Existigende");
        gV.add("Female");
        gV.add("Femflui");
        gV.add("Femgende");
        gV.add("Fluidflu");
        gV.add("Gemigende");
        gV.add("Genderblan");
        gV.add("Genderflo");
        gV.add("Genderflui");
        gV.add("Genderflu");
        gV.add("Genderfuz");
        gV.add("Genderpun");
        gV.add("Genderquee");
        gV.add("Genderwitche");
        gV.add("Girlflu");
        gV.add("Glassgende");
        gV.add("Glimragende");
        gV.add("Greygende");
        gV.add("Gyragende");
        gV.add("Healgende");
        gV.add("Heliogende");
        gV.add("Hemigende");
        gV.add("Horogende");
        gV.add("Hydrogende");
        gV.add("Imperigende");
        gV.add("Intergende");
        gV.add("Juxer");
        gV.add("Libragende");
        gV.add("Male");
        gV.add("Magigende");
        gV.add("Mascflui");
        gV.add("Mascgende");
        gV.add("Maveriqu");
        gV.add("Mirrorgende");
        gV.add("Molligende");
        gV.add("Multigende");
        gV.add("Nanogende");
        gV.add("Neutroi");
        gV.add("Neutra");
        gV.add("Nonbinar");
        gV.add("Omnigende");
        gV.add("Oneirogende");
        gV.add("Pangende");
        gV.add("Paragende");
        gV.add("Perigende");
        gV.add("Polygende");
        gV.add("Proxvi");
        gV.add("Quoigende");
        gV.add("Subgende");
        gV.add("Surgende");
        gV.add("Systemgende");
        gV.add("Tragende");
        gV.add("Transgende");
        gV.add("Transneutra");
        gV.add("Trigende");
        gV.add("Vapogende");
        gV.add("Venngende");
        gV.add("Verangende");
        gV.add("Vibragende");
        gV.add("Vocigende");

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
        JPanel ePanel = new JPanel();
        ePanel.setBorder(new LineBorder(null));
        ePanel.add(eForm);

        Vector<String> skV = new Vector<>();
        skV.add("Ä"); skV.add("Â");
        skV.add("Ö"); skV.add("Ô");
        skV.add("Ü"); skV.add("Û");
        skV.add("Ÿ"); skV.add("Ŷ");
        Form skForm = new Form(skV);
        JPanel skPanel = new JPanel();
        skPanel.setBorder(new TitledBorder("Skin"));
        skPanel.add(skForm);


        JTextField seedField = new JTextField("84164454154");
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


        eForm.addKeyListener(new KeyListener(){

            @Override
            public void keyTyped(KeyEvent ke) {
                switch(ke.getKeyCode()){
                    case KeyEvent.VK_ENTER :

                        eForm.getList().processKeyEvent(ke);

                        switch(eForm.getSelected()) {

                            /**
                             * TODO : Rajouter fileNameField quand la save sera ok
                             */

                            case "Create":

                                String gender = gForm.getSelected() == null ? "Male" : gForm.getSelected();
                                String classs = cForm.getSelected() == null ? "Type1" : cForm.getSelected(); // TODO : À modifier
                                char skin   = skForm.getSelected() == null ? 'Ö' : skForm.getSelected().charAt(0);

                                GameWindow gWindow = new GameWindow(
                                        "ForRogue",
                                        new Player(playerNameField.getText(), gender, classs, new Point(0,0), skin),
                                        Long.parseLong(seedField.getText())
                                );
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

        
        JPanel centerPanel = new JPanel();
        centerPanel.add(fPanel, BorderLayout.NORTH);
        centerPanel.add(sPanel, BorderLayout.SOUTH);
        centerPanel.add(pPanel, BorderLayout.WEST);
        centerPanel.add(skPanel, BorderLayout.EAST);

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

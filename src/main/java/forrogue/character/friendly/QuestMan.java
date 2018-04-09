package forrogue.character.friendly;

import forrogue.Inventory;
import forrogue.character.Character;
import forrogue.game.GameConstant;
import forrogue.item.potion.LargePotion;
import forrogue.item.quest.Gem;

import java.util.HashMap;

public class QuestMan extends Character {

    private int quest_quantity;
    private String quest_item;

    public QuestMan(int random_number){
        this.setHp(999);
        this.setMaxHp(9999);
        this.setAttack(999);
        this.setDefense(999);
        this.setSpeed(999);

        this.setInventory(new Inventory());
        this.setSkin(GameConstant.SKIN_QUESTMAN);
        this.generateQuest(Math.abs(random_number));
    }

    public void getReward(Inventory inventory){
        for(int i = 0; i<5; i++) {
            inventory.add(new LargePotion());
        }
    }

    public boolean checkPlayerGems(Inventory inventory, HashMap<String, Integer> gems){
        if(gems.get(this.quest_item) >= this.quest_quantity){
            gems.replace(this.quest_item,gems.get(this.quest_item) - this.quest_quantity);
            this.getReward(inventory);
            return true;
        } return false;
    }

    public void generateQuest(int random_number){
        this.quest_quantity = random_number%16 + 10;
        this.quest_item = Gem.values()[random_number%Gem.values().length].getColor();
    }

    public int getQuestQuantity(){
        return this.quest_quantity;
    }

    public String getQuestItem(){
        return this.quest_item;
    }

}

package forrogue.item.quest;

import forrogue.character.Character;
import forrogue.item.Item;

public enum Gem {

    WHITE_GEM("white"),
    BLACK_GEM("black"),
    BLUE_GEM("blue"),
    GREEN_GEM("green"),
    YELLOW_GEM("yellow"),
    RED_GEM("red");


    private final String color;

    Gem(String color){
        this.color = color;
    }

    public String getColor(){
        return this.color;
    }

    @Override
    public String toString(){
        return this.color;
    }
}

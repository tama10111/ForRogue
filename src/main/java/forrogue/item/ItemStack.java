package forrogue.item;

import forrogue.character.Character;

import java.io.Serializable;

public class ItemStack implements Serializable {

    Item item;
    int quantity;

    public ItemStack(Item item){
        this.item = item;
        this.quantity = 1;
    }

    public ItemStack(Item item, int n){
        this.item = item;
        this.quantity = n;
    }

    public void addOne(){
        this.quantity += 1;
    }

    public void add(int i){
        this.quantity += i;
    }

    public void removeOne(){
        this.quantity -= 1;
    }

    public void remove(int i){
        this.quantity -= i;
    }

    public void use(Character character){
        this.item.use(character);
        this.quantity -= 1;
    }

    @Override
    public String toString(){
        return String.format("[%s] %s", this.quantity, this.item.getName());
    }

    public String getItemName() {
        return this.item.getName();
    }

    public int getQuantity() {
        return this.quantity;
    }

    public Item getItem() {
        return this.item;
    }
}

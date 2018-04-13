package forrogue;

import charva.awt.Point;

public class Triplet{
    public Point point;
    public int cost;
    public double heuristique;
    public double reverse;

    public Triplet(Point point, int cost, double heuristique, int reverse){
        this.point = point;
        this.cost = cost;
        this.heuristique = heuristique;
        this.reverse = reverse;
    }

    @Override
    public String toString(){
        return String.format("%s\t%s\t%s\t%s", this.point.toString(), this.cost, this.heuristique, this.reverse);
    }

}

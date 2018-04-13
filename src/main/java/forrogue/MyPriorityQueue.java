package forrogue;

import java.util.PriorityQueue;

public class MyPriorityQueue extends PriorityQueue<Triplet> {

    public MyPriorityQueue(MyComparator comparator){
        super(comparator);
    }

    public MyPriorityQueue(){
        super();
    }

    public boolean isInQueueWithLowerCost(Triplet triplet){

        if(this.contains(triplet)){
            for(Object t : super.toArray()){
                if(triplet.point.equals(((Triplet) t).point)){
                    if(triplet.cost >= ((Triplet) t).cost) return true;
                }
            }
        } return false;
    }
}

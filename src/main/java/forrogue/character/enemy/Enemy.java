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
package forrogue.character.enemy;

import charva.awt.Point;

import forrogue.GameObject;
import forrogue.MyComparator;
import forrogue.MyPriorityQueue;
import forrogue.Triplet;
import forrogue.character.Character;
import forrogue.character.Player;
import forrogue.game.GameConstant;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Stack;



public abstract class Enemy extends Character {

    public Point pathFinder(Point player, Object[][] matrix) {

        if(this.getPerception() < Math.sqrt(Math.pow(this.getPosition().x - player.x, 2) + Math.pow(this.getPosition().y - player.y, 2))) return new Point(0,0);

        MyPriorityQueue open = new MyPriorityQueue(new MyComparator());
        MyPriorityQueue closed = new MyPriorityQueue(new MyComparator());
        Point[] move = { new Point(1,0), new Point(-1,0), new Point(0,1), new Point(0,-1) };

        Triplet start = new Triplet(this.getPosition(), 0, 0, 0);
        Triplet u, v, tmp;
        Triplet[][] t_matrix;

        t_matrix = new Triplet[matrix.length][];

        Stack<Point> pile = new Stack<>();

        int i = 0, j;

        for(Object[] line : matrix){
            t_matrix[i] = new Triplet[line.length];
            for(j = 0; j<t_matrix[i].length; j++){
                t_matrix[i][j] = new Triplet(new Point(j,i), -1, 0, 0);
            } i++;
        }

        double min_reverse;

        open.add(start);

        while (!open.isEmpty()){
            u = open.poll();

            for(Point dir : move){

                v = t_matrix[u.point.y+dir.y][u.point.x+dir.x];

                if(!(closed.isInQueueWithLowerCost(v) || open.isInQueueWithLowerCost(v))){
                    if(!(matrix[v.point.y][v.point.x] instanceof GameObject)){
                        if(((char) matrix[v.point.y][v.point.x]) == GameConstant.SKIN_VOID){
                            v.cost = u.cost + 1;
                            v.heuristique = v.cost + Math.sqrt(Math.pow(v.point.x - player.x, 2) + Math.pow(v.point.y - player.y, 2));
                            v.reverse = v.cost + Math.sqrt(Math.pow(v.point.x - this.getPosition().x, 2) + Math.pow(v.point.y - this.getPosition().y, 2));
                            open.add(v);
                            t_matrix[u.point.y+dir.y][u.point.x+dir.x].cost += 1;
                        }
                    } else if(matrix[v.point.y][v.point.x] instanceof Player){
                        v.cost = u.cost + 1;
                        v.heuristique = v.cost + Math.sqrt(Math.pow(v.point.x - player.x, 2) + Math.pow(v.point.y - player.y, 2));
                        v.reverse = v.cost + Math.sqrt(Math.pow(v.point.x - this.getPosition().x, 2) + Math.pow(v.point.y - this.getPosition().y, 2));
                        open.add(v);
                        t_matrix[u.point.y+dir.y][u.point.x+dir.x].cost += 1;
                    }
                }
            } closed.add(u);

            if (u.point.equals(player)){
                pile.push(new Point(0,0));
                min_reverse = Double.POSITIVE_INFINITY;
                for(Point dir : move){
                    for(Object t : closed.toArray()){
                        if(((Triplet) t).reverse + ((Triplet) t).cost + ((Triplet) t).heuristique < min_reverse
                                && ((Triplet) t).cost != 0
                                && ((Triplet) t).point.x - dir.x == start.point.x
                                && ((Triplet) t).point.y - dir.y == start.point.y){
                            min_reverse = ((Triplet) t).reverse + ((Triplet) t).cost + ((Triplet) t).heuristique;
                            pile.push(dir);
                        }
                    }
                } return pile.pop();
            }
        } return new Point(0,0);
    }

    private void writeObject(ObjectOutputStream oos)throws IOException {


        oos.defaultWriteObject();

        oos.writeInt(position.x);
        oos.writeInt(position.y);




    }

    private void readObject(ObjectInputStream ois)throws ClassNotFoundException,IOException{

        int a,b;
        ois.defaultReadObject();
        a=ois.readInt();
        b=ois.readInt();
        position=new Point(a,b);



    }



}
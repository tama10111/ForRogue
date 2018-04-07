package forrogue.map;

import charva.awt.Dimension;
import java.util.ArrayList;
import java.util.Scanner;

public class Hub {

    Dimension dimension;
    char[][] matrix;

    public Hub(){
        ClassLoader classLoader = getClass().getClassLoader();
        Scanner f = new Scanner(classLoader.getResource("hub.map").getFile());
        this.setMatrix(f);
    }

    private void setMatrix(Scanner f){
        ArrayList<String> lines = new ArrayList();
        int max = 0, i = 0, j;
        while(f.hasNextLine()) {
            lines.add(f.nextLine());
            if (lines.get(i).length() > max) max = lines.get(i).length();
            i++;
        }

        this.dimension = new Dimension(max, lines.size());
        this.matrix = new char[lines.size()][max];

        i = j = 0;
        for(String str : lines){
            for(char c : str.toCharArray()){
                this.matrix[i][j] = c;
                j++;
            } i++; j = 0;
        }
    }

    public char[][] getMatrix() {
        return this.matrix;
    }
}

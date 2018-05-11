package forrogue;


import forrogue.game.GameEngine;

import java.io.*;


public class SerializationDriver {
    public GameEngine g;
    public void Serializer(GameEngine ge)

    {
        try{
            File f= new File(ge.getSaveFileName());
            if(f.exists()) {
                FileOutputStream fos = new FileOutputStream(ge.getSaveFileName());
                ObjectOutputStream oos = new ObjectOutputStream(fos);
                oos.writeObject(ge);
                oos.close();
            }
            else{
                f.createNewFile();
                FileOutputStream fos= new FileOutputStream(ge.getSaveFileName());
                ObjectOutputStream oos =new ObjectOutputStream(fos);
                oos.writeObject(ge);
                oos.close();
            }

        }

        catch(IOException e) {

            e.printStackTrace();
        }



    }


    public void Deserialize(String file_name)

    {

        try{
            FileInputStream fis= new FileInputStream(file_name);
            ObjectInputStream ois=new ObjectInputStream(fis);
            this.g=(GameEngine) ois.readObject();
            ois.close();

        }

        catch(IOException e) {

            e.printStackTrace();
        }

        catch(ClassNotFoundException e){

            e.printStackTrace();

        }


    }

}


package io;

import java.io.*;
import java.util.List;

public class Write<T> implements Serializable {
    public void writeToSaveFile(List<T> exportList, String pathName){
        File saveFile = new File(pathName);
        try(FileOutputStream fileOutputStream = new FileOutputStream(saveFile);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream) ){
            objectOutputStream.writeObject(exportList);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}

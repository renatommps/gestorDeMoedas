/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestordemoedas;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Rafael
 */
public class FileManager {
    
    private static FileManager instance;
    
    public static FileManager getInstance() {
        if (instance == null) {
            instance = new FileManager();
        }
        return instance;
    }
    
    private FileManager() {
        
    }
    
    public void writeObject(Object obj, String filename) {
        try {
            FileOutputStream file = new FileOutputStream(filename);
            ObjectOutputStream out = new ObjectOutputStream(file);
            out.writeObject(obj);
            out.close();
            file.close();
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    
    public <T extends Identificable> T readObject(String id, String filename) {
        try {
            FileInputStream file = new FileInputStream(filename);
            ObjectInputStream in = new ObjectInputStream(file);
            try {
                while (true) {
                    T obj = (T)in.readObject();
                    if (obj.getID().equalsIgnoreCase(id)) {
                        return obj;
                    }
                }
            } catch (EOFException eof) {
                //End of file. Break the loop.
            } catch (ClassNotFoundException ex) {
                ex.printStackTrace();
            }
            in.close();
            file.close();
        } catch (FileNotFoundException ex) {
            //Expected on first read
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return null;
    }
    
    public List<Object> readAllObjects(String filename) {
        List<Object> objs = new ArrayList<>();
        try {
            FileInputStream file = new FileInputStream(filename);
            ObjectInputStream in = new ObjectInputStream(file);
            try {
                while (true) {
                    objs.add(in.readObject());
                }
            } catch (EOFException eof) {
                //End of file. Break the loop.
            } catch (ClassNotFoundException ex) {
                ex.printStackTrace();
            }
            in.close();
            file.close();
        } catch (FileNotFoundException ex) {
            //Expected on first read
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return objs;
    }
    
}

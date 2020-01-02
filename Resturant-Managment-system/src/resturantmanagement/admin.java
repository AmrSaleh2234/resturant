/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package resturantmanagement;

import files.filemanagement;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;

public class admin extends Person implements Serializable {

    private final String filePath = "admin.bin";
    private ArrayList<admin> admins = new ArrayList<>();
    filemanagement obj = new filemanagement();
    private final int id=0;
    public admin() {
    }

    
   

    public admin(String FName, String LName, String userName, String password) {
        super(FName, LName, userName, password, 2);
    }

    private void loadFromFile() {
        try {
            admins = (ArrayList< admin>) (Object) obj.read(filePath);

        } catch (Exception e) {
            System.out.println(e);
        }

    }

    private boolean commitFile() {
        return obj.write(filePath, admins);
    }

    public int getId() {
        return id;
    }

    private int getIndex(int id) {
        int len = admins.size();
        for (int i = 0; i < len; i++) {
            if (admins.get(i).getId() == id) {
                return i;
            }
        }

        return -1;
    }

    public boolean update() {
        loadFromFile();
        int index = getIndex(0);
        if (index != -1) {
            admins.set(index, this);
            return commitFile();
        } else {
            return false;
        }
    }

     public boolean add() {

        loadFromFile();
        admins.add(this);
        return commitFile();
    }
    @Override
    public int login(String userName, String passWord) {
        loadFromFile();
        for (admin m : admins) {
            if (m.getUserName().equals(userName) && m.getPassword().equals(passWord)) {
                return m.getRole();
            }
        }
        return 0;

    }
     public ArrayList<admin> list()
     {
         loadFromFile();
         return admins;
     }

}

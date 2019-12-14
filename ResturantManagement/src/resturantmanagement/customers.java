/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package resturantmanagement;

import java.io.Serializable;
import java.util.ArrayList;

public class customers implements Serializable, SetData {

    protected String fname;
    protected String lname;
    private int id;
    private final String File_Path = "Customer.bin";
    public ArrayList<customers> m = new ArrayList<customers>();
    private filemanagement obj = new filemanagement();

    public customers() {
    }

    public customers(String FName, String LName) {
        Load_From_file();
        this.fname = FName;
        this.lname = LName;
        if (m.size() == 0) {
            setId(1);
        } else {
            setId(m.get(m.size() - 1).getId() + 1);
        }
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean Commite_File() {
        return obj.write(File_Path, m);
    }

    public void Load_From_file() {
        try {
            m = (ArrayList<customers>) (Object) obj.read(File_Path);
        } catch (Exception e) {
            System.out.println(e);
        }

    }

    public boolean exsistCustomer(int id) {
        Load_From_file();
        int index = getIndex(id);
        return index != -1;
    }

    @Override
    public ArrayList<Object> list() {

        Load_From_file();

        return (ArrayList<Object>) (Object) m;
    }

    public ArrayList<Order> getProfile(int id) {
        Order o = new Order();
        return o.customerProfile(id);
    }

    @Override
    public customers search(int id) {
        customers l = new customers();
        Load_From_file();
        int index = getIndex(id);
        if (index != -1) {
            return m.get(index);
        } else {
            return l;
        }
    }

    @Override
    public boolean update(int id) {
        Load_From_file();
        int index = getIndex(id);
        if (index != -1) {
            this.setId(id);
            m.set(index, this);
            return Commite_File();
        } else {
            return false;
        }

    }

    @Override
    public boolean delete(int Id) {
        Load_From_file();
        int index = getIndex(Id);
        if (index != -1) {
            m.remove(index);

            return Commite_File();
        } else {
            return false;
        }
    }

    @Override
    public boolean add() {

        Load_From_file();
        m.add(this);
        return Commite_File();
    }

    public int getIndex(int Id) {
        int len = m.size();
        for (int i = 0; i < len; i++) {
            if (m.get(i).id == Id) {
                return i;
            }
        }

        return -1;
    }
}

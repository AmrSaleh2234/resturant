/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package resturantmanagement;

import files.filemanagement;
import java.io.Serializable;
import java.util.ArrayList;

import java.util.Collections; 
/**
 *
 * @author eslam
 */
public class Gifs implements Serializable,Comparable<Gifs> {

    private String gift;
    private int payment;
    private filemanagement obj = new filemanagement();
    ArrayList<Gifs> e = new ArrayList<Gifs>();
    private String filePath = "Gifts.bin";

    public Gifs() {
    }

    public Gifs(String gift, int payment) {
        this.gift = gift;
        this.payment = payment;
    }

    public String getGift() {
        return gift;
    }

    public void setGift(String gift) {
        this.gift = gift;
    }

    public int getPayment() {
        return payment;
    }

    public void setPayment(int payment) {
        this.payment = payment;
    }

    private void loadFromFile() {
        try {
            e = (ArrayList<Gifs>) (Object) obj.read(filePath);

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

    }

    private boolean commitFile() {
        return obj.write(filePath, e);
    }

    public boolean add() {

        loadFromFile();
        e.add(this);
        return commitFile();
    }

    public boolean update() {
        loadFromFile();
        int index = getIndex(this.getPayment());
        if (index != -1) {
            e.set(index, this);
            return commitFile();
        } else {
            return false;
        }
    }

    public boolean delete(int payment) {
        loadFromFile();
        int index = getIndex(payment);
        if (index != -1) {
            e.remove(index);

            return commitFile();
        } else {
            return false;
        }
    }

    private int getIndex(int payment) {
        int len = e.size();
        for (int i = 0; i < len; i++) {
            if (e.get(i).getPayment() == payment) {
                return i;
            }
        }

        return -1;
    }

    public ArrayList<Object> list() {
        loadFromFile();
        return (ArrayList<Object>) (Object) e;
    }

    public Gifs search(int payment) {
        Gifs temp = new Gifs();
        loadFromFile();
        int index = getIndex(payment);
        if (index != -1) {
            return e.get(index);
        } else {
            return temp;
        }

    }
    @Override
  public int compareTo(Gifs pay) {          
    return (this.getPayment()< pay.getPayment()? -1 : 
            (this.getPayment() == pay.getPayment()? 0 : 1));  
  } 
    public void customerGift(double payment) {
      loadFromFile();
     
      Collections.sort(e,Collections.reverseOrder());
      for(Gifs l1:e)
      {
          
          if(l1.getPayment()<=payment)
          {
              Notification  o=new Notification(l1.getGift());
              o.add();
              break;
          }
      }
    }
}

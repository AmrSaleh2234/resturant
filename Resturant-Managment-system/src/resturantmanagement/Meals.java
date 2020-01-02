/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package resturantmanagement;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import files.filemanagement;
import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author eslam
 */
public class Meals implements Serializable {
    
    private final String filePath = "Meals.bin";
    
    private String productName;
    private double Cost;
    private double Offer;
    public ArrayList<Meals> m = new ArrayList<Meals>();
    private filemanagement obj = new filemanagement();

    public Meals() {

    }

    public Meals( String product_name, double cost) {
     
       this. productName = product_name;
        this.Cost = cost;
        this.Offer = 0;
    }

    private void loadFromFile() {
        try {
            m = (ArrayList<Meals>) (Object) obj.read(filePath);
        } catch (Exception e) {
            System.out.println(e);
        }

    }

    private boolean commiteFile() {
        return obj.write(filePath, m);
    }

    public Object search(String productName) {
        loadFromFile();
        Meals temp =new Meals();
        int index = getIndex(productName);
        if (index != -1) {
            return m.get(index);
        } else {
            return temp;
        }
    }

    //Professors.set(index, x);
  
    public boolean update() {
        loadFromFile();
        int index = getIndex(this.get_Product_Name());
        if (index != -1 ) {
            m.set(index, this);
            return commiteFile();
        } else {
            return false;
        }

    }
//    public boolean  makeOffer(double offer)      
//    {
//        this.setOffer(offer);=offer;
//        return this.update();
//    }
    public void makeOffer(String name, double discount) {
        Meals x = new Meals();
        loadFromFile();
        int index = getIndex(name);
        x.setOffer(discount);
        x.setProductName(name);
        x.setCost(m.get(index).getCost());
         m.set(index, x);
        commiteFile();
    }
    public double calckOffer(String productName)
    
        {
            loadFromFile();
                int index=getIndex(productName);
              double d= ( m.get(index).getCost()-(m.get(index).getCost()*m.get(index).getOffer()));
               return  d;
        }
    public boolean delete(String productName) {
        loadFromFile();
        int index = getIndex(productName);
        if (index != -1) {
            m.remove(index);

            return commiteFile();
        } else {
            return false;
        }
    }

   
    public boolean add() {

        loadFromFile();
        m.add(this);
        return commiteFile();
    }

    private int getIndex(String productName) {
        int len = m.size();
        for (int i = 0; i < len; i++) {
            if (m.get(i).productName.equalsIgnoreCase(productName)) {
                return i;
            }
        }

        return -1;
    }

    public String get_Product_Name() {
        return this.productName;
    }

    public double getCost() {
        return this.Cost;
    }

    public double getOffer() {
        return this.Offer;
    }
    
    

    public void get_Product_Name(String product_name) {
        productName = product_name;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public void setCost(double cost) {
        Cost = cost;
    }

    public void setOffer(double offer) {
        Offer = offer;
    }
    
    public ArrayList<Object>list()
    {
        loadFromFile();
        return (ArrayList<Object>)(Object)m;
    }

}

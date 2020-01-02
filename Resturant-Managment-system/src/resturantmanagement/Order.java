/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package resturantmanagement;


import files.filemanagement;
import java.io.Serializable;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class Order  implements Serializable{
    
    private double price;
    private ArrayList<String> Order;
    private final String filePath = "Order.bin";
    private int customerId;
    private int employeeId;
    public ArrayList<Order> m = new ArrayList<Order>();
    
    private filemanagement obj = new filemanagement();

    public Order() {
    }

    public ArrayList<Order> getM() {
        return m;
    }
    
    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }
    
    public Order( ArrayList<String> Order, int CustomerId, int EmployeeId) {
      
         double payments = 0;
        customerId = CustomerId; 
        this.employeeId = EmployeeId;
        setOrder(Order);
        for (String o: Order) {
           
            payments += new Meals().calckOffer(o);
        }
        setPrice(payments);
    }

    

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public ArrayList<String> getOrder() {
        return Order;
    }

    public void setOrder(ArrayList<String> Order) {
        this.Order = Order;
    }

    
    public int getCustomerId() {
        return customerId;
    }

    public boolean setCustomerId(int customerId) {
        
            if(new customers().exsistCustomer(customerId))
            {
                return true;
            }
            else
            {
                JOptionPane.showMessageDialog(null, "add this customer first");
                return false;
            }
        
    }
    
    private void loadFromFile()
    {
        try{
            m = (ArrayList < Order >)(Object) obj.read(filePath);

        }
        catch(Exception e)
        {
            System.out.println(e);
        }

    }

    private boolean commitFile()
    {
        return obj.write(filePath, m);
    }
    public  boolean  add()
    {
        if(setCustomerId(customerId))
        {
            loadFromFile();
            m.add(this);
            return commitFile();
        }return false;
    }
private int getIndex(int Idcustomer)
    {
        int len = m.size();
        for(int i = len-1; i >= 0; i--)
        {
            if(m.get(i).customerId == Idcustomer) return i;
        }
        
            return -1;
        

       
    }
    public Object getLastOrder(int Idustomer)
    {
        loadFromFile();
        int index= getIndex(Idustomer);
        if(index != -1)return m.get(index);
        else return null;
        
    }
    public double allPayments(int Idcustomer)
    {
        loadFromFile();
        double sum=0;
        for (Order m1 : m) {
            if (m1.getCustomerId() == Idcustomer) {
                sum += m1.price;
            }
        }
        return sum;
    }
    
    public ArrayList<Order> customerProfile (int idcustomer)
    {
        loadFromFile();
        ArrayList<Order> k=new ArrayList<Order>();
        for(Order m1:m)
        {
            if(m1.getCustomerId()==idcustomer)
            {
                k.add(m1);
            }
        }
        
            return k;
        
      
    }
    public boolean deleteOrder (int Id)
    {
        loadFromFile();
        int index =getIndex(Id);
        if(index!=-1)
        m.remove(index);
        else
            return false;
        return commitFile();
    }
    public ArrayList<Order> report(int idEmployee)
    {
        loadFromFile();
        ArrayList<Order> l=new ArrayList<Order>();
        for(Order m1:m)
        {
            if(m1.getEmployeeId()==idEmployee)
            {
                l.add(m1);
            }
        }
        return l;
        
    }
    
    
}
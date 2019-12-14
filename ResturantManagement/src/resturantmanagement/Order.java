package resturantmanagement;

import java.io.Serializable;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class Order implements Serializable {

    private double price;
    private ArrayList<String> Order;
    private final String filePath = "Order.bin";
    private int customerId;
    public ArrayList<Order> m = new ArrayList<Order>();

    private filemanagement obj = new filemanagement();

    public Order() {
    }

    public Order(ArrayList<String> Order, int Id) {

        double payments = 0;
        setCustomerId(Id);
        setOrder(Order);
        for (String o : Order) {

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

    public void setCustomerId(int customerId) {

        if (new customers().exsistCustomer(customerId)) {
            this.customerId = customerId;
        } else {
            JOptionPane.showMessageDialog(null, "add this customer first");
        }

    }

    private void loadFromFile() {
        try {
            m = (ArrayList< Order>) (Object) obj.read(filePath);

        } catch (Exception e) {
            System.out.println(e);
        }

    }

    private boolean commitFile() {
        return obj.write(filePath, m);
    }

    public boolean add() {
        loadFromFile();
        m.add(this);
        return commitFile();
    }

    private int getIndex(int Idcustomer) {
        int len = m.size();
        int k = -1;
        for (int i = 0; i < len; i++) {
            if (m.get(i).customerId == Idcustomer) {
                k = i;
            }
        }

        return k;

    }

    public Order getLastOrder(int Idustomer) {
        loadFromFile();
        int index = getIndex(Idustomer);
        return m.get(index);

    }

    public double allPayments(int Idcustomer) {
        loadFromFile();
        double sum = 0;
        for (Order m1 : m) {
            if (m1.getCustomerId() == Idcustomer) {
                sum += m1.price;
            }
        }
        return sum;
    }

    public ArrayList<Order> customerProfile(int idcustomer) {
        loadFromFile();
        ArrayList<Order> k = new ArrayList<Order>();
        for (Order m1 : m) {
            if (m1.getCustomerId() == idcustomer) {
                k.add(m1);
            }
        }

        return k;

    }

    public boolean deleteOrder(int Id) {
        loadFromFile();
        int index = getIndex(Id);
        if (index != -1) {
            m.remove(index);
        } else {
            return false;
        }
        return commitFile();
    }

}

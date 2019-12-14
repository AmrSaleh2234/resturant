package resturantmanagement;

import java.util.ArrayList;

/**
 *
 * @author Amr
 */
public class ResturantManagement {

    public static void main(String[] args) {
        ArrayList<String> k = new ArrayList<>();
        k.add("pizza");
        Order o = new Order(k, 2);
        o.add();
//        ArrayList<Order>l=(ArrayList<Order>)(Object)o.customerProfile(1);
//        for(Order l1:l)
//        {
//            System.out.println(l1.getOrder());
//        }

    }

}

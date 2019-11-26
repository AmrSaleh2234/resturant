
package text2;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Text2 implements Serializable  {
    public static void main(String[] args) {
//        student m=new student(20180402,4.44);
//         boolean cont = true;
//         ArrayList<student> j=new ArrayList<student>();
//         ArrayList<student> ii=new ArrayList<student>();
//         ii.add(m);
//        ObjectOutputStream file;
//        try {
//            file = new   ObjectOutputStream(new  FileOutputStream ("student.bin",true));
//            file.writeObject(ii);
//            file.flush();
//            file.close();
//        } catch (Exception ex) {
//            System.out.println(ex);
//        }
//        ObjectInputStream k;
//        Object x=null;
//        try{
//            k = new ObjectInputStream(new FileInputStream("student.bin"));  
//             x=(ArrayList)k.readObject();
//             k.close();
//         }
//        catch(Exception e)
//        {
//            System.out.println(e);
//        }
//      
//   j=   (ArrayList<student>) x;
//        for(int i=0;i<j.size();i++)
//        {
//            System.out.println(j.get(i).getId()+" "+j.get(i).getGPA());
//        }
       student c=new student(20180402, 3.4);
        student l=new student(2018042, 44.2);
        c.add();
        l.add();
        ArrayList<student>k=c.list();
       for(student b:k)
       {
           System.out.println(b.getId()+" "+b.getGPA());
       }
//       filemanagement f=new filemanagement();
//       f.write("student.bin", l);
//        ArrayList<student> m= (ArrayList<student>) f.read("student.bin");
//        System.out.println(m.size());
//     
       
      
       
       
  
    
    }

   
   
    
}

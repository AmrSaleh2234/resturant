/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package files;


//*package resturant.management.system;
import static java.awt.PageAttributes.MediaType.A;
import java.io.File;
import java.io.*;
import java.nio.file.FileSystemLoopException;
import java.util.ArrayList;

public class filemanagement implements Serializable{
    
    public boolean write(String filepath , Object data)
    {
        ObjectOutputStream file;
        try{
        file=new ObjectOutputStream(new FileOutputStream(filepath));
        file.writeObject(data);
        file.flush();
        file.close();
        return true;
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        return false;
    }
public ArrayList<Object> read(String filepath) {
   
       ArrayList x = new ArrayList() ;
        
         
     ObjectInputStream file;
     try{
         file=new ObjectInputStream(new FileInputStream(filepath));
        x =(ArrayList) file.readObject();
        file.close();
         
     }
     
      catch(Exception e)
              {
              System.out.println(e);
              }
        return (ArrayList<Object>)(Object) x;
         
        
       
         
}
}
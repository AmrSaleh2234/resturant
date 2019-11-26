
package text2;
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
   
       ArrayList<student> x = new ArrayList<student>() ;
        
         
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


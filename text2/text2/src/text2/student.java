
package text2;

import java.io.Serializable;
import java.util.ArrayList;
import org.omg.CORBA.PUBLIC_MEMBER;


public class student implements Serializable{
    private int id;
    private double GPA;
   
    private final String  fileName="student.bin";
    public static ArrayList<student> Students;
    filemanagement f=new filemanagement();
    public student ()
    {
       
    }
    public student(int id, double GPA) {
        this.id = id;
        this.GPA = GPA;
       
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getGPA() {
        return GPA;
    }

    public void setGPA(double GPA) {
        this.GPA = GPA;
    }
    private void loadFromFile()
    {
        try{
        Students =  (ArrayList < student >)(Object) f.read(fileName);
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }
    private boolean commitFile()
    {
         return f.write(fileName,Students);
         
    }
    public  boolean  add ()
    {
       loadFromFile();
       Students.add(this);
       return commitFile();
        
    }
    private int getIndex (int id)
    {
        for(int i=0;i<Students.size();i++)
            if(Students.get(i).getId() == id)
                return i;
        return -1;
            
    }
    public  boolean  update ()
    {
        loadFromFile();
       int index=getIndex(this.id);
       if(index!=-1){
       Students.set(index,this);
        return  commitFile();
       }
       return false;
       
    }
    public student search(int id)
    {
           loadFromFile();
           student temp =new student();
           int index =getIndex(id);
           if(index!=-1)
           {
               System.out.println("the student is :");
               return Students.get(index);
           }
           return temp;
    }
    public ArrayList<student> list()
    {
        loadFromFile();
        return Students;
    }
    public boolean  delete(int id)
    {
        loadFromFile();
        int index=getIndex(id);
        if(index!=-1){
        Students.remove(index);
        return commitFile();
        }
        else 
        return false;    
    }
    
   
    
    
    
}


package text2;

import java.io.Serializable;


public class admin implements Serializable {
    public void addstudent (int id,double GPA)
    {
        student s=new student(id, GPA);
        //s.adds();
    }
    public void updatetudent (int id,double GPA)
    {
        student s=new student(id,GPA);
        s.update();
    }
    public void delatestudent (int id)
    {
        student s=new student();
        s.delete(id);
    }
}

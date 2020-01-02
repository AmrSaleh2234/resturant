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
 * @author elnopy
 */
public class Notification implements Serializable{
    
    private String notification;
    private boolean flag;
    private  final String filepath="Notification.bin";
    public filemanagement m=new filemanagement();
    private  ArrayList<Notification>notifications=new ArrayList<Notification>();

    public Notification() {
    }

    public Notification(String notification) {
        this.notification = notification;
        this.flag = false;
    }

    public String getNotification() {
        return notification;
    }

    public void setNotification(String notification) {
        this.notification = notification;
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

   
       private void loadFromFile()//This fun get all Data  from file and put it in ArrayList
    {
        try{
           notifications = (ArrayList <Notification >)(Object) m.read(filepath);          
        }
        catch(Exception e)
        {
            System.out.println(e);
        }

    }

    private boolean commitFile()//This fun get all data in ArrayList and set it in File
    {
        return m.write(filepath, notifications);
    }
    public boolean add()//This fun use loadFromFile and add naw date in array thin use commitFile to save changes
    {
        loadFromFile();
       notifications.add(this);
       return  commitFile();
    }
     public ArrayList<Notification> read()//This fun use loadFromFile and check if notification readed or not if not set flag =1 and return array have date that have not readed yet
    {
        ArrayList<Notification>l=new ArrayList<>();
        loadFromFile();
      for(int i=0;i<notifications.size();i++)
      {
          if(notifications.get(i).flag==false)
          {
              l.add(notifications.get(i));
              notifications.get(i).setFlag(true);
             notifications.set(i,notifications.get(i)) ;
          }
      }
      commitFile();
       return l;
       
    }
}

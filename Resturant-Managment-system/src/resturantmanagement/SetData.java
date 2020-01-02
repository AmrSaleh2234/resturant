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


import java.util.ArrayList;

/**
 *
 * @author elnopy
 */
public interface SetData {
    public boolean add();
    public boolean delete(int id);
    public boolean update(int id);
    public Object search(int id);
    public ArrayList<Object> list();    
    
    
}

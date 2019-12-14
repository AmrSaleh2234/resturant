package resturantmanagement;

import java.util.ArrayList;

public interface SetData {

    public boolean add();

    public boolean delete(int id);

    public boolean update(int id);

    public Object search(int id);

    public ArrayList<Object> list();

}

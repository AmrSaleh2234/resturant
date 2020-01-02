package resturantmanagement;

import files.filemanagement;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

public class Employee extends Person implements Serializable, SetData {
    
    private final String File_Path = "Employee.bin";
    private ArrayList<Employee> e = new ArrayList<>();
    filemanagement obj = new filemanagement();
    private int salary;
    private int id;

    public Employee() {

    }

    public Employee(String FName, String LName, String userName, String password) {
        super(FName, LName, userName, password, 1);
        loadFromFile();
        if (e.isEmpty()) {
            setId(1);
        } else {
            setId(e.get(e.size() - 1).getId() + 1);
        }

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    @Override
    public Employee search(int id) {
        Employee temp = new Employee();
        loadFromFile();
        int index = getIndex(id);
        if (index != -1) {
            return e.get(index);
        } else {
            return temp;
        }
    }

    private void loadFromFile() {
        try {
            e = (ArrayList< Employee>) (Object) obj.read(File_Path);

        } catch (Exception e) {
            System.out.println(e);
        }

    }

    private boolean commitFile() {
        return obj.write(File_Path, e);
    }

    @Override
    public boolean update(int id) {
        loadFromFile();
        int index = getIndex(id);
        if (index != -1) {
            this.setId(id);
            e.set(index, this);
            return commitFile();
        } else {
            return false;
        }
    }

    @Override
    public boolean delete(int id) {
        loadFromFile();
        int index = getIndex(id);
        if (index != -1) {
            e.remove(index);

            return commitFile();
        } else {
            return false;
        }
    }

    @Override
    public boolean add() {

        loadFromFile();
        e.add(this);
        return commitFile();
    }

    private int getIndex(int id) {
        int len = e.size();
        for (int i = 0; i < len; i++) {
            if (e.get(i).getId() == id) {
                return i;
            }
        }

        return -1;
    }

    @Override
    public ArrayList<Object> list() {
        loadFromFile();
        return (ArrayList<Object>) (Object) e;
    }

    @Override
    public int login(String userName, String passWord) {
        loadFromFile();
        for (Employee m : e) {
            if (m.getUserName().equals(userName) && m.getPassword().equals(passWord)) {
                return m.getId();
            }
        }
        return -1;
    }

}

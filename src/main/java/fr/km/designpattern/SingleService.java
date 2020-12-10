package fr.km.designpattern;

/**
 * best way to create Singleton pattern is with enum class
 */
public class SingleService {

    public static void main(String[] args) {
        MyService instance = MyService.getInstance();
        instance.save(); // print "save hello world"
    }
}

/**
 * Singleton exemple 1
 */
class EmployeeService{
    private static  EmployeeService instance = new EmployeeService();

    private EmployeeService() {
    }

    public static EmployeeService getInstance(){
        return instance;
    }
    // others methods
    //...
}

/**
 * Singleton exemple 2
 * This is the best way to create a singleton pattern then exemple 1,
 * because it's lazy creation
 */

enum MyService{
    INSTANCE;

    private MyService() {
    }
    public static MyService getInstance(){
        return INSTANCE;
    }

    public void save(){
        System.out.println("save hello world");
    }

}
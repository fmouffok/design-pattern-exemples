package fr.km.designpattern.singleton;

/**
 * a thread-safe  and lazy way to create singleton
 * best way to create Singleton pattern is with enum class
 *
 */
public class SingleService {

    public static void main(String[] args) {
        MyService instance = MyService.INSTANCE;;
        instance.save(); // print "save hello world"

    }
}

/**
 * it's lazy creation and thread-safe
 */
enum MyService{
    INSTANCE;

    private MyService() {
    }

    public void save(){
        System.out.println("save hello world");
    }

}
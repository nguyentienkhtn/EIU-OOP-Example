import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

public class Demo {
    public static void main(String[] args) {
        Student a = new Student("a", "a", 10.5);
        Student b = new Student("b", "b", 10.4);
        
        Map<String,Student> students = new TreeMap();
        students.put(b.getId(), b);
        students.put(a.getId(), a);

        Iterator iterator = students.keySet().iterator();
        while (iterator.hasNext()) {
           System.out.println(students.get(iterator.next())); 
        }
        
        
    }
}

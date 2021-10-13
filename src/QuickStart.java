import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class QuickStart {
    public static void main(String[] args) {
        List<String> list = new ArrayList<> ();
        Map<String, Integer> map = new HashMap<>();
        System.err.println("ok");

    }

    private static void mapUsage() {
        Map<String, Integer> map = new HashMap<>();
        map.put("Apples", 3);
        map.put("Oranges", 2);
        map.put("Apples", map.get("Apples")+ 4);
        System.out.println(map.get("Apples"));
    }

    private static void exceptionControllers() {
        try {
            System.out.println("A");
            badMethod();
            System.out.println("B");
        } catch (Exception e) {
            System.out.println("C");
        } finally {
            System.out.println("D");
        }
    }

    private static void badMethod() {
        throw new Error();
    }

    private static void compareLists() {
        String[] array = new String[] { "A", "B", "C" };
        List<String> list1 = Arrays.asList(array);
        List<String> list2 = new ArrayList<>(Arrays.asList(array));
        List<String> list3 = new ArrayList<>(Arrays.asList("A", new String("B"),  "C"));
        System.out.println(list1.equals(list2));
        System.out.println(list1.equals(list3));
    }

    private static void listSortedArray() {
        String[] array = { "abc", "2", "10", "0" };
        List<String> list = Arrays.asList(array);
        Collections.sort(list);
        System.out.println(Arrays.toString(array));
    } 
}
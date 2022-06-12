import java.util.NoSuchElementException;

public class TestHashTable {

    /**
     * Test put() and get() methods of HashTableMap class and whether HashTableMap can handle hash collisions.
     * 
     * @return
     */
    public static boolean test1() { 
        HashTableMap<Long, String> test = new HashTableMap<Long, String>();
        test.put(6089366467L, "Jared J Seeber");
        test.put(6086693266L, "Billy V Buckner");
        test.put(6085512037L, "Nancy K Hopkins");
        return test.get(6089366467L).equals("Jared J Seeber") && test.get(6086693266L).equals("Billy V Buckner") && test.get(6085512037L).equals("Nancy K Hopkins");
    }

    /**
     * Test remove() method.
     * 
     * @return
     */
    public static boolean test2() { 
        HashTableMap<Long, String> test = new HashTableMap<Long, String>();
        test.put(6089366467L, "Jared J Seeber");
        test.put(6086693266L, "Billy V Buckner");
        test.put(6085512037L, "Nancy K Hopkins");
        if (test.remove(6089366467L).equals("Jared J Seeber")) {
            try {
                test.get(6089366467L);
            } catch (NoSuchElementException e) {
                if (test.get(6086693266L).equals("Billy V Buckner")) return true;
            }
        }
        return false;
    }

    /**
     * Test whether HashTableMap can grow its capacity when its load capacity becomes greater than or equal to 80%.
     * 
     * @return
     */
    public static boolean test3() { 
        HashTableMap<Integer, String> test = new HashTableMap<Integer, String>(5);
        for (int i=0; i<20; i++) {
            test.put(i, i+"");
        }
        return test.size() > 5;
    }

    /**
     * Test clear() method.
     * 
     * @return
     */
    public static boolean test4() { 
        HashTableMap<Long, String> test = new HashTableMap<Long, String>();
        test.put(6089366467L, "Jared J Seeber");
        test.put(6086693266L, "Billy V Buckner");
        test.put(6085512037L, "Nancy K Hopkins");
        test.clear();
        if (test.size() == 0) {
            try {
                test.get(6085512037L);
            } catch (NoSuchElementException e) {
                return true;
            }
        }
        return false;
    }

    /**
     * Test containKey() method.
     * 
     * @return
     */
    public static boolean test5() { 
        HashTableMap<Long, String> test = new HashTableMap<Long, String>();
        test.put(6089366467L, "Jared J Seeber");
        test.put(6086693266L, "Billy V Buckner");
        test.put(6085512037L, "Nancy K Hopkins");
        return test.containsKey(6089366467L) && test.containsKey(6086693266L) && test.containsKey(6085512037L);
    }

}

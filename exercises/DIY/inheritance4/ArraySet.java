import java.lang.reflect.Array;
import java.util.*;

public class ArraySet<T> implements Iterable<T>{

    private T[] items;
    int size;

    public ArraySet() {
        items = (T[]) new Object[100];
        size = 0;
    }

    /* Returns true if this map contains a mapping for the specified key.
     */
    public boolean contains(T x) {
        for(int i = 0; i < size; i++){
//            if(items[i] == null){
//                if(x == null){
//                    return true;
//                }
//                continue;
//            }
            if(items[i].equals(x)){
                return true;
            }
        }
        return false;
    }

    /* Associates the specified value with the specified key in this map. 
       Throws an IllegalArgumentException if the key is null. */
    public void add(T x) {
        if(x == null){
            throw new IllegalArgumentException("can't add null");
        }
//        if(x == null){
//            return;
//        }

        if(contains(x)){
            return;
        }
        items[size] = x;
        size += 1;
    }

    /* Returns the number of key-value mappings in this map. */
    public int size() {
        return size;
    }

    /* make a Iterator shili */

    public Iterator<T> iterator(){
        return new getIterator();
    }

    // make belong myself Iterator

    private class getIterator implements Iterator<T>{
        private int position;

        public getIterator(){
            position = 0;
        }

        public boolean hasNext(){
            if(position >= size){
                return false;
            }
            return true;
        }

        public T next(){
            T temp = items[position];
            position += 1;
            return temp;
        }
    }

//    @Override
//    public String toString(){
//        StringBuilder set = new StringBuilder("{");
//        for(int i = 0; i < size - 1; i++){
//            set.append(items[i].toString());
//            set.append(", ");
//        }
//        set.append(items[size - 1]);
//        set.append("}");
//        return set.toString();
//    }
    @Override
    public String toString(){
        List<String> listOfitems = new ArrayList<>();
        for(T x : this){
            listOfitems.add(x.toString());
        }
        return "{" + String.join(", ", listOfitems) + "}";

    }

    @Override
    public boolean equals(Object other){
        if(other == this){
            return true;
        }
        if(other == null){
            return false;
        }
        if(other.getClass() != this.getClass()){
            return false;
        }
        ArraySet<T> o = (ArraySet<T>) other;
        if(o.size != this.size){
            return false;
        }
        for(T item : o){
            if(!this.contains(item)){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
//        Set<String> set = new HashSet<>();
//        set.add("shuwenjie");
//        set.add("work in big company");
//        for(String sentence : set){
//            System.out.println(sentence);
//        }
//        Iterator<String> seer = set.iterator();
//        while(seer.hasNext()){
//            String sentence = seer.next();
//            System.out.println(sentence);
//        }

        ArraySet<String> s = new ArraySet<>();
//        s.add(null);
        s.add("horse");
        s.add("fish");
        s.add("house");
        s.add("fish");
//        System.out.println(s.contains("horse"));
//        System.out.println(s.size());
//        Iterator<String> see = s.iterator();
//        while(see.hasNext()){
//            String creation = see.next();
//            System.out.println(creation);
//        }
//        for(String creation : s){
//            System.out.println(creation);
//        }
        System.out.println(s);
        System.out.println(s.equals(s));
    }

    /* Also to do:
    1. Make ArraySet implement the Iterable<T> interface.
    2. Implement a toString method.
    3. Implement an equals() method.
    */
}

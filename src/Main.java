import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

public class Main {





    public static void main(String[] args) {
        ArrayList<Integer> first = new ArrayList<>(Arrays.asList(1,2,3,7,8, 30, 50, 55));
        ArrayList<Integer> second = new ArrayList<>(Arrays.asList(2,2,4,5,8,9,10,11,13,130));
        ArrayList<Integer> third = new ArrayList<>(Arrays.asList(-5,1));

        Iterator<Integer> firstI = first.iterator();
        Iterator<Integer> secondI = second.iterator();
        Iterator<Integer> thirsdI = third.iterator();

        ArrayList<Iterator<Integer>> testIteratorList = new ArrayList<Iterator<Integer>>(Arrays.asList(firstI,secondI,thirsdI));
        CustomIterator test = new CustomIterator(testIteratorList);
        while (test.hasNext()){
            System.out.println(test.next().toString());
        }
    }
}

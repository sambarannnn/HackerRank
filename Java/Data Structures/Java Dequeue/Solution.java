import java.util.*;
public class test {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Deque<Integer> deque = new ArrayDeque<Integer>();
        HashSet<Integer> set = new HashSet<Integer>();

        int n = in.nextInt();
        int m = in.nextInt();
        int max_unique = 0;

        for (int i = 0; i < n; i++) {
            int s = in.nextInt();
            deque.add(s);//add number to deque
            set.add(s);//add number to set, adds only if max_unique
            if (deque.size() == m) {//if deque has reached max_unique subarray size
                if (set.size() > max_unique)
                    max_unique = set.size();//if set has become larger than max_unique,                                                ie.more max_unique numbers,
                int temp = deque.removeFirst();//remove first element acc to fifo|lifo                                                  takes more time for some reason
                if (!deque.contains(temp)) //if deque doesn't contain that element after                                           deleting, it didn't have any duplicates.                                                 Thus, its not there in the deque/subarray                                                anymore. So, remove it from the set as set                                             only contains unique elements of current subarray
                    set.remove(temp);//since it had a duplicate element, no need of                                            keeping in set
            }
        }
        System.out.println(max_unique);
    }
}

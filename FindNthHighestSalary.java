import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class FindNthHighestSalary {

    public static void main(String[] args) {
        Map<String, Integer> map2 = new HashMap<>();
        map2.put("anil", 1000);
        map2.put("ankit", 1200);
        map2.put("bhavna", 1200);
        map2.put("james", 1200);
        map2.put("micael", 1000);
        map2.put("tom", 1300);
        map2.put("daniel", 1300);

        System.out.println(getDynamicNthHighestSalary(1, map2));
    }


//        public static Map.Entry<Integer, List<String>> getDynamicNthHighestSalary(int num, Map<String, Integer> map) {
//            return map.entrySet()
//                    .stream()
//                    .collect(Collectors.groupingBy(Map.Entry::getValue,
//                            Collectors.mapping(Map.Entry::getKey, Collectors.toList())
//                    ))
//                    .entrySet()
//                    .stream()
//                    .sorted(Collections.reverseOrder(Map.Entry.comparingByKey()))
//                    .collect(Collectors.toList())
//                    .get(num - 1);
//        }

    public static Map.Entry<Integer, List<String>> getDynamicNthHighestSalary(int num, Map<String, Integer> map) {

       return  map.entrySet()
                .stream()
                .collect(Collectors.groupingBy(Map.Entry::getValue,Collectors.mapping(Map.Entry::getKey,Collectors.toList())))
                 .entrySet()
                 .stream()
                 .sorted(Collections.reverseOrder(Map.Entry.comparingByKey()))
                 .toList()
                 .get(num-1);

    }

}

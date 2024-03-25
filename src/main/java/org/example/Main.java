package org.example;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {


        List<Student> studentList = Stream.of(
                new Student(1,"venkat",30,"Male","MechanicalEng","mumbai",122, Arrays.asList("+919738268199","+919441389429")),
                new Student(2,"ankit",56,"Male","Computer Eng","Delhi",67, Arrays.asList("+919738268198","+919441389430")),
                new Student(3,"ramani",25,"FeMale","Computer Eng","kerala",164, Arrays.asList("+919738268196","+919441389431")),
                new Student(4,"madhav",30,"Male","Computer Eng","pune",26, Arrays.asList("+919738268197","+919441389432")),
                new Student(5,"romeo",23,"Male","BioTech Eng","mumbai",12, Arrays.asList("+919738268195","+919441389433"))
        ).toList();


      //1. Find list of students whose rank in between 50 to 100

        List<Student> studentList1 = studentList.stream().filter(student -> student.getRank() > 10 && student.getRank() < 30).toList();
       // studentList1.forEach(s-> System.out.println(s.getId()));


        //2. Find the list of students who stays in mumbai and sort by their names

        List<Student> studentList2 = studentList.stream().filter(student -> student.getCity().equals("mumbai"))
                .sorted(Comparator
                        .comparing(Student::getName))
                .toList();
//        System.out.println(studentList2);

        //3. Find all department names

        List<String> departmentList = studentList.stream()
                .map(Student::getDept)
                .distinct()
                .toList();
       // System.out.println(departmentList);

        Set<String> departmentListInSet = studentList.stream().map(Student::getDept)
                .collect(Collectors.toSet());
       // System.out.println(departmentListInSet);


        //4. Find all the contact numbers

        List<String> contactList = studentList.stream()
                .flatMap(student -> student.getContacts().stream()).collect(Collectors.toList());

       // System.out.println(contactList);

        //5. Group the student by department name

        Map.Entry<String, Long> stringLongEntry = studentList.stream().collect(Collectors.groupingBy(Student::getDept, Collectors.counting()))
                .entrySet().stream().min(Map.Entry.comparingByValue()).get();

        //System.out.println(stringLongEntry);

        //7. Find avg age of male and female from student
        Map<String, Double> collect = studentList.stream()
                .collect(Collectors.groupingBy(Student::getGender, Collectors.averagingInt(Student::getAge)));
       // System.out.println(collect);

    //8. Find highest rank in each department

        Map<String, Optional<Student>> stringOptionalMap = studentList.stream().collect(Collectors.groupingBy(Student::getDept, Collectors.minBy(Comparator.comparing(Student::getAge))));
//        System.out.println(stringOptionalMap);

        //9. Find the second rank
        Student sortByRank = studentList.stream().sorted(Comparator.comparing(Student::getRank))
                .skip(1)
                .findFirst().get();


        System.out.println(sortByRank);

        int[] numbers = {5,9,11,2,8,21,1};
        Integer list = Arrays.stream(numbers).boxed().sorted(Comparator.reverseOrder())
                .skip(1)
                .findFirst().get();


        System.out.println(list);

        String string ="ilovejavatechie";
        Map<String, Long> listofCharsOccurrences = Arrays.stream(string.split("")).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        System.out.println(listofCharsOccurrences);

        String key = Arrays.stream(string.split("")).collect(Collectors.groupingBy(Function.identity(),LinkedHashMap::new, Collectors.counting()))
                .entrySet().stream().filter(x -> x.getValue() > 1)
                .findFirst().get().getKey();
        System.out.println(key);


    }
}
package com.company;

import java.util.*;
import java.util.ArrayList;
import java.util.Set;
import java.util.function.Predicate;
import java.util.function.Consumer;
import java.util.function.Function;
import java.lang.Math;
import java.util.HashMap;
import java.util.Map;



public class Main {
    public static void main(String[] args) {

        ArrayList<HeavyBox> ListOfBox = new ArrayList<>();  //первое задание
        ListOfBox.add(new HeavyBox(15));
        ListOfBox.add(new HeavyBox(20));
        ListOfBox.add(new HeavyBox(50));
        ListOfBox.add(new HeavyBox(14));
        ListOfBox.forEach(System.out::println);

        ListOfBox.set(0, new HeavyBox(1));
        ListOfBox.remove(ListOfBox.size()-1);


        System.out.println("Первый способ");
        Object[] objArr = ListOfBox.toArray();
        System.out.println(Arrays.toString(objArr));

        System.out.println("Второй способ");
        HeavyBox[] boxArray = new HeavyBox[ListOfBox.size()];
        ListOfBox.toArray(boxArray);
        System.out.println(Arrays.toString(boxArray));


        System.out.println("Третий способ");
        HeavyBox[] boxArray1 = ListOfBox.toArray(new HeavyBox[0]);
        System.out.println(Arrays.toString(boxArray1));

        ListOfBox.clear();


        System.out.println("\nВторое задание");
        Set hashSet = new HashSet<>();                  //второе задание
        System.out.println("Введите строку чисел");
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();

        Scanner scannerStr = new Scanner(str);
        while (scannerStr.hasNext()) {
            if (scannerStr.hasNextInt()) {
                hashSet.add(scannerStr.nextInt());
            } else {
                scannerStr.next();
            }
        }

        Object[] objectArray = hashSet.toArray();
        System.out.println(Arrays.toString(objectArray));

        System.out.println("\nТретье задание");
        ListOfBox.add(new HeavyBox(15));            //третье задание
        ListOfBox.add(new HeavyBox(2500));
        ListOfBox.add(new HeavyBox(500));
        ListOfBox.add(new HeavyBox(14));
        ArrayList<HeavyBox> ListOfHeavyBox = new ArrayList<>();
        checkWeight(ListOfBox, ListOfHeavyBox);

        Object[] objectArray1 = ListOfHeavyBox.toArray();
        System.out.println(Arrays.toString(objectArray1));

        System.out.println("\nЧетвёртое задание");
        HashMap<String, Product> hashMap = new HashMap<String, Product>();      //четвёртое задание
        hashMap.put("Медведь", new Product(500, 1));
        hashMap.put("Тигр", new Product(400, 2));
        hashMap.put("Машинка", new Product(650, 3));

        System.out.print("Пары: ");
        printPair(hashMap);
        System.out.print("Ключи: ");
        printKey(hashMap);
        System.out.print("Значения: ");
        printValue(hashMap);


        System.out.println("\nПятое задание");
        ArrayList<Student> ListOfStudents= new ArrayList<>();               //Пятое задание
        ListOfStudents.add(new Student("Ivanov", "ПМИ", 2, new int[]{5, 5, 2}));
        ListOfStudents.add(new Student("Petrov", "ПМИ", 3, new int[]{5, 2, 2}));
        ListOfStudents.add(new Student("Sidorov", "ПМИ", 2, new int[]{2, 3, 2}));
        ListOfStudents.add(new Student("Smirnov", "ПМИ", 2, new int[]{4, 3, 5}));

        expelStudent(ListOfStudents);
        System.out.println("Студенты переведенные на следующий курс: ");

        Object[] objectArray2 = ListOfStudents.toArray();
        System.out.println(Arrays.toString(objectArray2));

        System.out.print("Студенты третьего курса ");
        printStudents(ListOfStudents, 3);





    }


    public static void checkWeight(ArrayList<HeavyBox> inputBox, ArrayList<HeavyBox> outputBox){
        Iterator<HeavyBox> it = inputBox.iterator();
        HeavyBox box;
        while (it.hasNext()){
            box=it.next();
            if (box.getWeight()>300)
                outputBox.add(box);
        }

    }


    public  static class  Product{
        private int ID, price;
        public Product(int price, int ID){
            this.price=price;
            this.ID=ID;
        }
        public String toString(){
            return " ID: "+ID + " Price: " + price ;
        }

    }

    public static void printPair(HashMap<String, Product> map){
        Set set = map.entrySet();
        Object[] objArr = set.toArray();
        System.out.println(Arrays.toString(objArr));

    }

    public static void printKey(Map<String, Product> map){
        Set<String> keys = map.keySet();
        for (String key : keys) {
            System.out.print(key + " ");
           }
        System.out.println();
    }
    public static void printValue(Map<String, Product> map){
        Collection<Product> val = map.values();
        Object[] objArr = val.toArray();
        System.out.println(Arrays.toString(objArr));
    }


    public static class HeavyBox {
        private int weight;

        public  HeavyBox(int weight){
            this.weight=weight;
        }

        public int getWeight(){
            return weight;
        }

        public String toString(){
            return "Weight is " + weight;

        }

    }

    public static class  Student{
        private String name, group;
        private int course;
       // private List<Integer> marks /*= new ArrayList<>()*/;
        private int[] marks;


        public Student(String name, String group, int course, int[] marks){
            this.name=name;
            this.course=course;
            this.group=group;
            this.marks=marks;
        }

        public void transfer(){
            course++;
        }

        public double getAverMark() {
            double sum = 0, count = 0;
            for(int i=0; i<marks.length; i++)
                sum+=marks[i];
            return sum/marks.length;
        }

        public int getCourse(){
            return course;
        }

        public String toString(){
            return "\nName: "+ name + " Course: " + course + " Group: " + group + " Aver mark: " + getAverMark();

        }


    }

    public static ArrayList<Student> expelStudent(ArrayList<Student> students){
        students.removeIf(n ->(n.getAverMark()<3));

       Iterator<Student> iterator = students.iterator();
        while (iterator.hasNext()){
            iterator.next().transfer();
        }
        return students;
    }

    public static void printStudents(ArrayList<Student> students, int course){
        ListIterator<Student> iterator = students.listIterator();
        Student buf;
        while (iterator.hasNext()){
            buf=iterator.next();
            if (buf.getCourse() == course)
                System.out.print(buf);
        }

    }

}





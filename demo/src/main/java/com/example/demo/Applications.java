package com.example.demo;

import java.util.*;
import java.util.stream.Collectors;

public class Applications {
    public static void main(String args[]) {

        //filtrer et transformer
        List<String> names = Arrays.asList("Alice", "Bob", "Andrew", "John", "Amanda", "Mike");
        List<String> newList = names.stream()
                .filter(name -> name.startsWith("A"))
                .map(String::toUpperCase)
                .collect(Collectors.toList());

        System.out.println(newList);

        //Calcul de la somme des entiers pairs
        List<Integer> numbers = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
        int sum = numbers.stream()
                .filter(num -> num%2 ==0)
                .mapToInt(Integer::intValue)
                .sum();
        System.out.println(sum);
        //Recherche de chaînes uniques et tri
        List<String> items = Arrays.asList("apple", "orange", "banana", "apple", "orange", "pear");
        List<String> newItems = items.stream()
                .distinct().sorted().collect(Collectors.toList());
        System.out.println(newItems);

        //Compter les mots qui dépassent une longueur donnée
        List<String> words = Arrays.asList("elephant", "dog", "cat", "hippopotamus", "horse");
        long count = words.stream()
                .filter(word -> word.length()>5)
                .count();
        System.out.println(count);

        //Trouver le nombre maximum dans une liste
        List<Integer> numeros = Arrays.asList(3, 8, 12, 5, 18, 21, 7);
        Optional<Integer> maxNumber = numeros.stream().max(Integer::compare);
        if(maxNumber.isPresent()) {
            System.out.println(maxNumber.get());
        }
        //Joindre les chaines avec un délimiteur
        List<String> mots = Arrays.asList("Java", "Streams", "Lambda", "Expression");
        String result = mots.stream().collect(Collectors.joining("-"));
        System.out.println(result);

        //Grouper des objets par une propriété
        List<Person> people = Arrays.asList(
                new Person("Alice", 23),
                new Person("Bob", 25),
                new Person("Charlie", 23),
                new Person("David", 25),
                new Person("Eve", 30)
        );
        Map<Integer, List<Person>> groupedByAge = new HashMap<>();
        groupedByAge = people.stream().collect(Collectors.groupingBy(Person::getAge));
        groupedByAge.forEach((age,persons) ->{
            System.out.println("Age:" + age);
            persons.forEach(person -> System.out.println(person.getName()));
        });
        //Réduire une collection
        List<Integer> numberss = Arrays.asList(1, 2, 3, 4, 5);
        int product = numberss.stream().reduce(1,(a,b)->a*b);
        System.out.println(product);
    }


}

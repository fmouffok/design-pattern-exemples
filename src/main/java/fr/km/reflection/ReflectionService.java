package fr.km.reflection;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Arrays;

public class ReflectionService {

    public static void main(String[] args) {

        try {
            final Class<?> aClass = Class.forName("fr.km.model.User");
            System.out.println(aClass);
            System.out.println(aClass.getName());
            Arrays.stream(aClass.getDeclaredFields()).map(s -> s.getName()).forEach(System.out::println);

            for (Field f : aClass.getDeclaredFields()) {
                System.out.println("type : " + f.getType());
                System.out.println("modifiers : " + f.getModifiers());
                System.out.println("Is Private : " + Modifier.isPrivate(f.getModifiers()));
            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


    }
}

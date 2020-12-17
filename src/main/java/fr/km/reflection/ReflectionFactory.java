package fr.km.reflection;

import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ReflectionFactory {

    public static final String PATH_REF = "fr.km.model.";
    public static final String PATH_FIRST = "src/main/java/fr/km/model/";

    /**
     * final Class<?> aClass = Class.forName("fr.km.model.User");
     * System.out.println(aClass);
     * System.out.println(aClass.getName());
     * Arrays.stream(aClass.getDeclaredFields()).map(s -> s.getName()).forEach(System.out::println);
     * <p>
     * for (Field f : aClass.getDeclaredFields()) {
     * System.out.println("type : " + f.getType());
     * System.out.println("modifiers : " + f.getModifiers());
     * System.out.println("Is Private : " + Modifier.isPrivate(f.getModifiers()));
     * }
     */
    public static void main(String[] args) throws IOException, ClassNotFoundException {

        String pathFirst = PATH_FIRST;
        String pathRef = PATH_REF;
        StringBuilder sb = null;

        Path path = Paths.get(pathFirst);
        try (Stream<Path> stream = Files.walk(path, 1)) {
            final Function<String, String> extractFileName = s -> s.substring(pathFirst.length());
            final Predicate<String> javaFilePredicate = s -> s.endsWith(".java");
            final Function<String, String> extractionFileWithoutExtension = s -> s.substring(0, s.length() - 5);
            final Function<String, String> constructReferencePath = s -> pathRef.concat(s);
            List<String> list = stream
                    .map(String::valueOf)
                    .filter(javaFilePredicate)
                    .map(extractFileName)
                    .map(extractionFileWithoutExtension)
                    .sorted()
                    .collect(Collectors.toList());
//            for (String fileName : list){
//                String completePath = constructReferencePath.apply(fileName);
//                final Class<?> aClass = Class.forName(completePath);
//                sb = new StringBuilder("\npublic class ").append(fileName)
//                        .append(" {\n");
//                for (Field f : aClass.getDeclaredFields()) {
//                    sb.append(Modifier.isPrivate(f.getModifiers())? "private ":" ")
//                            .append("java.lang.String".equals(f.getType().getName())?"String":"java.lang.Integer"
//                                    .equals(f.getType().getName())?"int":"java.lang.Date".equals(f.getType().getName())?"Date":
//                                    "java.lang.Double".equals(f.getType().getName())?"double":
//                                            "java.lang.Float".equals(f.getType().getName())?"float":
//                                                    "java.lang.Long".equals(f.getType().getName())?"Long":f.getType().getName())
//                            .append(" ").append(f.getName()).append(";").append("\n");
//                }
//                sb.append("\n}").toString();
//                System.out.println("clazz : "+sb.toString());
//            }
        }
    }
}

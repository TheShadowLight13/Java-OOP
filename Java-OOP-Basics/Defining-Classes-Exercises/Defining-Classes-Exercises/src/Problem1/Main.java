package Problem1;

import java.io.IOException;
import java.lang.reflect.Field;

public class Main {

    public static void main(String[] args) throws IOException {

        Class person = Person.class;
        Field[] fields = person.getDeclaredFields();
        System.out.println(fields.length);
    }
}

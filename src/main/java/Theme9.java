import java.lang.reflect.Field;
import java.lang.annotation.*;
import java.lang.reflect.Method;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@interface MyAnnotation {}

class Sample {
    @MyAnnotation
    public void test1() {
        System.out.println("Виконується тест 1");
    }
    public void helper() {
        System.out.println("Допоміжний метод");
    }
    @MyAnnotation
    public void test2() {
        System.out.println("Виконується тест 2");
    }
}

class TestRunner {
    public static void main (String[] args) throws Exception {
        Sample sample = new Sample();
        Class <?> clazz = sample.getClass();
        // Проходимося по всіх методах класу Sample
        for (Method m: clazz.getDeclaredMethods()) {
            // Якщо над методом стоїть анотація @Test – виконуємо його
            if (m.isAnnotationPresent(MyAnnotation.class)) {
                System.out.println("Знайдено тестовий метод: " + m.getName());
                // викликаємо метод sample.m()
                m.invoke(sample);
            }
        }
    }
}




class Person {
    private String name = "Alice";
    private int age = 30;
}

public class Theme9 {
    public static void main (String[] args) throws Exception {
        Person person = new Person();
        Class <?> clazz = person.getClass();
        System.out.println("Клас об'єкта: " + clazz.getName());

        // Отримаємо всі оголошені поля класу, включаючи приватні:
        Field[] fields = clazz.getDeclaredFields();
        for (Field f: fields) {
            // даємо доступ навіть до приватних полів
            f.setAccessible(true);
            // зчитуємо значення поля з об'єкта person
            Object value = f.get(person);
            System.out.println("Поле" + " " + f.getName() + " " + value);
        }
    }
}

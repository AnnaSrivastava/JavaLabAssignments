package day7;
/**
 * Organization: Yamaha Motor Solutions India
 * Project Name:lab assignment
 * Package: day7
 * Class: Q1
 * Description: Create custom annotations and display them using Java Reflections API
 * Created On:04 August 2021
 * @author Ananya Srivastava
 */
import java.lang.annotation.Annotation;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

//create annotation Author
@Target({ ElementType.CONSTRUCTOR, ElementType.METHOD, ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
@interface Author {
	String name() default "unknown";
}

//Create annotation Version
@Target({ ElementType.CONSTRUCTOR, ElementType.METHOD, ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
@interface Version {
	double number();
}

//Implement created annotations on class
@Author(name = "Johny")
@Version(number = 1.0)
class AnnotatedClass {
	
	//annotation on constructor
	@Author(name = "Constructor")
	@Version(number = 1.0D)
	public AnnotatedClass() {
		System.out.println("Constructor execution");
	}

	//annotation on constructor
	@Author(name = "parameterized")
	@Version(number = 1.2D)
	public AnnotatedClass(String str) {
		System.out.println("Para construction execution" + str);
	}

	//annotation on method
	@Author(name = "Author1")
	@Version(number = 2.0f)
	public void annotatedMethod() {
	}

	//annotation on method
	@Author(name = "Author2")
	@Version(number = 4.0)
	public void annotatedMethod2() {
	}
}
//Implement created annotations on class
@Author(name = "Testing")
class Testing {

}
//Implement created annotations on class
@Author(name = "Extended Testing")
class ExtendedTesting extends Testing {

}

//tester class
public class Q1 {
	// Overloaded readAnnotation method for Method
	public static void readAnnotation(Method methods[]) {
		int index = 0;
		for (Method method : methods) {

			System.out.println("[" + index + "] " + method);

			if (method.isAnnotationPresent(Author.class)) {
				Author annotation = method.getAnnotation(Author.class);
				System.out.println("author : " + annotation.name());
			}

			if (method.isAnnotationPresent(Version.class)) {
				Version annotation = method.getAnnotation(Version.class);
				System.out.println("version : " + annotation.number());
			}
			index++;
		}
	}

	// Overloaded readAnnotation method for Constructors
	private static void readAnnotation(Constructor<?>[] constructors) {
		int index = 0;
		for (Constructor<?> constructor : constructors) {

			System.out.println("[" + index + "]" + constructor);

			if (constructor.isAnnotationPresent(Author.class)) {
				Author annotation = constructor.getAnnotation(Author.class);
				System.out.println("author : " + annotation.name());
			}

			if (constructor.isAnnotationPresent(Version.class)) {
				Version annotation = constructor.getAnnotation(Version.class);
				System.out.println("version : " + annotation.number());
			}
			index++;
		}
	}

	// Overloaded readAnnotation method for Class
	private static void readAnnotation(Class<?> clazz) {
		Annotation[] annotations = clazz.getAnnotations();
		for (Annotation annotation : annotations) {
			if (annotation instanceof Author) {
				Author author = (Author) annotation;
				System.out.println("author : " + author.name());
			}
			if (annotation instanceof Version) {
				Version version = (Version) annotation;
				System.out.println("version : " + version.number());
			}
		}
	}
	
	//tester method
	public static void main(String[] args) {
		try {
			System.out.println("[Annotated Class]\n");
			Class<?> clazz = Class.forName("day7.Q1");

			System.out.println("Method Annotations:");
			Method methods[] = clazz.getDeclaredMethods();
			readAnnotation(methods);
			
			System.out.println("\nConstructor Annotations:");
			Constructor<?>[] constructors = clazz.getConstructors();
			readAnnotation(constructors);

			System.out.println("\nClass Annotations:");
			readAnnotation(clazz);

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			System.out.println("\n[Testing Class]\n");

			Class<?> clazz2 = Class.forName("day7.Testing");

			System.out.println("Class Annotations:");
			readAnnotation(clazz2);

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			System.out.println("\n[ExtendedTesting Class]\n");

			Class<?> clazz3 = Class.forName("day7.ExtendedTesting");

			System.out.println("Class Annotations:");
			readAnnotation(clazz3);

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
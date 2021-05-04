import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {
    public static void main(String[] args) {
        ApplicationContext applicationContext =
                new AnnotationConfigApplicationContext(AppConfig.class);
        HelloWorld bean = (HelloWorld) applicationContext.getBean("helloworld");
        System.out.println(bean.getMessage());

        HelloWorld beanTwo = (HelloWorld) applicationContext.getBean("helloworld");
        System.out.println(bean.getMessage());

        Cat catBean = (Cat) applicationContext.getBean("cat");
        System.out.println(catBean.getMessage());

        Cat secondCatBean = (Cat) applicationContext.getBean("cat");
        secondCatBean.setMessage("this is second cat");
        System.out.println(secondCatBean.getMessage());

        boolean comparisonHelloBeans = bean == beanTwo;
        System.out.println(comparisonHelloBeans);

        boolean comparisonCatBeans = catBean == secondCatBean;
        System.out.println(comparisonCatBeans);


        /*
Класс App содержит метод main, который запускает Спринг при создании контекста.
В контекст мы передаем класс AppConfig, который помечен аннотацией @Configuration -
так Спринг понимает, что это настроечный класс.
В классе AppConfig содержится метод, помеченный аннотацией как бин,
этот метод будет выполнен при запуске и его результат станет объектом, управляемым Спрингом.
2. Создайте POJO-класс Cat.
3. В классе AppConfig, по аналогии, создайте бин с именем “cat”.
4. Настройте этот бин так, чтобы он создавался новым при каждом запросе. Prototype
5. В классе App, по аналогии, вызовите еще раз бин HelloWorld, затем 2 раза вызовите бин cat.
Сравните 2 пары бинов по ссылке и выведите результат в консоль.
Для пары HelloWorld должно вернуться true, для cat - false.
Так вы можете увидеть результат того, как работает наш контейнер.
6. Раскоментируйте тестовый класс и проверьте своё решение.
         */
    }
}
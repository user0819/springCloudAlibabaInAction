import com.xiang.IUserService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath*:META-INF/spring/consumer.xml");

        IUserService iUserService = (IUserService) context.getBean("userService");
        System.out.println(iUserService.getNameById("23"));
    }
}

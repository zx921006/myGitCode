
import com.spring.App;
import com.spring.X;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class test {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(App.class);
        X bean = applicationContext.getBean(X.class);
        System.out.println(bean);
    }
}

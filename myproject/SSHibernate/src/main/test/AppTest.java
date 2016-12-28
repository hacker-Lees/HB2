import com.lees.service.DeptService;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by Administrator on 2016/12/27.
 */
public class AppTest {

    private ApplicationContext act = null;
    private SessionFactory sessionFactory = null;
private DeptService service ;
    {
        act = new ClassPathXmlApplicationContext("applicationContext.xml");
//        sessionFactory = (SessionFactory) act.getBean("sqlSessionFactory");
        service = act.getBean(DeptService.class);
    }

    @Test
    public void fun2(){
        System.out.println(service.findAll());
    }

    @Test
    public void fun1() {

        Session session = sessionFactory.openSession();
        Transaction tx = session.getTransaction();

        try {
            tx.begin();


            tx.commit();
        } catch (Exception e) {
            tx.rollback();
            e.printStackTrace();
        } finally {
            tx = null;
            session.close();
        }
    }
}

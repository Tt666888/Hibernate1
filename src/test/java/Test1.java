import com.cyt.dao.EmpDao;
import com.cyt.dao.EmpDaoImpl;
import com.cyt.entity.Emp;

import java.util.List;

/**
 * @author ${user}
 * @create 2019-11-21-11:45
 */
public class Test1 {
    @org.junit.Test
    public void testStudentDaoSelectAll() {
        EmpDao sd = new EmpDaoImpl();
        List<Emp> list =((EmpDaoImpl) sd).selectAll();
        for (Emp emp : list) {
            System.out.println("123456");
            System.out.println("emp = " + emp);
        }

    }
}

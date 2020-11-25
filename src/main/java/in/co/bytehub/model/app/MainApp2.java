package in.co.bytehub.model.app;

import in.co.bytehub.model.Department;
import in.co.bytehub.model.Employee;
import in.co.bytehub.util.HibUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.Arrays;

public class MainApp2 {

    public static void main(String[] args) {

        Department itDepartment = new Department();
        Employee employee = new Employee();
        Employee hod = new Employee();

        employee.setName("AKASH")
                .setDepartment(itDepartment);

        hod.setName("DEEPAK")
                .setDepartment(itDepartment);


        itDepartment.setName("IT");
        itDepartment.setHead(hod);
        itDepartment.setEmployeeList(Arrays.asList(employee, hod));


        SessionFactory factory = HibUtil.getSessionFactory();
        Transaction tx = null;
        Session session = null;
        try {
            session = factory.openSession();
            tx = session.beginTransaction();
            session.save(employee);
            session.save(hod);
            session.save(itDepartment);

            tx.commit();
        } catch (HibernateException e) {
            System.err.println(e);
            if (tx != null) {
                tx.rollback();
            }
        } finally {
            if (session != null) {
                session.close();
            }

        }

    }
}

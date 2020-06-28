package in.co.bytehub.model.app;

import java.util.Arrays;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.jboss.logging.Logger;

import in.co.bytehub.model.AddressInfo;
import in.co.bytehub.model.CellPhone;
import in.co.bytehub.model.Name;
import in.co.bytehub.model.UserInfo;
import in.co.bytehub.util.HibUtil;

public class MainApp {

	private static final Logger LOGGER = Logger.getLogger(MainApp.class);

	public static void main(String[] args) {

		Name name = new Name();
		name.setFirst("Akash");
		name.setLast("Chaudhary");

		AddressInfo permanentAddress = new AddressInfo();
		permanentAddress.setZip(121134);
		permanentAddress.setCity("PALWAL");
		permanentAddress.setCountry("INDIA");
		permanentAddress.setState("HARYANA");

		AddressInfo correspondenceAddress = new AddressInfo();
		correspondenceAddress.setZip(121135);
		correspondenceAddress.setCity("Pune");
		correspondenceAddress.setCountry("INDIA");
		correspondenceAddress.setState("MAHARASHTRA");

		UserInfo user = new UserInfo();
		user.setName(name);
		user.setAddress(Arrays.asList(permanentAddress, correspondenceAddress));
		
		CellPhone officialPhone = new CellPhone();
		officialPhone.setModel("I-Phone");
		officialPhone.setPhoneNumber(999127879L);
		officialPhone.setUser(user);

		CellPhone personalPhone = new CellPhone();
		personalPhone.setModel("Nokia");
		personalPhone.setPhoneNumber(999127878L);
//		personalPhone.setUser(user);

		
		user.setCellPhone(officialPhone);
//		user.setCellPhones(Arrays.asList(officialPhone, personalPhone));
		
		SessionFactory factory = HibUtil.getSessionFactory();
		Transaction tx = null;
		Session session = null;
		try {
			session = factory.openSession();
			tx = session.beginTransaction();
			session.save(user);
//			session.save(officialPhone);
			tx.commit();
		} catch (HibernateException e) {
			LOGGER.error("Operation Failed ", e);
			if (tx != null) {
				tx.rollback();
			}
		} finally {
			if (session != null) {
				session.close();
			}

		}
		
		session = factory.openSession();
		UserInfo fetchedUser =  session.get(CellPhone.class, 999127879L).getUser();
		System.out.println(fetchedUser);
	}
}

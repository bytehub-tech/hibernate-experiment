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
import in.co.bytehub.model.Vehcile;
import in.co.bytehub.model.VehicleType;
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

		Vehcile bike = new Vehcile();
		bike.setRegNo("HR50F4724");
		bike.setType(VehicleType.BIKE);
		bike.setUser(user);

		Vehcile car = new Vehcile();
		car.setRegNo("HR50A4221");
		car.setType(VehicleType.CAR);
		car.setUser(user);

		user.setCellPhone(officialPhone);
		user.setVehcile(Arrays.asList(bike, car));

		SessionFactory factory = HibUtil.getSessionFactory();
		Transaction tx = null;
		Session session = null;
		try {
			session = factory.openSession();
			tx = session.beginTransaction();
			session.save(user);
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

		try {
			session = factory.openSession();
			UserInfo fetchedUser = session.get(Vehcile.class, "HR50A4221").getUser();
			System.out.println(fetchedUser);
		} finally {
			session.close();
		}

	}
}

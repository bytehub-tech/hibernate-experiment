package in.co.bytehub.model.app;

import java.util.Arrays;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.jboss.logging.Logger;

import in.co.bytehub.model.AddressInfo;
import in.co.bytehub.model.CellPhone;
import in.co.bytehub.model.Course;
import in.co.bytehub.model.Name;
import in.co.bytehub.model.Student;
import in.co.bytehub.model.Vehcile;
import in.co.bytehub.model.VehicleType;
import in.co.bytehub.util.HibUtil;

public class MainApp {

	private static final Logger LOGGER = Logger.getLogger(MainApp.class);

	public static void main(String[] args) {

		Student userAkash = prepareStudentAkash();
		Student userAjay = prepareStudentAjay();

		Course dac = new Course();
		dac.setName("DAC");
		
		Course embedded = new Course();
		embedded.setName("DESD");
		
		userAkash.setCourses(Arrays.asList(dac, embedded));
		userAjay.setCourses(Arrays.asList(dac, embedded));
		
		SessionFactory factory = HibUtil.getSessionFactory();
		Transaction tx = null;
		Session session = null;
		try {
			session = factory.openSession();
			tx = session.beginTransaction();
			session.save(userAkash);
			session.save(userAjay);			
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
			Student fetchedUser = session.get(Vehcile.class, "HR50A4221").getUser();
			System.out.println(fetchedUser);
		} finally {
			session.close();
		}

	}

	public static Student prepareStudentAkash() {

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

		Student user = new Student();
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
		return user;
	}
	
	public static Student prepareStudentAjay() {

		Name name = new Name();
		name.setFirst("Ajay");
		name.setLast("Sorout");

		AddressInfo permanentAddress = new AddressInfo();
		permanentAddress.setZip(121144);
		permanentAddress.setCity("Hodal");
		permanentAddress.setCountry("INDIA");
		permanentAddress.setState("Hayrana");

		AddressInfo correspondenceAddress = new AddressInfo();
		correspondenceAddress.setZip(121135);
		correspondenceAddress.setCity("Mumbai");
		correspondenceAddress.setCountry("INDIA");
		correspondenceAddress.setState("MAHARASHTRA");

		Student user = new Student();
		user.setName(name);
		user.setAddress(Arrays.asList(permanentAddress, correspondenceAddress));

		CellPhone officialPhone = new CellPhone();
		officialPhone.setModel("Nokia");
		officialPhone.setPhoneNumber(999127875L);
		officialPhone.setUser(user);

		Vehcile bike = new Vehcile();
		bike.setRegNo("HR50F4722");
		bike.setType(VehicleType.BIKE);
		bike.setUser(user);

		Vehcile jeep = new Vehcile();
		jeep.setRegNo("HR50A4211");
		jeep.setType(VehicleType.JEEP);
		jeep.setUser(user);

		user.setCellPhone(officialPhone);
		user.setVehcile(Arrays.asList(bike, jeep));
		return user;

	}
}

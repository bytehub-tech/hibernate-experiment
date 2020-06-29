package in.co.bytehub.util;

import org.jboss.logging.Logger;

import in.co.bytehub.model.AddressInfo;
import in.co.bytehub.model.CellPhone;
import in.co.bytehub.model.Student;
import in.co.bytehub.model.Vehcile;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.annotations.common.util.impl.LoggerFactory;
import org.hibernate.cfg.Configuration;

public class HibUtil {

	private static SessionFactory sessionFactory;

	private static final Logger LOGGER = LoggerFactory.logger(HibUtil.class);

	public static SessionFactory getSessionFactory() {

		if (sessionFactory == null) {
			Configuration configuration = new Configuration();
			
			try {
				sessionFactory = configuration
						.addAnnotatedClass(Student.class)
						.addAnnotatedClass(AddressInfo.class)
						.addAnnotatedClass(CellPhone.class)
						.addAnnotatedClass(Vehcile.class)
						.configure()						
						.buildSessionFactory();
				LOGGER.info("SessionFactory initilized successfully ...");
			} catch (HibernateException hbe) {
				LOGGER.error("SessionFcatory init failed");	
				hbe.printStackTrace();
			}
		}

		return sessionFactory;
	}

}

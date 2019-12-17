package com.edu.crm;

import com.edu.crm.adapters.UserAdapter;
import com.edu.crm.db.HibernateSessionFactoryUtil;
import com.edu.crm.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Calendar;

@SpringBootApplication
public class CrmApplication {
	public static void main(String[] args) {
		SpringApplication.run(CrmApplication.class, args);

		User user = new User( "Sim", 26);
		UserAdapter userAdapter = new UserAdapter();
		if (userAdapter.create(user) == true){
			System.out.println("Создали успешно");
			System.out.println(userAdapter.read(user.getId()).getLastName());
				System.out.println("Прочитали успешно");
				user.setLastName("Govnoed");
				if (userAdapter.update(user) == true){
					System.out.println("Обновили фамилию успешно:" +user.getLastName() +" == " +userAdapter.read(user.getId()).getLastName());
					if (userAdapter.delete(user) == true){
						System.out.println("Удалили успешно:" +userAdapter.read(user.getId()));
					} else System.out.println("Удалили не успешно");
				} else System.out.println("Обновили не успешно");
//			} else System.out.println("Прочитали не успешно" +user.getId());
		} else System.out.println("Создали не успешно");

		HibernateSessionFactoryUtil.closeSessionFactory();
//	TODO как подлючаться, подключиться, кинуть запрос , (вынести настрйоки), создать модель, подключиться с ORM, вытащить сущность

	}
}
/*
* try {
			Connection connection = DriverManager.getConnection(URL_DB, USER_NAME, USER_PASS);
			connection.isValid(10);

			{
				Statement statement = connection.createStatement();
				statement.execute("CREATE TABLE Persons (\n" +
						"    PersonID int,\n" +
						"    LastName varchar(255),\n" +
						"    FirstName varchar(255),\n" +
						"    Address varchar(255),\n" +
						"    City varchar(255)\n" +
						");");
				statement.close();
				PreparedStatement preparedStatement = connection.prepareStatement("select * from (?)");
				preparedStatement.setString(1, URL_DB);
				preparedStatement.setString(2, URL_DB);
			}

		} catch (Exception ex) {
			System.out.println(ex + "Error db connection");
		}
	}*/
//
//	Configuration configuration = new Configuration()
//			.setProperty( "hibernate.connection.driver_class", "com.mysql.jdbc.Driver" )
//			.setProperty( "hibernate.connection.url", URL_DB )
//			.setProperty( "hibernate.connection.username", USER_NAME)
//			.setProperty( "hibernate.connection.password", USER_PASS)
//			.setProperty( "hibernate.connection.pool_size", "1" )
//			.setProperty( "hibernate.connection.autocommit", "true" )
//			.setProperty( "hibernate.dialect", "org.hibernate.dialect.MySQL8Dialect" )
//			.setProperty( "hibernate.show_sql","true" )
//			.setProperty( "hibernate.hbm2ddl.auto", "update" )
//			.addAnnotatedClass(Persons.class);
//
//	SessionFactory sessionsFactory = configuration.buildSessionFactory();
//	Session session = sessionsFactory.openSession();
//		session.save(new Persons("ivan"));
//				session.get(new Persons(12));
//				sessionsFactory.close();
//
//				UserAdapter userAdapter = new UserAdapter();
//				user.get(new user)

package com.edu.crm;

import com.edu.crm.adapters.OrderAdapter;
import com.edu.crm.adapters.UserAdapter;
import com.edu.crm.db.HibernateSessionFactoryUtil;
import com.edu.crm.model.User;
import com.edu.crm.model.Orders;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CrmApplication {
	public static void main(String[] args) {
		SpringApplication.run(CrmApplication.class, args);

		User user = new User("Sim", 26);
		Orders order = new Orders("Order for garbage", 5600 );

		user.addOrder(order);

		UserAdapter userAdapter = new UserAdapter();
		OrderAdapter orderAdapter = new OrderAdapter();

		userAdapter.create(user);
		orderAdapter.create(order);

		System.out.println(orderAdapter.read(order.getId()));
		System.out.println(userAdapter.read(user.getId()));

		System.out.println("Меняем имя юзера на ебобо");
		user.setLastName("Ebobo");
		System.out.println(orderAdapter.read(order.getId()));


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
//			.setProperty( "hibernatection.password", USER_PASS)
//			.setProperty( "hibernate.conne.connection.pool_size", "1" )
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

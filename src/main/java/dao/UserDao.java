package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import dto.UserInfo;

public class UserDao {
	EntityManagerFactory factory = Persistence.createEntityManagerFactory("dev");
	EntityManager manager = factory.createEntityManager();
	EntityTransaction transaction = manager.getTransaction();

	public void save(UserInfo info) {
		transaction.begin();
		manager.persist(info);
		transaction.commit();
	}

	public UserInfo fetch(long phone) {
		List<UserInfo> list = manager.createQuery("select x from UserInfo x where phone=?1").setParameter(1, phone)
				.getResultList();
		if (list.isEmpty()) {
			return null;
		} else {
			return list.get(0);

		}
	}

	public UserInfo fetch(String email) {
		List<UserInfo> list = manager.createQuery("select x from UserInfo x where email=?1").setParameter(1, email)
				.getResultList();
		if (list.isEmpty()) {
			return null;
		} else {
			return list.get(0);

		}
	}
	
	//to fetch the data in front end
	public List<UserInfo> fetchAll(){
		return manager.createQuery("select x from UserInfo x").getResultList();
		
	}
	
	public UserInfo fetch(int id){
		return manager.find(UserInfo.class, id);
	}
	
	public void delete(UserInfo user){
		transaction.begin();
		manager.remove(user);
		transaction.commit();
	}

	public void update(UserInfo user) {

		transaction.begin();
		manager.merge(user);
		transaction.commit();
		
	}

}

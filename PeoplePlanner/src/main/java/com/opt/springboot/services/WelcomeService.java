package com.opt.springboot.services;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Component;

import com.opt.springboot.entity.User;

@Component
public class WelcomeService {
	
	private EntityManager entityManager;
	
	public String retrieveWelcomeMessage() {
		//Complex Method
		return "Good Morning updated";
	}

	@Transactional
	public User addOrUpdateUserToDb(User user) {
		if(user.getId()==null){
			entityManager.persist(user);
		}else{
			entityManager.merge(user);
		}
		entityManager.flush();
		System.out.println(user.toString());
		return user;
	}
	
	public User findUser(Long userId){
		return entityManager.find(User.class, userId);
	}

	
	public EntityManager getEntityManager() {
		return entityManager;
	}

	@PersistenceContext
	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

}

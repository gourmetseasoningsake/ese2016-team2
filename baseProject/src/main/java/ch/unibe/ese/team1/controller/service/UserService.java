package ch.unibe.ese.team1.controller.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ch.unibe.ese.team1.model.User;
import ch.unibe.ese.team1.model.UserGoogle;
import ch.unibe.ese.team1.model.dao.UserDao;
import ch.unibe.ese.team1.model.dao.UserGoogleDao;

/**
 * Handles all database actions concerning users.
 */
@Service
public class UserService {
	
	@Autowired
	private UserDao userDao;
	
	@Autowired
	private UserGoogleDao userGoogleDao;

	/** Gets the user with the given username. */
	@Transactional
	public User findUserByUsername(String username) {
		return userDao.findByUsername(username);
	}
	
	/** Gets the user with the given id. */
	@Transactional
	public User findUserById(long id) {
		return userDao.findUserById(id);
	}
	
	
	/** Gets the google user with the given username. */
	@Transactional
	public UserGoogle findGoogleUserByUsername(String username) {
		return userGoogleDao.findByUsername(username);
	}
	
	/** Gets the google user with the given id. */
	@Transactional
	public UserGoogle findGoogleUserById(long id) {
		return userGoogleDao.findUserById(id);
	}

}

package ch.unibe.ese.team1.test.testData;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ch.unibe.ese.team1.model.Gender;
import ch.unibe.ese.team1.model.User;
import ch.unibe.ese.team1.model.UserPicture;
import ch.unibe.ese.team1.model.UserRole;
import ch.unibe.ese.team1.model.dao.UserDao;

/**
 * This inserts some user test data into the database.
 */
@Service
public class UserTestDataSaver {

	@Autowired
	private UserDao userDao;

	@Transactional
	public void saveTestData() throws Exception {
		// system account
		User system = createUser("System", "1234", "FlatFindr", "Admin",
				"/img/test/system.jpg", Gender.ADMIN, "Normal");
		system.setAboutMe("We keep you off the streets.");
		userDao.save(system);

		// Main test-user for the assistants (advertiser)
		User ese = createUser("ese@unibe.ch", "ese", "John", "Wayne",
				"/img/test/portrait.jpg", Gender.MALE, "Normal");
		ese.setAboutMe(getDummyText());
		userDao.save(ese);

		// Searcher
		User janeDoe = createUser("jane@doe.com", "password", "Jane", "Doe",
				"/img/test/avatar.jpg", Gender.FEMALE, "Normal");
		janeDoe.setAboutMe(getDummyText());
		userDao.save(janeDoe);

		// Another advertiser & searcher
		User bernerBaer = createUser("user@bern.com", "password", "Berner", "B�r", 
				"/img/avatar.jpg", Gender.MALE, "Premium", "Alpenstrasse 35", "Bern", 3000);
		UserPicture picture = new UserPicture();
		picture.setFilePath("/img/test/berner_baer.png");
		picture.setUser(bernerBaer);
		bernerBaer.setPicture(picture);
		bernerBaer.setAboutMe("I am a PhD student and I am Italian. I am 26,"
				+ "I like winter-sports, hiking, traveling and cooking."
				+ "I enjoy spending time with friends, watching movies, "
				+ "going for drinks and organizing dinners. I have lived in Milan,"
				+ "London and Zurich, always in flatshares and i have never had"
				+ "problems with my flatmates.");
		userDao.save(bernerBaer);

		// Another advertiser & searcher
		User oprah = createUser("oprah@winfrey.com", "password", "Oprah", "Winfrey",
				"/img/test/oprah.jpg", Gender.FEMALE, "Premium",  "Alpenstrasse 35", "Bern", 3000);
		oprah.setAboutMe(getDummyText());
		userDao.save(oprah);
	}

	public User createUser(String email, String password, String firstName,
			String lastName, String picPath, Gender gender, String account) {
		User user = new User();
		user.setUsername(email);
		user.setPassword(password);
		user.setEmail(email);
		user.setFirstName(firstName);
		user.setLastName(lastName);
		user.setEnabled(true);
		user.setGender(gender);
		user.setAccount(account);
		Set<UserRole> userRoles = new HashSet<>();
		UserRole role = new UserRole();
		UserPicture picture = new UserPicture();
		picture.setUser(user);
		picture.setFilePath(picPath);
		user.setPicture(picture);
		role.setRole("ROLE_USER");
		role.setUser(user);
		userRoles.add(role);
		user.setUserRoles(userRoles);
		return user;
	}

	public User createUser(String email, String password, String firstName,
			String lastName, String picPath, Gender gender, String account, String street, String city, int zipcode) {
		User user = new User();
		user.setUsername(email);
		user.setPassword(password);
		user.setEmail(email);
		user.setFirstName(firstName);
		user.setLastName(lastName);
		user.setEnabled(true);
		user.setGender(gender);
		user.setAccount(account);
		user.setStreet(street);
		user.setCity(city);
		user.setZipcode(zipcode);
		Set<UserRole> userRoles = new HashSet<>();
		UserRole role = new UserRole();
		UserPicture picture = new UserPicture();
		picture.setUser(user);
		picture.setFilePath(picPath);
		user.setPicture(picture);
		role.setRole("ROLE_USER");
		role.setUser(user);
		userRoles.add(role);
		user.setUserRoles(userRoles);
		return user;
	}

	private String getDummyText() {
		return "I am a Master student from switzerland. I'm 25 years old, "
				+ "my hobbies are summer-sports, hiking, traveling and cooking. "
				+ "I enjoy spending time with friends, watching movies, "
				+ "going for drinks and organizing dinners. I have lived in Fr�km�ntegg, "
				+ "London and Zurich, always in flatshares and i have never had "
				+ "problems with my flatmates because I am a nice person.";
	}

}

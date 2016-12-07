package ch.unibe.ese.team1.test.testData;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ch.unibe.ese.team1.model.Ad;
import ch.unibe.ese.team1.model.AdPicture;
import ch.unibe.ese.team1.model.User;
import ch.unibe.ese.team1.model.dao.AdDao;
import ch.unibe.ese.team1.model.dao.UserDao;

/** This inserts several ad elements into the database. */
@Service
public class AdTestDataSaver {

	@Autowired
	private AdDao adDao;
	@Autowired
	private UserDao userDao;

	@Transactional
	public void saveTestData() throws Exception {
		User bernerBaer = userDao.findByUsername("user@bern.com");
		User ese = userDao.findByUsername("ese@unibe.ch");
		User oprah = userDao.findByUsername("oprah@winfrey.com");
		User jane = userDao.findByUsername("jane@doe.com");

		SimpleDateFormat formatter = new SimpleDateFormat("dd.MM.yyyy");

		Date creationDate1 = formatter.parse("03.10.2014");
		Date creationDate2 = formatter.parse("11.10.2014");
		Date creationDate3 = formatter.parse("25.10.2014");
		Date creationDate4 = formatter.parse("02.11.2014");
		Date creationDate5 = formatter.parse("25.11.2013");
		Date creationDate6 = formatter.parse("01.12.2014");
		Date creationDate7 = formatter.parse("16.11.2014");
		Date creationDate8 = formatter.parse("27.11.2014");

		Date moveInDate1 = formatter.parse("15.12.2014");
		Date moveInDate2 = formatter.parse("21.12.2014");
		Date moveInDate3 = formatter.parse("01.01.2015");
		Date moveInDate4 = formatter.parse("15.01.2015");
		Date moveInDate5 = formatter.parse("01.02.2015");
		Date moveInDate6 = formatter.parse("01.03.2015");
		Date moveInDate7 = formatter.parse("15.03.2015");
		Date moveInDate8 = formatter.parse("16.02.2015");

		Date moveOutDate1 = formatter.parse("31.03.2015");
		Date moveOutDate2 = formatter.parse("30.04.2015");
		Date moveOutDate3 = formatter.parse("31.03.2016");
		Date moveOutDate4 = formatter.parse("01.07.2015");
		Date moveOutDate5 = formatter.parse("30.09.2016");

		String roomDescription1 = "The room is a part of 3.5 rooms apartment completely renovated"
				+ "in 2010 at Kramgasse, Bern. The apartment is about 50 m2 on 1st floor."
				+ "Apt is equipped modern kitchen, hall and balcony. Near to shops and public"
				+ "transportation. Monthly rent is 500 CHF including charges. Internet + TV + landline"
				+ "charges are separate. If you are interested, feel free to drop me a message"
				+ "to have an appointment for a visit or can write me for any further information";
		String preferences1 = "Uncomplicated, open minded and easy going person (m / w),"
				+ "non-smoker, can speak English, which of course fits in the WG, and who likes dogs."
				+ "Cleanliness is must. Apart from personal life, sometimes glass of wine,"
				+ "eat and cook together and go out in the evenings.";

		Ad adBern = new Ad();
		adBern.setZipcode(3011);
		adBern.setMoveInDate(moveInDate1);
		adBern.setCreationDate(creationDate1);
		adBern.setMoveOutDate(moveOutDate1);
		adBern.setPrize(400);
		adBern.setSquareFootage(50);
		adBern.setRoomType("Room");
		adBern.setSmokers(false);
		adBern.setAnimals(true);
		adBern.setRoomDescription(roomDescription1);
		adBern.setPreferences(preferences1);
		adBern.setUser(bernerBaer);
		adBern.setTitle("Roommate wanted in Bern");
		adBern.setStreet("Kramgasse 22");
		adBern.setCity("Bern");
		adBern.setLatitude("46.9479762");
		adBern.setLongitude("7.450508799999966");
		adBern.setGarden(true);
		adBern.setBalcony(true);
		adBern.setCellar(true);
		adBern.setFurnished(true);
		adBern.setCable(true);
		adBern.setGarage(true);
		adBern.setInternet(true);
		List<AdPicture> pictures = new ArrayList<>();
		pictures.add(createPicture(adBern, "/img/test/ad1_1.jpg"));
		pictures.add(createPicture(adBern, "/img/test/ad1_2.jpg"));
		pictures.add(createPicture(adBern, "/img/test/ad1_3.jpg"));
		adBern.setPictures(pictures);
		adDao.save(adBern);

		String studioDescription2 = "It is small studio close to the"
				+ "university and the bahnhof. The lovely neighbourhood"
				+ "Langgasse makes it an easy place to feel comfortable."
				+ "The studio is close to a Migross, Denner and the Coop."
				+ "The studio is 60m2. It has it own Badroom and kitchen."
				+ "Nothing is shared. The studio is fully furnished. The"
				+ "studio is also provided with a balcony. So if you want to"
				+ "have a privat space this could totally be good place for you."
				+ "Be aware it is only till the end of March. The price is from"
				+ "550- 700 CHF, But there is always room to talk about it.";
		String roomPreferences2 = "I would like to have an easy going person who"
				+ "is trustworthy and can take care of the flat. No animals please."
				+ "Non smoker preferred.";

		Ad adBern2 = new Ad();
		adBern2.setZipcode(3012);
		adBern2.setMoveInDate(moveInDate2);
		adBern2.setCreationDate(creationDate2);
		adBern2.setMoveOutDate(moveOutDate4);
		adBern2.setPrize(700);
		adBern2.setSquareFootage(60);
		adBern2.setRoomType("Studio");
		adBern2.setSmokers(false);
		adBern2.setAnimals(true);
		adBern2.setRoomDescription(studioDescription2);
		adBern2.setPreferences(roomPreferences2);
		adBern2.setUser(ese);
		adBern2.setTitle("Cheap studio in Bern!");
		adBern2.setStreet("L�ngassstr. 40");
		adBern2.setCity("Bern");
		adBern2.setLatitude("46.95401489999999");
		adBern2.setLongitude("7.431525299999976");
		adBern2.setGarden(false);
		adBern2.setBalcony(false);
		adBern2.setCellar(false);
		adBern2.setFurnished(false);
		adBern2.setCable(false);
		adBern2.setGarage(false);
		adBern2.setInternet(true);
		pictures = new ArrayList<>();
		pictures.add(createPicture(adBern2, "/img/test/ad2_1.jpg"));
		pictures.add(createPicture(adBern2, "/img/test/ad2_2.jpg"));
		pictures.add(createPicture(adBern2, "/img/test/ad2_3.jpg"));
		adBern2.setPictures(pictures);
		adBern2.setBuyable(true);
		adDao.save(adBern2);

		String studioDescription3 = " In the center of Gundeli (5 Min. away from the"
				+ "station, close to Tellplatz) there is a lovely house, covered with"
				+ "savage wine stocks, without any neighbours but with a garden. The"
				+ "house has two storey, on the first floor your new room is waiting"
				+ "for you. The house is totally equipped with everything a household "
				+ ": washing machine, kitchen, batroom, W-Lan...if you don't have any"
				+ "furniture, don't worry, I am sure, we will find something around"
				+ "the house. The price for the room and all included is 480 CHF /month. "
				+ " (29, Graphic designer) and Linda (31, curator) are looking for a"
				+ "new female flatmate from December on.";
		String roomPreferences3 = "smoking female flatmate";

		Ad adBasel = new Ad();
		adBasel.setZipcode(4051);
		adBasel.setMoveInDate(moveInDate3);
		adBasel.setMoveOutDate(moveOutDate2);
		adBasel.setCreationDate(creationDate3);
		adBasel.setPrize(480);
		adBasel.setSquareFootage(10);
		adBasel.setRoomType("Studio");
		adBasel.setSmokers(true);
		adBasel.setAnimals(false);
		adBasel.setRoomDescription(studioDescription3);
		adBasel.setPreferences(roomPreferences3);
		adBasel.setUser(bernerBaer);
		adBasel.setTitle("Nice, bright studio in the center of Basel");
		adBasel.setStreet("Bruderholzstrasse 32");
		adBasel.setCity("Basel");
		adBasel.setLatitude("47.5436664");
		adBasel.setLongitude("7.594016699999997");
		adBasel.setGarden(false);
		adBasel.setBalcony(false);
		adBasel.setCellar(false);
		adBasel.setFurnished(false);
		adBasel.setCable(false);
		adBasel.setGarage(false);
		adBasel.setInternet(false);
		pictures = new ArrayList<>();
		pictures.add(createPicture(adBasel, "/img/test/ad3_1.jpg"));
		pictures.add(createPicture(adBasel, "/img/test/ad3_2.jpg"));
		pictures.add(createPicture(adBasel, "/img/test/ad3_3.jpg"));
		adBasel.setPictures(pictures);
		adDao.save(adBasel);

		String studioDescription4 = "Flatshare of 3 persons. Flat with 5 rooms"
				+ "on the second floor. The bedroom is about 60 square meters"
				+ "with access to a nice balcony. In addition to the room, the"
				+ "flat has: a living room, a kitchen, a bathroom, a seperate WC,"
				+ "a storage in the basement, a balcony, a laundry room in the basement."
				+ "The bedroom is big and bright and has a nice parquet floor."
				+ "Possibility to keep some furnitures like the bed.";
		String roomPreferences4 = "an easy going flatmate man or woman between 20 and 30";

		Ad adOlten = new Ad();
		adOlten.setZipcode(4600);
		adOlten.setMoveInDate(moveInDate4);
		adOlten.setCreationDate(creationDate4);
		adOlten.setPrize(430);
		adOlten.setSquareFootage(60);
		adOlten.setRoomType("Room");
		adOlten.setSmokers(true);
		adOlten.setAnimals(false);
		adOlten.setRoomDescription(studioDescription4);
		adOlten.setPreferences(roomPreferences4);
		adOlten.setUser(ese);
		adOlten.setTitle("Roommate wanted in Olten City");
		adOlten.setStreet("Zehnderweg 5");
		adOlten.setCity("Olten");
		adOlten.setLatitude("47.35264660000001");
		adOlten.setLongitude("7.899488000000019");
		adOlten.setGarden(false);
		adOlten.setBalcony(true);
		adOlten.setCellar(true);
		adOlten.setFurnished(true);
		adOlten.setCable(true);
		adOlten.setGarage(false);
		adOlten.setInternet(false);
		pictures = new ArrayList<>();
		pictures.add(createPicture(adOlten, "/img/test/ad4_1.png"));
		pictures.add(createPicture(adOlten, "/img/test/ad4_2.png"));
		pictures.add(createPicture(adOlten, "/img/test/ad4_3.png"));
		adOlten.setPictures(pictures);
		adDao.save(adOlten);

		String studioDescription5 = "Studio meublé au 3ième étage, comprenant"
				+ "une kitchenette entièrement équipée (frigo, plaques,"
				+ "four et hotte), une pièce à vivre donnant sur un balcon,"
				+ "une salle de bains avec wc. Cave, buanderie et site satellite"
				+ "à disposition.";
		String roomPreferences5 = "tout le monde est bienvenu";

		Ad adNeuch�tel = new Ad();
		adNeuch�tel.setZipcode(2000);
		adNeuch�tel.setMoveInDate(moveInDate5);
		adNeuch�tel.setMoveOutDate(moveOutDate3);
		adNeuch�tel.setCreationDate(creationDate5);
		adNeuch�tel.setPrize(410);
		adNeuch�tel.setSquareFootage(40);
		adNeuch�tel.setRoomType("Studio");
		adNeuch�tel.setSmokers(true);
		adNeuch�tel.setAnimals(false);
		adNeuch�tel.setRoomDescription(studioDescription5);
		adNeuch�tel.setPreferences(roomPreferences5);
		adNeuch�tel.setUser(bernerBaer);
		adNeuch�tel.setTitle("Studio extramement bon marche � Neuch�tel");
		adNeuch�tel.setStreet("Rue de l'H�pital 11");
		adNeuch�tel.setCity("Neuch�tel");
		adNeuch�tel.setLatitude("46.99171680000001");
		adNeuch�tel.setLongitude("6.9297438999999485");
		adNeuch�tel.setGarden(true);
		adNeuch�tel.setBalcony(false);
		adNeuch�tel.setCellar(true);
		adNeuch�tel.setFurnished(true);
		adNeuch�tel.setCable(false);
		adNeuch�tel.setGarage(false);
		adNeuch�tel.setInternet(true);

		pictures = new ArrayList<>();
		pictures.add(createPicture(adNeuch�tel, "/img/test/ad5_1.jpg"));
		pictures.add(createPicture(adNeuch�tel, "/img/test/ad5_2.jpg"));
		pictures.add(createPicture(adNeuch�tel, "/img/test/ad5_3.jpg"));
		adNeuch�tel.setPictures(pictures);
		adDao.save(adNeuch�tel);

		String studioDescription6 = "A place just for yourself in a very nice part of Biel."
				+ "A studio for 1-2 persons with a big balcony, bathroom, kitchen and furniture already there."
				+ "It's quiet and nice, very close to the old city of Biel.";
		String roomPreferences6 = "A nice and easy going person. Minimum rent is two months";

		Ad adBiel = new Ad();
		adBiel.setZipcode(2503);
		adBiel.setMoveInDate(moveInDate6);
		adBiel.setMoveOutDate(moveOutDate5);
		adBiel.setCreationDate(creationDate6);
		adBiel.setPrize(480);
		adBiel.setSquareFootage(10);
		adBiel.setRoomType("Studio");
		adBiel.setSmokers(true);
		adBiel.setAnimals(false);
		adBiel.setRoomDescription(studioDescription6);
		adBiel.setPreferences(roomPreferences6);
		adBiel.setUser(ese);
		adBiel.setTitle("Direkt am Quai: nette, kleine Studio");
		adBiel.setStreet("Oberer Quai 12");
		adBiel.setCity("Biel/Bienne");
		adBiel.setLatitude("47.1372995");
		adBiel.setLongitude("7.247914000000037");
		adBiel.setGarden(false);
		adBiel.setBalcony(false);
		adBiel.setCellar(false);
		adBiel.setFurnished(false);
		adBiel.setCable(false);
		adBiel.setGarage(false);
		adBiel.setInternet(false);
		pictures = new ArrayList<>();
		pictures.add(createPicture(adBiel, "/img/test/ad6_1.png"));
		pictures.add(createPicture(adBiel, "/img/test/ad6_2.png"));
		pictures.add(createPicture(adBiel, "/img/test/ad6_3.png"));
		adBiel.setPictures(pictures);
		adDao.save(adBiel);


		String roomDescription7 = "The room is a part of 3.5 rooms apartment completely renovated"
				+ "in 2010 at Kramgasse, Bern. The apartment is about 50 m2 on 1st floor."
				+ "Apt is equipped modern kitchen, hall and balcony. Near to shops and public"
				+ "transportation. Monthly rent is 500 CHF including charges. Internet + TV + landline"
				+ "charges are separate. If you are interested, feel free to drop me a message"
				+ "to have an appointment for a visit or can write me for any further information";
		String preferences7 = "Uncomplicated, open minded and easy going person (m / w),"
				+ "non-smoker, can speak English, which of course fits in the WG, and who likes dogs."
				+ "Cleanliness is must. Apart from personal life, sometimes glass of wine,"
				+ "eat and cook together and go out in the evenings.";

		Ad adEinsiedeln = new Ad();
		adEinsiedeln.setZipcode(8840);
		adEinsiedeln.setMoveInDate(moveInDate7);
		adEinsiedeln.setCreationDate(creationDate7);
		adEinsiedeln.setMoveOutDate(moveOutDate5);
		adEinsiedeln.setPrize(480);
		adEinsiedeln.setSquareFootage(32);
		adEinsiedeln.setRoomType("Room");
		adEinsiedeln.setSmokers(false);
		adEinsiedeln.setAnimals(false);
		adEinsiedeln.setRoomDescription(roomDescription7);
		adEinsiedeln.setPreferences(preferences7);
		adEinsiedeln.setUser(oprah);
		adEinsiedeln.setTitle("Roommate wanted in Einsiedeln");
		adEinsiedeln.setStreet("Hauptstrasse 61");
		adEinsiedeln.setCity("Einsiedeln");
		adEinsiedeln.setLatitude("47.1272423");
		adEinsiedeln.setLongitude("8.747624900000005");
		adEinsiedeln.setGarden(false);
		adEinsiedeln.setBalcony(true);
		adEinsiedeln.setCellar(false);
		adEinsiedeln.setFurnished(true);
		adEinsiedeln.setCable(true);
		adEinsiedeln.setGarage(true);
		adEinsiedeln.setInternet(true);
		pictures = new ArrayList<>();
		pictures.add(createPicture(adEinsiedeln, "/img/test/ad1_3.jpg"));
		pictures.add(createPicture(adEinsiedeln, "/img/test/ad1_2.jpg"));
		pictures.add(createPicture(adEinsiedeln, "/img/test/ad1_1.jpg"));
		adEinsiedeln.setPictures(pictures);
		adDao.save(adEinsiedeln);


		String studioDescription8 = "It is small studio close to the"
				+ "university and the bahnhof. The lovely neighbourhood"
				+ "Langgasse makes it an easy place to feel comfortable."
				+ "The studio is close to a Migross, Denner and the Coop."
				+ "The studio is 60m2. It has it own Badroom and kitchen."
				+ "Nothing is shared. The studio is fully furnished. The"
				+ "studio is also provided with a balcony. So if you want to"
				+ "have a privat space this could totally be good place for you."
				+ "Be aware it is only till the end of March. The price is from"
				+ "550- 700 CHF, But there is always room to talk about it.";
		String roomPreferences8 = "I would like to have an easy going person who"
				+ "is trustworthy and can take care of the flat. No animals please."
				+ "Non smoker preferred.";

		Ad adLuzern = new Ad();
		adLuzern.setZipcode(6000);
		adLuzern.setMoveInDate(moveInDate8);
		adLuzern.setCreationDate(creationDate2);
		adLuzern.setPrize(700);
		adLuzern.setSquareFootage(60);
		adLuzern.setRoomType("Studio");
		adLuzern.setSmokers(false);
		adLuzern.setAnimals(false);
		adLuzern.setRoomDescription(studioDescription8);
		adLuzern.setPreferences(roomPreferences8);
		adLuzern.setUser(oprah);
		adLuzern.setTitle("Elegant Studio in Lucerne");
		adLuzern.setStreet("Schwanenplatz 61");
		adLuzern.setCity("Luzern");
		adLuzern.setLatitude("47.05366799999999");
		adLuzern.setLongitude("8.308716499999945");
		adLuzern.setGarden(false);
		adLuzern.setBalcony(false);
		adLuzern.setCellar(false);
		adLuzern.setFurnished(false);
		adLuzern.setCable(false);
		adLuzern.setGarage(false);
		adLuzern.setInternet(true);
		pictures = new ArrayList<>();
		pictures.add(createPicture(adLuzern, "/img/test/ad2_3.jpg"));
		pictures.add(createPicture(adLuzern, "/img/test/ad2_2.jpg"));
		pictures.add(createPicture(adLuzern, "/img/test/ad2_1.jpg"));
		adLuzern.setPictures(pictures);
		adDao.save(adLuzern);

		String studioDescription9 = " In the center of Gundeli (5 Min. away from the"
				+ "station, close to Tellplatz) there is a lovely house, covered with"
				+ "savage wine stocks, without any neighbours but with a garden. The"
				+ "house has two storey, on the first floor your new room is waiting"
				+ "for you. The house is totally equipped with everything a household "
				+ ": washing machine, kitchen, batroom, W-Lan...if you don't have any"
				+ "furniture, don't worry, I am sure, we will find something around"
				+ "the house. The price for the room and all included is 480 CHF /month. "
				+ " (29, Graphic designer) and Linda (31, curator) are looking for a"
				+ "new female flatmate from December on.";
		String roomPreferences9 = "smoking female flatmate";

		Ad adAarau = new Ad();
		adAarau.setZipcode(5000);
		adAarau.setMoveInDate(moveInDate3);
		adAarau.setMoveOutDate(moveOutDate4);
		adAarau.setCreationDate(creationDate8);
		adAarau.setPrize(800);
		adAarau.setSquareFootage(26);
		adAarau.setRoomType("Studio");
		adAarau.setSmokers(true);
		adAarau.setAnimals(false);
		adAarau.setRoomDescription(studioDescription9);
		adAarau.setPreferences(roomPreferences9);
		adAarau.setUser(oprah);
		adAarau.setTitle("Beautiful studio in Aarau");
		adAarau.setStreet("Bleichemattstrasse 42");
		adAarau.setCity("Aarau");
		adAarau.setLatitude("47.3900495");
		adAarau.setLongitude("8.055630000000064");
		adAarau.setGarden(false);
		adAarau.setBalcony(true);
		adAarau.setCellar(false);
		adAarau.setFurnished(true);
		adAarau.setCable(false);
		adAarau.setGarage(false);
		adAarau.setInternet(false);
		pictures = new ArrayList<>();
		pictures.add(createPicture(adAarau, "/img/test/ad3_3.jpg"));
		pictures.add(createPicture(adAarau, "/img/test/ad3_2.jpg"));
		pictures.add(createPicture(adAarau, "/img/test/ad3_1.jpg"));
		pictures.add(createPicture(adAarau, "/img/test/ad2_2.jpg"));
		pictures.add(createPicture(adAarau, "/img/test/ad2_3.jpg"));

		adAarau.setPictures(pictures);
		adDao.save(adAarau);

		String studioDescription10 = "Flatshare of 3 persons. Flat with 5 rooms"
				+ "on the second floor. The bedroom is about 60 square meters"
				+ "with access to a nice balcony. In addition to the room, the"
				+ "flat has: a living room, a kitchen, a bathroom, a seperate WC,"
				+ "a storage in the basement, a balcony, a laundry room in the basement."
				+ "The bedroom is big and bright and has a nice parquet floor."
				+ "Possibility to keep some furnitures like the bed.";
		String roomPreferences10 = "an easy going flatmate man or woman between 20 and 30";

		Ad adDavos = new Ad();
		adDavos.setZipcode(7270);
		adDavos.setMoveInDate(moveInDate2);
		adDavos.setCreationDate(creationDate4);
		adDavos.setPrize(1100);
		adDavos.setSquareFootage(74);
		adDavos.setRoomType("Room");
		adDavos.setSmokers(true);
		adDavos.setAnimals(false);
		adDavos.setRoomDescription(studioDescription10);
		adDavos.setPreferences(roomPreferences10);
		adDavos.setUser(oprah);
		adDavos.setTitle("Free room in Davos City");
		adDavos.setStreet("Scalettastrasse 22");
		adDavos.setCity("Davos");
		adDavos.setLatitude("46.8021276");
		adDavos.setLongitude("9.833322100000032");
		adDavos.setGarden(false);
		adDavos.setBalcony(true);
		adDavos.setCellar(true);
		adDavos.setFurnished(true);
		adDavos.setCable(true);
		adDavos.setGarage(false);
		adDavos.setInternet(false);
		pictures = new ArrayList<>();
		pictures.add(createPicture(adDavos, "/img/test/ad4_3.png"));
		pictures.add(createPicture(adDavos, "/img/test/ad4_2.png"));
		pictures.add(createPicture(adDavos, "/img/test/ad4_1.png"));
		adDavos.setPictures(pictures);
		adDao.save(adDavos);

		String studioDescription11 = "Studio meublé au 3ième étage, comprenant"
				+ "une kitchenette entièrement équipée (frigo, plaques,"
				+ "four et hotte), une pièce à vivre donnant sur un balcon,"
				+ "une salle de bains avec wc. Cave, buanderie et site satellite"
				+ "à disposition.";
		String roomPreferences11 = "tout le monde est bienvenu";

		Ad adLausanne = new Ad();
		adLausanne.setZipcode(1006);
		adLausanne.setMoveInDate(moveInDate5);
		adLausanne.setMoveOutDate(moveOutDate3);
		adLausanne.setCreationDate(creationDate5);
		adLausanne.setPrize(360);
		adLausanne.setSquareFootage(8);
		adLausanne.setRoomType("Room");
		adLausanne.setSmokers(true);
		adLausanne.setAnimals(false);
		adLausanne.setRoomDescription(studioDescription11);
		adLausanne.setPreferences(roomPreferences11);
		adLausanne.setUser(oprah);
		adLausanne.setTitle("Studio extramement bon marche � Lausanne");
		adLausanne.setStreet("Rue du Cr�t 10");
		adLausanne.setCity("Lausanne");
		adLausanne.setLatitude("46.5157907");
		adLausanne.setLongitude("6.6242207000000235");
		adLausanne.setGarden(true);
		adLausanne.setBalcony(false);
		adLausanne.setCellar(true);
		adLausanne.setFurnished(true);
		adLausanne.setCable(false);
		adLausanne.setGarage(false);
		adLausanne.setInternet(false);
		pictures = new ArrayList<>();
		pictures.add(createPicture(adLausanne, "/img/test/ad5_3.jpg"));
		pictures.add(createPicture(adLausanne, "/img/test/ad5_2.jpg"));
		pictures.add(createPicture(adLausanne, "/img/test/ad5_1.jpg"));
		adLausanne.setPictures(pictures);
		adDao.save(adLausanne);

		String studioDescription12 = "A place just for yourself in a very nice part of Biel."
				+ "A studio for 1-2 persons with a big balcony, bathroom, kitchen and furniture already there."
				+ "It's quiet and nice, very close to the old city of Biel.";
		String roomPreferences12 = "A nice and easy going person. Minimum rent is two months";

		Ad adLocarno = new Ad();
		adLocarno.setZipcode(6600);
		adLocarno.setMoveInDate(moveInDate6);
		adLocarno.setMoveOutDate(moveOutDate5);
		adLocarno.setCreationDate(creationDate6);
		adLocarno.setPrize(960);
		adLocarno.setSquareFootage(42);
		adLocarno.setRoomType("Room");
		adLocarno.setSmokers(true);
		adLocarno.setAnimals(false);
		adLocarno.setRoomDescription(studioDescription12);
		adLocarno.setPreferences(roomPreferences12);
		adLocarno.setUser(jane);
		adLocarno.setTitle("Malibu-style Beachhouse");
		adLocarno.setStreet("Via Angelo Baroffio 2B");
		adLocarno.setCity("Locarno");
		adLocarno.setLatitude("46.1655315");
		adLocarno.setLongitude("8.798764600000026");
		adLocarno.setGarden(false);
		adLocarno.setBalcony(false);
		adLocarno.setCellar(false);
		adLocarno.setFurnished(false);
		adLocarno.setCable(false);
		adLocarno.setGarage(false);
		adLocarno.setInternet(false);
		pictures = new ArrayList<>();
		pictures.add(createPicture(adLocarno, "/img/test/ad6_3.png"));
		pictures.add(createPicture(adLocarno, "/img/test/ad6_2.png"));
		pictures.add(createPicture(adLocarno, "/img/test/ad6_1.png"));
		adLocarno.setPictures(pictures);
		adDao.save(adLocarno);

	}

	private AdPicture createPicture(Ad ad, String filePath) {
		AdPicture picture = new AdPicture();
		picture.setFilePath(filePath);
		return picture;
	}
}

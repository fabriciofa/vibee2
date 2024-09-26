package com.mfqueiroga.vibee.config;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.mfqueiroga.vibee.entities.Beehive;
import com.mfqueiroga.vibee.entities.Localization;
import com.mfqueiroga.vibee.entities.Notification;
import com.mfqueiroga.vibee.entities.User;
import com.mfqueiroga.vibee.entities.enums.Bees;
import com.mfqueiroga.vibee.entities.enums.Diseases;
import com.mfqueiroga.vibee.repositories.BeehiveRepository;
import com.mfqueiroga.vibee.repositories.LocalizationRepository;
import com.mfqueiroga.vibee.repositories.NotificationRepository;
import com.mfqueiroga.vibee.repositories.UserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private LocalizationRepository localizationRepository;

	@Autowired
	private BeehiveRepository beehiveRepository;
	
	@Autowired
	private NotificationRepository notificationRepository;

	@Override
	public void run(String... args) throws Exception {

		User u1 = new User(null, "Maria Brown", "maria@gmail.com", "123456");
		User u2 = new User(null, "Alex Green", "alex@gmail.com", "123456");

		userRepository.saveAll(Arrays.asList(u1, u2));

		Localization l1 = new Localization(new BigDecimal(-2.5556003217212226),
				new BigDecimal(-44.25125126348713));
		Localization l2 = new Localization(new BigDecimal(-2.544647539002137),
				new BigDecimal(-44.25272596717743));

		localizationRepository.saveAll(Arrays.asList(l1, l2));

		Beehive b1 = new Beehive(null, Bees.ABELHA_EUROPEIA_APIS_MELLIFERA, l1, u1);
		Beehive b2 = new Beehive(null, Bees.ABELHA_AFRICANIZADA, l2, u2);
		Beehive b3 = new Beehive(null, Bees.ABELHA_NATIVA_SEM_FERRAO_MELIPONINEOS, l2, u2);

		beehiveRepository.saveAll(Arrays.asList(b1, b2,b3));

		Notification n1 = new Notification(null, u2, l2, Instant.parse("2024-09-25T15:24:05Z"),Diseases.CRIA_ENSACADA,true);
		Notification n2 = new Notification(null, u1, l1, Instant.parse("2024-09-15T15:24:05Z"),Diseases.CRIA_PUTRIDA_EUROPEIA,true);
		
		notificationRepository.saveAll(Arrays.asList(n1,n2));
	}

}

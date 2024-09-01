package com.mfqueiroga.vibee.config;

import java.math.BigDecimal;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.mfqueiroga.vibee.entities.Beehive;
import com.mfqueiroga.vibee.entities.Localization;
import com.mfqueiroga.vibee.entities.User;
import com.mfqueiroga.vibee.repositories.BeehiveRepository;
import com.mfqueiroga.vibee.repositories.LocalizationRepository;
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

	@Override
	public void run(String... args) throws Exception {

		User u1 = new User(null, "Maria Brown", "maria@gmail.com", "123456");
		User u2 = new User(null, "Alex Green", "alex@gmail.com", "123456");

		userRepository.saveAll(Arrays.asList(u1, u2));

		Localization l1 = new Localization(null, new BigDecimal(-2.5556003217212226),
				new BigDecimal(-44.25125126348713));
		Localization l2 = new Localization(null, new BigDecimal(-2.544647539002137),
				new BigDecimal(-44.25272596717743));

		localizationRepository.saveAll(Arrays.asList(l1, l2));

		Beehive b1 = new Beehive(null, "Apimel", l1, u1);
		Beehive b2 = new Beehive(null, "Melbom", l2, u2);
		Beehive b3 = new Beehive(null, "Meumel", l2, u2);

		beehiveRepository.saveAll(Arrays.asList(b1, b2,b3));

	}

}

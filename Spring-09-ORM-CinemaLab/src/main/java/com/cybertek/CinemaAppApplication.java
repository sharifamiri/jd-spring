package com.cybertek;

import com.cybertek.repository.AccountRepository;
import com.cybertek.repository.CinemaRepository;
import com.cybertek.repository.MovieCinemaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;

@SpringBootApplication
public class CinemaAppApplication {

	@Autowired
	AccountRepository accountRepository;
	@Autowired
	CinemaRepository cinemaRepository;
	@Autowired
	MovieCinemaRepository movieCinemaRepository;

	public static void main(String[] args) {
		SpringApplication.run(CinemaAppApplication.class, args);
	}

	@PostConstruct
	void testAccount(){
		System.out.println(accountRepository.fetchAdminUsers());
		System.out.println(cinemaRepository.findDistinctBySponsoredName());
		System.out.println(movieCinemaRepository.countAllByCinemaId(4L));
		System.out.println(movieCinemaRepository.retrieveAllByLocationName("AMC Empire 25"));
	}

}

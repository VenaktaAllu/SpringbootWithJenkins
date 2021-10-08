package com.jenkins.SpringbootwithJenkins;

import com.jenkins.SpringbootwithJenkins.Entity.Ride;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.jenkins.SpringbootwithJenkins.repository.RideRepo;

@SpringBootApplication
public class SpringbootwithJenkinsApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootwithJenkinsApplication.class, args);
	}

	public CommandLineRunner sampleData(RideRepo rideRepo){
		return (args) -> {
			rideRepo.save(new Ride("Acura","premium and AWD", 150, 4));
			rideRepo.save(new Ride("Mache","CA RTE 1 and RWD", 100, 5));
			rideRepo.save(new Ride("Audi","A3 and Front wheel", 160, 3));
		};
	}

}

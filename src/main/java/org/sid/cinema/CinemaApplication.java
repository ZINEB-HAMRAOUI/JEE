package org.sid.cinema;
import org.sid.cinema.dao.CinemaRepository;
import org.sid.cinema.entities.Film; 
import org.sid.cinema.service.ICinemaInitService1;
import org.springframework.beans.factory.annotation.Autowired;import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.jpa.JpaRepositoriesAutoConfiguration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

@SpringBootApplication
//@SpringBootApplication(scanBasePackages = {"boot.registration"} , exclude = JpaRepositoriesAutoConfiguration.class)


public class CinemaApplication implements CommandLineRunner {
@Autowired private ICinemaInitService1 cinemaInitService;
@Autowired private RepositoryRestConfiguration restConfiguration;
public static void main(String[] args) {
SpringApplication.run(CinemaApplication.class, args);
}
@Override
public void run(String... args) throws Exception {
restConfiguration.exposeIdsFor(Film.class);
cinemaInitService.initVilles(); cinemaInitService.initCinemas();
cinemaInitService.initSalles(); cinemaInitService.initPlaces();
cinemaInitService.initSeances(); cinemaInitService.initCategories();
cinemaInitService.initFilms();cinemaInitService.initProjections();
cinemaInitService.initTickets();
}
}
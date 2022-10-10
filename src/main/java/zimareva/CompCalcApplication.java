package zimareva;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import zimareva.model.City;
import zimareva.model.Competition;
import zimareva.model.User;
import zimareva.model.UserCompetition;
import zimareva.repository.UserCompetitionRepository;
import zimareva.service.CityService;
import zimareva.service.CompetitionService;
import zimareva.service.UserCompetitionService;
import zimareva.service.UserService;

import java.time.LocalDate;

@SpringBootApplication
public class CompCalcApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext configurableApplicationContext =
                SpringApplication.run(CompCalcApplication.class, args);

        //Add city
        CityService cityService =
                configurableApplicationContext.getBean(CityService.class);
        City city = new City("Samara");
        cityService.addCity(city);

        //Add 2 users
        UserService userService =
                configurableApplicationContext.getBean(UserService.class);
        User user1 = new User("Zimareva","Irina","Igorevna",city);
        User user2 = new User("Ondra","Adam"," ",city);
        userService.addUser(user1);
        userService.addUser(user2);

        //Add competition
        CompetitionService competitionService =
                configurableApplicationContext.getBean(CompetitionService.class);
        Competition competition = new Competition("Championship", LocalDate.now(), 1, city);
        competitionService.addCompetition(competition);

        //Registration to comp - не работает
        UserCompetitionService userCompetitionService =
                configurableApplicationContext.getBean(UserCompetitionService.class);
//        userCompetitionService.addUserCompetition(user1.getId(),competition.getId());


    }

}

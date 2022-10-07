package zimareva;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import zimareva.model.City;
import zimareva.model.User;
import zimareva.repository.CityRepository;
import zimareva.repository.UserRepository;

@SpringBootApplication
public class CompCalcApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext configurableApplicationContext =
                SpringApplication.run(CompCalcApplication.class, args);
        CityRepository cityRepository =
                configurableApplicationContext.getBean(CityRepository.class);
        City city = new City("Samara");
        cityRepository.save(city);

        UserRepository userRepository =
                configurableApplicationContext.getBean(UserRepository.class);
        User user1 = new User("Zimareva","Irina","Igorevna",city);
        User user2 = new User("Ondra","Adam"," ",city);
        userRepository.save(user1);
        userRepository.save(user2);

    }

}

package zimareva.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import zimareva.model.Competition;
import zimareva.model.User;
import zimareva.model.UserCompetition;
import zimareva.repository.UserCompetitionRepository;

@Service
public class UserCompetitionService {

    private final UserCompetitionRepository userCompetitionRepository;
    private final UserService userService;
    private final CompetitionService competitionService;

    @Autowired
    public UserCompetitionService(UserCompetitionRepository userCompetitionRepository,
                                  UserService userService,
                                  CompetitionService competitionService) {
        this.userCompetitionRepository = userCompetitionRepository;
        this.userService = userService;
        this.competitionService = competitionService;
    }

    public void addUserCompetition(Long userId, Long competitionId){
        User user = userService.getUser(userId);
        Competition competition = competitionService.getCompetition(competitionId);
        //todo: нужна ли проверка на то зарегистрирован ли уже юзер на это соревнование или нет?
        // то есть, есть ли уже такая связь в бд или нет?
        UserCompetition userCompetition = new UserCompetition(competition, user);
        userCompetitionRepository.save(userCompetition);
        competition.addUserCompetitionRelationship(userCompetition);
        user.addUserCompetitionRelationship(userCompetition);
    }
}

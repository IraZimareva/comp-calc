package zimareva.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import zimareva.model.UserCompetition;
import zimareva.service.UserCompetitionService;

@RestController
@RequestMapping("/usertocompetition")
public class UserCompetitionController {

    private final UserCompetitionService userCompetitionService;

    @Autowired
    public UserCompetitionController(UserCompetitionService userCompetitionService) {
        this.userCompetitionService = userCompetitionService;
    }

    @PostMapping
    public void registration(@RequestBody final Long userId,
                                                        @RequestBody final Long competitionId){
        userCompetitionService.addUserCompetition(userId,competitionId);
    }
}

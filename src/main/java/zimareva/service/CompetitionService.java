package zimareva.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import zimareva.exception.CompetitionNotFoundException;
import zimareva.model.Competition;
import zimareva.repository.CompetitionRepository;

import javax.transaction.Transactional;

@Service
public class CompetitionService {

    private final CompetitionRepository competitionRepository;

    @Autowired
    public CompetitionService(CompetitionRepository competitionRepository) {
        this.competitionRepository = competitionRepository;
    }

    public Competition addCompetition(Competition competition){
        return competitionRepository.save(competition);
    }

    public Competition getCompetition(Long id){
        return competitionRepository.findById(id).orElseThrow(() ->
                new CompetitionNotFoundException(id));
    }

    @Transactional
    public Competition editCompetition(Long id, Competition competition){
        Competition competitionToEdit = getCompetition(id);
        competitionToEdit.setTitle(competition.getTitle());
        competitionToEdit.setStartDate(competition.getStartDate());
        competitionToEdit.setDaysCount(competition.getDaysCount());
        competitionToEdit.setCity(competition.getCity());
        return competitionToEdit;
    }

    /*public void addUserCompetitionRelationshipToCompetition(Competition competition, UserCompetition userCompetition){
        competition.addUserCompetitionRelationship(userCompetition);
    }*/
}

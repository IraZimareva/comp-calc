package zimareva.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import zimareva.model.ids.UserCompetitionId;

import javax.persistence.*;

@Entity
@Table(name = "user_competition")
@IdClass(UserCompetitionId.class)
public class UserCompetition {

    @Id
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "competition_id")
    @JsonIgnoreProperties("userCompetitionList")
    private Competition competition;

    @Id
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    @JsonIgnoreProperties("userCompetitionList")
    private User user;

    public UserCompetition() {
    }

    public Competition getCompetition() {
        return competition;
    }

    public void setCompetition(Competition competition) {
        this.competition = competition;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}

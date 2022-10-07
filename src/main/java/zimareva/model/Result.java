package zimareva.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import zimareva.model.ids.ResultId;

import javax.persistence.*;

@Entity
@Table(name = "result")
@IdClass(ResultId.class)
public class Result {

    @Id
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "route_id")
    @JsonIgnoreProperties("")
    private Route route;

    @Id
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    @JsonIgnoreProperties("")
    private User user;

    @Id
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "competition_id")
    @JsonIgnoreProperties("")
    private Competition competition;
    private Integer attemptsCount;

    public Result() {
    }

    public Route getRoute() {
        return route;
    }

    public void setRoute(Route route) {
        this.route = route;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Competition getCompetition() {
        return competition;
    }

    public void setCompetition(Competition competition) {
        this.competition = competition;
    }

    public Integer getAttemptsCount() {
        return attemptsCount;
    }

    public void setAttemptsCount(Integer attemptsCount) {
        this.attemptsCount = attemptsCount;
    }
}

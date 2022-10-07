package zimareva.model.ids;

import zimareva.model.Competition;
import zimareva.model.User;

import java.io.Serializable;
import java.util.Objects;

public class UserCompetitionId implements Serializable {
    private Competition competition;
    private User user;

    public UserCompetitionId() {
    }

    public UserCompetitionId(Competition competition, User user) {
        this.competition = competition;
        this.user = user;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UserCompetitionId)) return false;
        UserCompetitionId that = (UserCompetitionId) o;
        return competition.equals(that.competition) &&
                user.equals(that.user);
    }

    @Override
    public int hashCode() {
        return Objects.hash(competition, user);
    }
}

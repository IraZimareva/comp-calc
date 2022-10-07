package zimareva.model.ids;

import zimareva.model.Competition;
import zimareva.model.Route;
import zimareva.model.User;

import java.io.Serializable;
import java.util.Objects;

public class ResultId implements Serializable {
    private Route route;
    private User user;
    private Competition competition;

    public ResultId() {
    }

    public ResultId(Route route, User user, Competition competition) {
        this.route = route;
        this.user = user;
        this.competition = competition;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ResultId)) return false;
        ResultId resultId = (ResultId) o;
        return Objects.equals(route, resultId.route) &&
                Objects.equals(user, resultId.user) &&
                Objects.equals(competition, resultId.competition);
    }

    @Override
    public int hashCode() {
        return Objects.hash(route, user, competition);
    }
}

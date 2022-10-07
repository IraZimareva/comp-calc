package zimareva.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "competition")
public class Competition {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String title;
//    @Temporal(TemporalType.DATE)
    private LocalDate startDate;
    private Integer daysCount;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "city_id")
    @JsonIgnoreProperties("competitions")
    private City city;
    @OneToMany(
            mappedBy = "competition",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    @JsonIgnoreProperties("competition")
    private List<Route> routes = new ArrayList<>();
    @OneToMany(
            mappedBy = "competition",
            cascade = CascadeType.ALL
    )
    @JsonIgnoreProperties("competition")
    private List<UserCompetition> userCompetitionList = new ArrayList<>();

    public Competition() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public Integer getDaysCount() {
        return daysCount;
    }

    public void setDaysCount(Integer daysCount) {
        this.daysCount = daysCount;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public List<Route> getRoutes() {
        return routes;
    }

    public void setRoutes(List<Route> routes) {
        this.routes = routes;
    }

    public List<UserCompetition> getUserCompetitionList() {
        return userCompetitionList;
    }

    public void setUserCompetitionList(List<UserCompetition> userCompetitionList) {
        this.userCompetitionList = userCompetitionList;
    }
}

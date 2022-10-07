package zimareva.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import zimareva.model.enums.GenderEnum;
import zimareva.model.enums.RangEnum;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String lastname;
    private String firstname;
    private String secondname;
    @Enumerated(EnumType.STRING)
    private GenderEnum gender;
    @Temporal(TemporalType.DATE)
    private LocalDate dateOfBirth;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "city_id")
    @JsonIgnoreProperties("users")
    private City city;
    @Enumerated(EnumType.STRING)
    private RangEnum rang;
    private String mobilePhone;
    private String email;
    @OneToMany(
            mappedBy = "user",
            cascade = CascadeType.ALL
    )
    @JsonIgnoreProperties("user")
    private List<UserCompetition> userCompetitionList = new ArrayList<>();

    public User() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getSecondname() {
        return secondname;
    }

    public void setSecondname(String secondname) {
        this.secondname = secondname;
    }

    public GenderEnum getGender() {
        return gender;
    }

    public void setGender(GenderEnum gender) {
        this.gender = gender;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public RangEnum getRang() {
        return rang;
    }

    public void setRang(RangEnum rang) {
        this.rang = rang;
    }

    public String getMobilePhone() {
        return mobilePhone;
    }

    public void setMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<UserCompetition> getUserCompetitionList() {
        return userCompetitionList;
    }

    public void setUserCompetitionList(List<UserCompetition> userCompetitionList) {
        this.userCompetitionList = userCompetitionList;
    }
}

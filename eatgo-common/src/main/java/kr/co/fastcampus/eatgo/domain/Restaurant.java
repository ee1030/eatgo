package kr.co.fastcampus.eatgo.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Transient;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

// restaurant 객체 @Entity 어노테이션을 이용하여 JPA가 관리하게끔 만들고 restaurant 객체에 필요한 멤버들을 정의한다.
@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Restaurant {

    // @Id 어노테이션으로 PK를 성정하고 @GeneratedValue 어노테이션을 이용하여 값을 자동으로 채우도록 한다.
    @Id
    @GeneratedValue
    @Setter
    private Long id;

    private Long categoryId;

    @NotEmpty
    private String name;

    @NotEmpty
    private String address;

    // JsonInclude 어노테이션을 이용하여 menuItem이나 Review가 null값일 경우 제외하고 표시하도록 한다.
    @Transient
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private List<MenuItem> menuItems;

    @Transient
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private List<Review> reviews;

    public String getInformation() {
        return name + " in " + address;
    }

    public void updateInformation(String name, String address) {
        this.name = name;
        this.address = address;
    }

    public void setMenuItems(List<MenuItem> menuItems) {
        this.menuItems = new ArrayList<>(menuItems);
    }

    public void setReviews(List<Review> reviews) {
        this.reviews = new ArrayList<>(reviews);
    }
}

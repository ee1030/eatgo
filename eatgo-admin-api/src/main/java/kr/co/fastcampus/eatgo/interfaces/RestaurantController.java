package kr.co.fastcampus.eatgo.interfaces;

import kr.co.fastcampus.eatgo.application.RestaurantService;
import kr.co.fastcampus.eatgo.domain.Restaurant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

//레스토랑컨트롤러로써 매필을 사용하여 입력되는 url에 따라 레스토랑의 정보를 읽어오거나 입력, 수정할 수 있도록 구현
@CrossOrigin
@RestController
public class RestaurantController {

    @Autowired
    private RestaurantService restaurantService;

    @GetMapping("/restaurants")
    public List<Restaurant> list() {
        List<Restaurant> restaurants = restaurantService.getRestaurants();

        return restaurants;
    } // 데이터베이스의 모든 레스토랑 목록을 가져오는 기능

    @GetMapping("/restaurants/{id}")
    public Restaurant detail(@PathVariable("id") Long id) {
        Restaurant restaurant = restaurantService.getRestaurant(id);

        return restaurant;
    } // id의 입력값에 따라 해당되는 id의 레스토랑 상세 정보를 가져오는 기능

    @PostMapping("/restaurants")
    public ResponseEntity<?> create(@Valid @RequestBody Restaurant resource)
            throws URISyntaxException {
        String name = resource.getName();
        String address = resource.getAddress();

        Restaurant restaurant = restaurantService.addRestaurant(
                Restaurant.builder()
                        .name(name)
                        .address(address)
                        .build());

        URI location = new URI("/restaurants/" + restaurant.getId());
        return ResponseEntity.created(location).body("{}");
    } // @RequestBody 어노테이션을 이용하여 입력된 정보를 Restaurant 객체로 매핑하고 상태코드를 함께 리턴해준다.

    @PatchMapping("/restaurants/{id}")
    public String update(@PathVariable("id") Long id,
                         @Valid @RequestBody Restaurant resource) {
        String name = resource.getName();
        String address = resource.getAddress();
        restaurantService.updateRestaurant(id, name, address);

        return "{}";
    } // id값에 해당하는 레스토랑 객체의 정보를 업데이트 할 수 있는 기능 @PahVariable 어노테이션은 입력할 url에 변수를 입력할수 있도록 해준다.
}

package kr.co.fastcampus.eatgo.application;

import kr.co.fastcampus.eatgo.domain.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class RestaurantService {

    private RestaurantRepository restaurantRepository;

    @Autowired
    public RestaurantService(RestaurantRepository restaurantRepository) {
        this.restaurantRepository = restaurantRepository;
    }

    public List<Restaurant> getRestaurants() {

        List<Restaurant> restaurants = restaurantRepository.findAll();
        return restaurants;
    }  /*restaurant의 Repositary에 정의된 findAll을 이용하여 restaurant 객체를 List를 이용해 모두 불러온다.*/

    public Restaurant getRestaurant(Long id) {
        Restaurant restaurant = restaurantRepository.findById(id)
                .orElseThrow(() -> new RestaurantNotFoundException(id));
        return restaurant;
    }
    /* 특정 id 값의 레스토랑 객체를 findById를 이용하여 찾고 해당 id값에 해당하는 레스토랑 객체가 없을경우 예외처리, 존재하는 경우
    반납한다.*/


    public Restaurant addRestaurant(Restaurant restaurant) {

        return restaurantRepository.save(restaurant);
    } // 레스토랑 객체를 추가하는 기능

    @Transactional
    public Restaurant updateRestaurant(long id, String name, String address) {
        Restaurant restaurant = restaurantRepository.findById(id).orElse(null);

        restaurant.updateInformation(name, address);
        return restaurant;
    } // @트랜잭셔널 어노테이션을 사용하여 특정 id 값의 레스토랑 객체를 찾고, 해당 레스토랑 객체의 정보를 업데이트, 중간에 오류가 날 경우 롤백할 수 있따.
}

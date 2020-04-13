package kr.co.fastcampus.eatgo.domain;

import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

/* CrudRepository를 상속 받아 Entity의 객체를 검색하거나, 추가하는 클래스 */
public interface RestaurantRepository extends CrudRepository<Restaurant, Long> {
    List<Restaurant> findAll();

    List<Restaurant> findAllByAddressContainingAndCategoryId(
            String region, long categoryId);

    Optional<Restaurant> findById(Long id);

    Restaurant save(Restaurant restaurant);

}

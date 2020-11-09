package repositories;

import models.Review;
import models.Watchlist;

import java.util.List;

public interface ReviewsRepository extends CrudRepository<Review> {
    List<Review> findAllByUser(String email);
    List<Review> findAllByTitle(String title);
}

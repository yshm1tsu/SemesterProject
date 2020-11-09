package repositories;

import models.Watchlist;

import java.util.List;

public interface WatchlistRepository extends CrudRepository<Watchlist>{
    List<Watchlist> findAllByUser(String email);
}

package com.github.prgrms.reviews;

import java.util.List;
import java.util.Optional;

public interface ReviewRepository {

    void save(String content);

    Optional<Review> findById(Long seq);

    List<Review> findAll();

    void update(Long id, String content);
}

package com.github.prgrms.reviews;

import com.github.prgrms.configures.web.Pageable;

import java.util.List;
import java.util.Optional;

public interface ReviewRepository {

    void save(String content);

    Optional<Review> findById(Long seq);

    List<Review> findAll();

    List<Review> findAll(Pageable pageable);

    void update(Long id, String content);
}

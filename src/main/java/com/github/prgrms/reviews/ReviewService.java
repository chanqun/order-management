package com.github.prgrms.reviews;

import com.github.prgrms.orders.Order;
import com.github.prgrms.orders.OrderRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ReviewService {
    private final ReviewRepository reviewRepository;

    public ReviewService(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }

    public void review(String content) {
        reviewRepository.save(content);
    }
}

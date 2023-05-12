package com.github.prgrms.reviews;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Transactional
class ReviewServiceTest {
    @Autowired
    private ReviewService reviewService;

    @Autowired
    private ReviewRepository reviewRepository;

    @Test
    void 리뷰등록() {
        reviewService.review("content");

        Review review = reviewRepository.findAll().get(0);

        assertThat(review.getSeq()).isGreaterThan(0);
        assertThat(review.getContent()).isEqualTo("content");
        assertThat(review.getCreateAt()).isNotNull();
    }
}

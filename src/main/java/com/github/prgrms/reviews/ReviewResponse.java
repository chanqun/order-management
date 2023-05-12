package com.github.prgrms.reviews;

import static org.springframework.beans.BeanUtils.copyProperties;

public class ReviewResponse {
    private Long seq;

    private Long productId;

    private String content;

    private String createAt;

    public ReviewResponse(Review source) {
        copyProperties(source, this);
    }
}

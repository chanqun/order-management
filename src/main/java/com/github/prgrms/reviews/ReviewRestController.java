package com.github.prgrms.reviews;

import com.github.prgrms.security.JwtAuthentication;
import com.github.prgrms.utils.ApiUtils;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("api/orders")
public class ReviewRestController {
    private final ReviewService reviewService;

    public ReviewRestController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }
}

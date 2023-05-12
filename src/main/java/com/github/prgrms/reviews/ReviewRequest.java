package com.github.prgrms.reviews;

import javax.validation.constraints.NotBlank;

public class ReviewRequest {
    @NotBlank
    private String content;

    public ReviewRequest() {
    }

    public ReviewRequest(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }
}

package com.github.prgrms.reviews;

import java.time.LocalDateTime;

public class Review {
    private Long seq;

    private String content;

    private LocalDateTime createAt;

    public Review(String content) {
        this.content = content;
    }

    public Review(Long seq, String content, LocalDateTime createAt) {
        this.seq = seq;
        this.content = content;
        this.createAt = createAt;
    }

    public Long getSeq() {
        return seq;
    }

    public String getContent() {
        return content;
    }

    public LocalDateTime getCreateAt() {
        return createAt;
    }

    @Override
    public String toString() {
        return "Review{" +
                "seq=" + seq +
                ", content='" + content + '\'' +
                ", createAt=" + createAt +
                '}';
    }
}

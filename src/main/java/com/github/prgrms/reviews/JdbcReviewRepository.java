package com.github.prgrms.reviews;

import com.github.prgrms.configures.web.Pageable;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.util.List;
import java.util.Optional;

import static com.github.prgrms.utils.DateTimeUtils.dateTimeOf;

@Repository
public class JdbcReviewRepository implements ReviewRepository {

    private final JdbcTemplate jdbcTemplate;

    public JdbcReviewRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void save(String content) {
        jdbcTemplate.update(connection -> {
            PreparedStatement ps = connection.prepareStatement(
                    "insert into reviews(content) values (?)");
            ps.setString(1, content);
            return ps;
        });
    }

    @Override
    public void update(Long seq, String content) {
        jdbcTemplate.update("update reviews set content = ? where seq = ?", content, seq);
    }

    @Override
    public Optional<Review> findById(Long seq) {
        return Optional.ofNullable(jdbcTemplate.queryForObject("select * from reviews where seq = ?", mapper, seq));
    }

    @Override
    public List<Review> findAll() {
        return jdbcTemplate.query("select * from reviews", mapper);
    }

    @Override
    public List<Review> findAll(Pageable pageable) {
        return jdbcTemplate.query("select * from reviews limit ? offset ?", mapper, pageable.getSize(), pageable.getOffset());
    }

    static RowMapper<Review> mapper = (rs, rowNum) ->
            new Review(rs.getLong("seq"), rs.getString("content"), dateTimeOf(rs.getTimestamp("create_at")));
}

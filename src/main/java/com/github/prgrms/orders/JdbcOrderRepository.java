package com.github.prgrms.orders;

import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class JdbcOrderRepository implements OrderRepository {
    @Override
    public Optional<Order> findById(Long id) {
        return Optional.empty();
    }
}

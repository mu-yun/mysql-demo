package com.muyun.mysqldemo.repository;

import com.muyun.mysqldemo.entity.Order;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;


public interface OrderRepository extends JpaRepository<Order, Long> {


    @EntityGraph(attributePaths = "orderItems")
    List<Order> findAllByCreatedBy(Long createdBy);

    @EntityGraph(attributePaths = "orderItems")
    Optional<Order> findByIdAndCreatedBy(Long id, Long createdBy);

    @EntityGraph(attributePaths = "orderItems")
    Optional<Order> findByIdAndCreatedByAndOrderItems_OrderId(Long id, Long createdBy, Long orderId);

    @Query("select order,orderItem " +
            "from Order order " +
            "left join OrderItem orderItem on order.id=orderItem.orderId " +
            "where order.id=:id and order.createdBy=:createdBy and orderItem.orderId=:id")
    Optional<Order> findByIdAndCreatedByAndOrderItemsOrderId(@Param("id") Long id, @Param("createdBy") Long createdBy);


}

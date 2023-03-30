package com.sweetopia.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sweetopia.entity.Order;


public interface OrderRepository extends JpaRepository<Order, Long>{
	List<Order> findByOrderId(Long orderId);

}

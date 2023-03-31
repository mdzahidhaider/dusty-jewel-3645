package com.sweetopia.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


import com.sweetopia.entity.OrderBill;

public interface OrderBillRepository extends JpaRepository<OrderBill, Long>{
  
//	List<OrderBill> findByOrderBillId(Long orderBillId);
}


package com.sweetopia.repository;

import com.sweetopia.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;



public interface AddressRepository extends JpaRepository<Address,Long> {
}

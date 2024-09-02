package com.esg.repo;
import org.springframework.data.jpa.repository.JpaRepository;
import com.esg.entity.CustomerEntity;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<CustomerEntity, String> {

}

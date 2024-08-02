package com.microservice.account.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.microservice.account.model.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer>{

	List<Customer> findByRegionId(int regionId);

	/* 
	@Query(nativeQuery = true, 
			value = "select * from customer c JOIN region r "
					+ " ON c.region_id = r.id JOIN country con "
					+ " ON r.country_id = con.id where con.id=?1")
	List<Customer> getCustomerByCountry(int countryId);
*/
	@Query("select c from Customer c "
			+ " JOIN c.region r "
			+ " JOIN r.country con "
			+ " where con.id=?1")
	List<Customer> getCustomerByCountryJpql(int countryId);
}
/* 
 * JpaRepository has contract with developers:
 * 
 * it has some inbuilt methods which developers can use straight away  
 * 
 * JPARepo also allows developers to define instance variable methods. 
 * ex. Customer class has 4 instance variables: 
 * id (findById),name,contact,region 
 * 
 * Customer findByName(String name);
 * Customer findByContact(String contact);
 * List<Customer> findByRegionId(int id);
 */
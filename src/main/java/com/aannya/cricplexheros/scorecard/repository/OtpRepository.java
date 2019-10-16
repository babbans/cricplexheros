/**
 * 
 */
package com.aannya.cricplexheros.scorecard.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.aannya.cricplexheros.scorecard.model.Otp;

/**
 * @author Babban
 *
 */
@Repository("otpRepository")
public interface OtpRepository extends JpaRepository<Otp, Long>{
	
	@Query("select o from Otp o where o.mobileNumber=:mobileNumber and o.otp=:otp")
	public Otp validate(@Param("mobileNumber") String mobileNumber, @Param("otp") String otp);
	
	@Modifying
	@Transactional
	@Query("update Otp o set o.is_expired = :is_expired where o.mobileNumber=:mobileNumber and o.otp=:otp")
	public void expireOtp(@Param("mobileNumber") String mobileNumber, @Param("otp") String otp, @Param("is_expired") boolean is_expired);
}

/**
 * 
 */
package com.aannya.cricplexheros.user.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.aannya.cricplexheros.user.model.User;

/**
 * @author Babban
 *
 */
@Repository("userRepository")
public interface UserRepository extends JpaRepository<User, Long>{
	
	@Query("select u from User u where u.mobile_number=:mobileNumber and u.is_active='Y'")
	User isUsernameExist(@Param("mobileNumber") String mobileNumber);
	
	@Query("select u from User u where u.mobile_number=:mobileNumber and u.pin=:pin and u.is_active='Y'")
	User userAuthenticate(@Param("mobileNumber") String mobileNumber, @Param("pin") String pin);
	
	@Query("select u from User u where u.team_id=:teamId and u.is_active='Y'")
	List<User> findByTeamId(@Param("teamId") String teamId);
	
	@Query("SELECT U FROM User U WHERE LOWER(U.name) LIKE LOWER(concat('%', concat(?1, '%')))")
	List<User> getListOfAllPLayers(String searchString);
	
	@Modifying(clearAutomatically = true)
	@Transactional
	@Query("update User u set u.pin =:pin where u.mobile_number=:mobileNumber")
	void changePin(@Param("pin") String pin, @Param("mobileNumber") String mobileNumber);
	
	@Query(nativeQuery = true, value = "SELECT * FROM user u where u.team_id in (select t.id from team t where t.tournament_id=?1);")
	List<User> findByTournamentId(String tournamentId);
	
	@Query( "select u from User u where user_id in :ids" )
	List<User> findByUserUserIdIn(@Param("ids") List<Long> userIdList);
}

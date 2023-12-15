package  com.usermanagement.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.usermanagement.entity.UserMaster;

@Repository
public interface IUserRepository extends MongoRepository<UserMaster, String> {
	@Query("{userId:?0}")
	public UserMaster getUserByUserId(String userId);
	@Query("{'userContactInfo.emailId':?0}")
	public UserMaster getUserByEmail(String email);
}

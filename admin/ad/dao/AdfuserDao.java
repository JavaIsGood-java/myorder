package ad.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import ad.po.User;

@Repository
@Mapper
public interface AdfuserDao {
	public abstract int updateIss(User u) throws Exception;
	public abstract int changePassword(String username) throws Exception;
	public abstract List<User> getUserByKey(String keyword) throws Exception;
	public abstract double getSalAndLsal();
	public abstract User getUserByUsername(String username) throws Exception;
}

package ad.service;

import java.util.List;

import ad.po.User;

public interface AdFuserService {
	public abstract int changeUP(String username) throws Exception;
	public abstract List<User> getUserBykey(String keyword) throws Exception;
}

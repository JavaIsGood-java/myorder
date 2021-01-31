package ad.service;

import java.util.List;

import ad.po.Aduser;
import ad.po.User;

public interface AduserService {
	public abstract boolean login(Aduser a) throws Exception;
	public abstract int changeP(String password,String npassword,String adusername) throws Exception;
	
}

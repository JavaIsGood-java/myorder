package ad.dao;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import ad.po.Aduser;

@Repository
@Mapper
public interface AduserDao {
	public abstract Aduser selectByadusername(String adusername) throws Exception;
	public abstract int updateAdp(Aduser a) throws Exception;
}

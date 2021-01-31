package ad.dao;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import ad.po.Orderc;

@Repository
@Mapper
public interface AdOrdercDao {
	public abstract Orderc getOcByCid(String cid) throws Exception;
}

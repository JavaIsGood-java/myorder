package ad.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import ad.po.Ordera;

@Repository
@Mapper
public interface AdOrderaDao {
	public abstract List<Ordera> getAll() throws Exception;
	public abstract Ordera getOrderaByAid(String aid) throws Exception;
}

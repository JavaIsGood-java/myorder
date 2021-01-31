package ad.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import ad.po.Drawh;

@Repository
@Mapper
public interface AdDrawhDao {
	public abstract List<Drawh> getAllDrawhByDstatus(String dstatus) throws Exception;
	
	public abstract Drawh getDrawhById(int id) throws Exception;
	
	public abstract double getDsal() throws Exception;
	
	public abstract int updateDstatus(Drawh d) throws Exception;
	
	public abstract List<Drawh> selectBykey(String keyword) throws Exception;
}

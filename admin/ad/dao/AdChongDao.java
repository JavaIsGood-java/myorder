package ad.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import ad.po.Chong;
import ad.util.pojo.AdChongPage;


@Repository
@Mapper
public interface AdChongDao {
	public abstract List<Chong> selectBykey(AdChongPage a) throws Exception;
	public abstract int selectByKeyCount(AdChongPage c) throws Exception;
}

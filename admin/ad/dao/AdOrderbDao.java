package ad.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import ad.po.Orderb;
import ad.util.pojo.AdOrderbPage;

@Repository
@Mapper
public interface AdOrderbDao {
	public abstract Orderb getObByBid(String bid) throws Exception;
	public abstract List<Orderb> getOrderbBykey(AdOrderbPage b) throws Exception;
	public abstract int getOrderbBykeyCount(String keyword) throws Exception;
}

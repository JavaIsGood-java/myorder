package ad.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import ad.po.Approve;

@Repository
@Mapper
public interface AdApproveDao {
	public abstract List<Approve> getAll(String apstatus) throws Exception;
	public abstract int updateApprove(Approve a) throws Exception;
	public abstract List<Approve> selectBykey(String keyword) throws Exception;
}

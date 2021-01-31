package ad.service;

import java.util.List;

import ad.po.Approve;

public interface AdApproveService {
	public abstract List<Approve> getAllApprove() throws Exception;
	public abstract boolean approveFail(Approve a) throws Exception;
	public abstract boolean approveSuccess(Approve a) throws Exception;
	public abstract List<Approve> getSuccess(String keyword) throws Exception;
	public abstract int closeApprove(String username) throws Exception;
}

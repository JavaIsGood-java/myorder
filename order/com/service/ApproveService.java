package com.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.po.Approve;

public interface ApproveService {
	public abstract int approveFront(String username) throws Exception;
	public abstract Approve getApprove(String username) throws Exception;
	public abstract boolean uploading(List<MultipartFile> file,String username,String realpath) throws Exception;
}

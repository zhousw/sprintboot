package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bean.GpsInfo;
import com.mapper.GpsInfoMapper;

@Service
public class GpsInfoService {

	@Autowired
	private GpsInfoMapper gpsInfoMapper;

	public List<GpsInfo> getById(int id) {
		return gpsInfoMapper.getById(id);
	}
	
	public void save(GpsInfo gpsInfo) {
		gpsInfoMapper.save(gpsInfo);
	}

}
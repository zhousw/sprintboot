package com.controller;

import java.sql.Timestamp;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.bean.GpsInfo;
import com.github.pagehelper.PageHelper;
import com.service.GpsInfoService;

@RestController
public class GpsInfoController {

	@Resource
	private GpsInfoService gpsInfoService;

	@RequestMapping("/gpsInfo/{id}")
	public List<GpsInfo> getById(@PathVariable int id) {
		return gpsInfoService.getById(id);
	}

	@RequestMapping("/gpsInfo2/{id}")
	public List<GpsInfo> getById2(@PathVariable int id) {
		PageHelper.startPage(1, 2); // 显示第一页2条数据
		return gpsInfoService.getById(id);
	}

	@RequestMapping(value = "/gpsInfo", method = RequestMethod.POST)
	public String insert(@ModelAttribute("gpsInfo") GpsInfo gpsInfo) {
		gpsInfo.setCreateTime(new Timestamp(System.currentTimeMillis()));
		gpsInfoService.save(gpsInfo);
		return "success";
	}

}
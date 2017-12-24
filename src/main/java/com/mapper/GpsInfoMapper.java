package com.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import com.bean.GpsInfo;

public interface GpsInfoMapper {
    
    @Select("select * from tb_gps_info where id=#{id}")
    @Results({
        @Result(column="id", property="id"),
        @Result(column="lgt", property="lgt"),
        @Result(column="lat", property="lat"),
        @Result(column="createTime", property="createTime")
    })
    public List<GpsInfo> getById(int id);

    @Insert("insert into tb_gps_info(lgt,lat,createTime) values(#{lgt},#{lat},#{createTime})")
    @Options(useGeneratedKeys=true,keyColumn="id",keyProperty="id")//设置id自增长
    public void save(GpsInfo gpsInfo);
}

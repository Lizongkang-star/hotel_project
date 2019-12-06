package com.example.hotel_project.Dao;


import com.example.hotel_project.Model.Hotel;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Service;

@Mapper
@Service
public interface HotelMapper {

    //增
    int insert(Hotel record);

    int insertSelective(Hotel record);

    //改

    //修改酒店信息
    int changeinfo(Hotel hotel);

    //查

    //获取酒店信息
    Hotel getHotelinfo();

}
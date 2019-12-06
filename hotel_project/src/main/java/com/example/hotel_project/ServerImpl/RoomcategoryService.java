package com.example.hotel_project.ServerImpl;


import com.example.hotel_project.Model.Roomcategory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


@Service("RoomcategoryService")
@Transactional
@SuppressWarnings("all")
public class RoomcategoryService extends BaseService {
    int ans = 0;


    //增

    //增加房间类型
    public int addRoomCategory(Roomcategory roomcategory) {
        try {
            ans = roomcategoryMapper.insert(roomcategory);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (ans == 1) {
            System.out.println("房间类型添加成功");
        } else {
            System.out.println("房间类型添加失败");
        }
        return ans;
    }

    //删

    //查，可选择传参，返回房间类型Id或者类型名
    public ArrayList<String> getAllCategory() {
        ArrayList<String> allcategory = null;
        try {
            allcategory = roomcategoryMapper.getAllCategoryName();
            if (allcategory == null) {
                System.out.println("查询失败...from RoomcategoryService");
            } else {
                System.out.println("查询成功...from RoomcategoryService");
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("数据库错误...from RoomcategoryService");
        }
        return allcategory;
    }

    public ArrayList<Roomcategory> getRoomPreservationInitialize() {
        ArrayList<Roomcategory> arrayList = null;
        try {
            arrayList = roomcategoryMapper.getRoomPreservationInitialize();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return arrayList;
    }

    //获取房间种类和价格
    public HashMap<String, Double> getTypeAndPrice() {
        HashMap<String, Double> hashMap = new HashMap<>();
        try {
            List<HashMap<String, Double>> hashMaps = null;
            hashMaps = roomcategoryMapper.getTypeAndPrice();
            for(HashMap<String,Double> hashMap1 :hashMaps){
                hashMap.put(String.valueOf(hashMap1.get("name")),((Number)hashMap1.get("price")).doubleValue());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        if(hashMap!=null){
            System.out.println("房间种类和价格获取成功！");
        }
        return hashMap;
    }

    //改

    //更新房间类型信息
    public void updateRoomcategory(Roomcategory roomcategory) {
        try {
            roomcategoryMapper.updateRoomcategory(roomcategory);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}

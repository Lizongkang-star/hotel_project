package com.example.hotel_project.ServerImpl;


import com.example.hotel_project.Model.Hotel;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service("HotelService")
@Transactional
@SuppressWarnings("all")
public class HotelService extends BaseService {
    int ans = 0;


    //增

    //删

    //查
    public Hotel getHotel() {
        Hotel hotel = null;
        try {
            hotel = hotelMapper.getHotelinfo();
            if (hotel != null)
                System.out.println("获取酒店信息成功");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("获取酒店信息失败...from HotelService");
        }
        return hotel;
    }



    //改
    public int updateHotel(Hotel hotel) {
        try {
            ans = hotelMapper.changeinfo(hotel);
        }catch (Exception e){
            System.out.println("something went wrong...from Service");
            e.printStackTrace();
        }
        return ans;
    }

}

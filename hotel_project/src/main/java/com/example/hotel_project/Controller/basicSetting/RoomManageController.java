package com.example.hotel_project.Controller.basicSetting;
import com.example.hotel_project.Controller.BaseController;
import com.example.hotel_project.Model.Room;
import com.example.hotel_project.Model.Roomcategory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;

@Controller
public class RoomManageController extends BaseController {

    //设置新的房间类型
    @RequestMapping("RoomTypeSetting")
    public ModelAndView RoomTypeSetting(HttpServletRequest request, HttpServletResponse response,
                                        @RequestParam("NameOfCategory") String NameOfCategory,
                                        @RequestParam("PriceOfCategory") Double PriceOfCategory,
                                        @RequestParam("totalNumberOfCategory") Integer totalNumberOfCategory,
                                        @RequestParam("scoreOfCategory") Double scoreOfCategory) {
        Roomcategory roomcategory = new Roomcategory(NameOfCategory, PriceOfCategory, totalNumberOfCategory, scoreOfCategory);
        ans = roomcategoryService.addRoomCategory(roomcategory);
        if (ans == 1) {
            message = "房间类型添加成功！ 3秒后返回客房类型设置页面";
        } else message = "房间类型添加失败！ 请重试！ 3秒后返回客房类型设置页面";
        nextURL = "basicSetting/RoomTypeSetting";
        return dispatcher.goPage(request, response, mv, nextURL, message);
    }


    //房态统计，按照房间类型分类
    @RequestMapping("RoomReportQueryByType")
    public ModelAndView RoomReportQueryByType(HttpServletRequest request, HttpServletResponse response,
                                              @RequestParam("roomType") String roomType) {
        HttpSession session = request.getSession();
        ArrayList<Room> roomQueryResultByType = roomService.getAllRoomByType(roomType);
        if (roomQueryResultByType != null && roomQueryResultByType.size() > 0) {
            ans = 1;
            session.setAttribute("roomQueryResultByType", roomQueryResultByType);
            message = "正在查询，请稍后...";
        } else {
            ans = 0;
            if (roomQueryResultByType == null) {
                message = "操作失败！请重试   3秒后返回房态统计界面 ";
            }
            if (roomQueryResultByType.size() == 0) {
                message = "查询结果为空   3秒后返回房态统计界面 ";
            }
        }
        if (ans == 1) {
            nextURL = "/basicSetting/RoomReportResult";
            request.setAttribute("intermediateTimer", 3);
        } else {
            nextURL = "/basicSetting/RoomReport";
            request.setAttribute("intermediateTimer", 3);
        }
        return dispatcher.goPage(request, response, mv, nextURL, message);
    }

    //房控功能
    @RequestMapping("RoomPreservationInitialize")
    public ModelAndView RoomPreservationInitialize(HttpServletRequest request, HttpServletResponse response) {
        ArrayList<Roomcategory> roomCategoryArrayList = roomcategoryService.getRoomPreservationInitialize();
        request.setAttribute("roomCategoryArrayList", roomCategoryArrayList);
        nextURL = "basicSetting/RoomPreservation";
        return dispatcher.goPage2(mv, request, response, nextURL);
    }

    //RoomPreservationAdd
    @RequestMapping("RoomPreservationAdd")
    public ModelAndView RoomPreservationAdd(HttpServletRequest request, HttpServletResponse response,
                                            @RequestParam("addLockedNumber") Integer[] typeName) {
        ArrayList<Roomcategory> roomCategoryArrayList = new ArrayList<>();
        int i = 0;
        roomCategoryArrayList = roomcategoryService.getRoomPreservationInitialize();
        for (Roomcategory roomcategory : roomCategoryArrayList) {
            //if(typeName[i]!=0)
            roomcategory.setLocked_number(typeName[i]);
            roomcategoryService.updateRoomcategory(roomcategory);
            i++;
        }
        request.setAttribute("roomCategoryArrayList", roomCategoryArrayList);
        mv.addObject("request", request);
        mv.addObject("response", response);
        mv.setViewName("basicSetting/RoomPreservation");
        return mv;
    }

    //RoomInformationQuery.do
    @RequestMapping("RoomInformationQuery")
    public ModelAndView RoomInformationQuery(HttpServletRequest request, HttpServletResponse response,
                                             @RequestParam("IDOfSettingRoom") Integer IDOfSettingRoom) {
        HttpSession session = request.getSession();
        Room resRoom = roomService.roomQueryByID(IDOfSettingRoom);
        session.setAttribute("resultRoomOfSetting", resRoom);

        //获取全部房间类型属性
        System.out.println("获取房间类型属性");
        ArrayList<String> allRoomType = roomcategoryService.getAllCategory();
        request.setAttribute("allRoomType", allRoomType);
        return dispatcher.goPage2(mv, request, response, "basicSetting/RoomInformationSetting");
    }
}

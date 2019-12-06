package com.example.hotel_project.ServerImpl;


import com.example.hotel_project.Dao.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service("BaseService")
@Transactional
@SuppressWarnings("all")
public class BaseService {

    @Autowired
    protected CustomerMapper customerMapper;

    @Autowired
    protected EmployeeMapper employeeMapper;

    @Autowired
    protected AdministratorMapper administratorMapper;

    @Autowired
    protected CommentMapper commentMapper;

    @Autowired
    protected HotelMapper hotelMapper;

    @Autowired
    protected OrdersMapper ordersMapper;

    @Autowired
    protected QuestionMapper questionMapper;

    @Autowired
    protected RoomMapper roomMapper;

    @Autowired
    protected RoomcategoryMapper roomcategoryMapper;


    //try-catch template
    /*


    try {
            ans =
        }catch (Exception e){
            System.out.println("something went wrong...from Service");
            e.printStackTrace();
        }
     return ans;


     */

}

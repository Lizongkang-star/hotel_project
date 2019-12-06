package com.example.hotel_project.Model.TempModel;

//用户报告
public class CustomerReport {
    private int userID;
    private String IDNumber;
    private String customerName;
    private int roomID;
    private String startTime;
    private String endTime;

    public static class Builder {
        //Required
        private int userID;

        //Optional parameters
        private String IDNumber = "";
        private String customerName = "";
        private int roomID = 0;
        private String dateBegin = "";
        private String dateEnd = "";

        public Builder(int userID) {
            this.userID = userID;
        }

        public Builder IDNumber(String val) {
            this.IDNumber = val;
            return this;
        }

        public Builder customerName(String val) {
            this.customerName = val;
            return this;
        }

        public Builder roomID(int val) {
            this.roomID = val;
            return this;
        }

        public Builder startTime(String val) {
            this.dateBegin = val;
            return this;
        }

        public Builder endTime(String val) {
            this.dateEnd = val;
            return this;
        }

        public CustomerReport build() {
            return new CustomerReport(this);
        }
    }

    private CustomerReport(Builder builder) {
        userID = builder.userID;
        IDNumber = builder.IDNumber;
        customerName = builder.customerName;
        roomID = builder.roomID;
        startTime = builder.dateBegin;
        endTime = builder.dateEnd;
    }


    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getIDNumber() {
        return IDNumber;
    }

    public void setIDNumber(String IDNumber) {
        this.IDNumber = IDNumber;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public int getRoomID() {
        return roomID;
    }

    public void setRoomID(int roomID) {
        this.roomID = roomID;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }
}



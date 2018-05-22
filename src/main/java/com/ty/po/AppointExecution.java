package com.ty.po;

/**
 * @author pc
 * @create 2018-05-21 下午3:01
 * @desc 预约成功实体对象
 **/

public class AppointExecution {
    private int bookId;

    private int state; //预约结果状态

//    状态标识
    private String stateInfo;

    public AppointExecution(int bookId, AppointStateEnum noNumber){
    }

    public AppointExecution(int bookId,int state,String stateInfo){
        this.bookId = bookId;
        this.state = state;
        this.stateInfo = stateInfo;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public String getStateInfo() {
        return stateInfo;
    }

    public void setStateInfo(String stateInfo) {
        this.stateInfo = stateInfo;
    }

    @Override
    public String toString() {
        return "AppointExecution{" +
                "bookId=" + bookId +
                ", state=" + state +
                ", stateInfo='" + stateInfo + '\'' +
                '}';
    }
}

package com.xiang;

public class UserServiceImpl implements IUserService {
    public String getNameById(String id) {
        System.out.println("receive request data:" + id);

        return "XIANG";
    }
}

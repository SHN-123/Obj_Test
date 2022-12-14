package org.example.configurations;



public class Endpoints {
    public static final String update ="/api/users/"+EnvGlobalVals.userId;
    public static final String delete ="/api/users/"+EnvGlobalVals.userId;
    public static final String getuserslist ="/api/users?page=2";
    public static final String create ="/api/users";
    public static final String UserList = "/api/users";
    public static final String UserList_1 = "/api/users?page=1";
    public static final String UserList_2 = "/api/users?page=2";
    public static final String auth = "/auth";

}

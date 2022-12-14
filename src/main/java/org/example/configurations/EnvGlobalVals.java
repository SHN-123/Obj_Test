package org.example.configurations;

import io.restassured.response.Response;

import java.util.ArrayList;

public class EnvGlobalVals {

    //Assignment
    public static String baseUrl = "https://reqres.in";
    public static String userName;
    public static String userJob;
    public static int userId;
    public static Response response;
    public static int total_pages = 2;		  // this was not working when field data type was set as String, so converted to Integer and it worked.
    public static int total_records = 12;     // this was not working when field data type was set as String, so converted to Integer and it worked.
    public static int pagesize;
    public static String[] page1_names;
    public static String[] page2_names;
    public static int[] page1_ids;
    public static int[] page2_ids;


   
}

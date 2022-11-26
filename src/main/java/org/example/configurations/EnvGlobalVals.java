package org.example.configurations;

import io.restassured.response.Response;

import java.util.ArrayList;

public class EnvGlobalVals {

    //Assignment
    // Task # 3, Scenario # 1
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
    public static int[] read_ids;

    // Task # 4, Scenario # 4
    public static String booker_token;
    //public static String[] BIDs = new String[11];
    public static ArrayList<Integer> bookingids;
    public static int[] BIDs;
    public static int booker_pageSize;
    public  static int booking_id;
    public static Response actual_response;
    public static Response updated_response;
    public static Response partially_updated_response;
}

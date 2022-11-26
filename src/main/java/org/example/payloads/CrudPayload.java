package org.example.payloads;

public class CrudPayload {
    private static String name;
    private static String job;
    public void setName(String name){
        this.name = name;
    }
    public String getName(){
        return this.name;
    }
    public void setJob(String job){
        this.job = job;
    }
    public String getJob(){
        return this.job;
    }

    public CrudPayload(String name, String job){
        this.name = name;
        this.job = job;
    }

    public static String userCreationPayload(String name, String job){
        return "{\n" +
                "    \"name\": \""+name+"\",\n" +
                "    \"job\": \"\""+job+"\"\n" +
                "}";
    }

    public static String userUpdatePayload(String name, String job){
        return "{\n" +
                "    \"name\": \""+name+"\",\n" +
                "    \"job\": \"\""+job+"\"\n" +
                "}";
    }
}

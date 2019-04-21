package com.pattern.delegate.simple;

import java.util.HashMap;
import java.util.Map;

//项目经理
public class Leader {
    //用Map缓存每个员工职能。
    private Map<String,IEmployee> register = new HashMap<String, IEmployee>();

    //需要知道每个员工的职能
    public Leader(){
        register.put("加密", new EmployeeA());
        register.put("架构", new EmployeeB());
    }

    public void doing(String command){
        //分配任务
        register.get(command).doing(command);
    }
}

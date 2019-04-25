package com.pattern.template.jdbc;

import com.pattern.template.jdbc.dao.MemberDao;

import java.util.AbstractList;
import java.util.List;

public class MemberDaoTest {
    public static void main(String[] args) {
        MemberDao memberDao = new MemberDao(null);
        List<?> result = memberDao.selectAll();
        System.out.println(result);

//        //JDK源码
//        AbstractList abstractList;
//        HttpServlet;
//        BaseExecutor
    }
}

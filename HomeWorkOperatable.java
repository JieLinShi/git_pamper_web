package com.train.day14;

import java.util.List;

/**
 * @author tjy
 * @version 1.0
 * @date 2019/8/5 18:47
 */
public interface HomeWorkOperatable {

    List<HomeWork> FindAll();

    int updateBySno(HomeWork homeWork);

    int insert(HomeWork homeWork);

    int deleteBySno(String sno);

}

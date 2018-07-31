package com.pandawork.service;

import com.pandawork.common.entity.user.Users;
import com.pandawork.core.common.exception.SSException;

/**
 * @author : kongyy
 * @time : 2018/7/28 19:29
 */
public interface UsersService {
    /**
     * 增加
     * @param users
     * @return
     */
    public boolean addUsers(Users users) throws SSException;

    /**
     *
     * @return
     */
    public Users getUserByName(String name) throws SSException;
}

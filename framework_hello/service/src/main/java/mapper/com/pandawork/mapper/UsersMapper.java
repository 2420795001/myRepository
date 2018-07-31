package com.pandawork.mapper;

import com.pandawork.common.entity.user.Users;
import org.apache.ibatis.annotations.Param;
import java.util.List;
/**
 * @author : kongyy
 * @time : 2018/7/28 18:54
 */
public interface UsersMapper {

    /**
     * 增加
     * @param users
     * @return
     */
    public boolean addUsers(@Param("users")Users users) throws Exception;

    /**
     *
     * @return
     */
    public Users getUserByName(@Param("name")String name) throws Exception;


}

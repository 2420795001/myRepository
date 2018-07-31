package com.pandawork.mapper;
import com.pandawork.common.entity.person.Person;
import org.apache.ibatis.annotations.Param;
import java.util.List;
import java.util.List;

/**
 * @author : kongyy
 * @time : 2018/7/29 14:22
 */
public interface PersonMapper {
    public List<Person> searchPerson(@Param("keyword") String keyword) throws Exception;

    /**
     * 增加
     * @param person
     * @return
     */
    public boolean addPerson(@Param("person")Person person) throws Exception;

    /**
     * 删除
     * @param id
     * @return
     */
    public boolean delPerson(@Param("id")int id) throws Exception;

    /**
     * 修改
     * @param person
     * @return
     */
    public boolean updatePerson(@Param("person")Person person)throws Exception;

    /**
     *查找
     * @param id
     * @return
     */
    public Person selectById(@Param("id")int id) throws Exception;

    /**
     *
     * @return
     */
    public List<Person> listAllPerson() throws Exception;

}

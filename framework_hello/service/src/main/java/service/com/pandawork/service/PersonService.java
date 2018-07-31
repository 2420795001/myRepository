package com.pandawork.service;

import com.pandawork.common.entity.person.Person;
import com.pandawork.core.common.exception.SSException;

import java.util.List;

/**
 * @author : kongyy
 * @time : 2018/7/29 15:20
 */
public interface PersonService {

    public List<Person> searchPerson(String keyword) throws SSException;

    /**
     * 增加
     * @param person
     * @return
     */
    public boolean addPerson(Person person) throws SSException;

    /**
     * 删除
     * @param id
     * @return
     */
    public boolean delPerson(int id) throws SSException;

    /**
     * 修改
     * @param person
     * @return
     */
    public boolean updatePerson(Person person) throws SSException;

    /**
     *查找
     * @param id
     * @return
     */
    public Person selectById(int id) throws SSException;

    /**
     *
     * @return
     */
    public List<Person> listAllPerson() throws SSException;


}

package com.pandawork.service.impl;

import com.pandawork.common.entity.person.Person;
import com.pandawork.common.utils.NFException;
import com.pandawork.core.common.exception.SSException;
import com.pandawork.core.common.log.LogClerk;
import com.pandawork.core.common.util.Assert;
import com.pandawork.core.framework.dao.CommonDao;
import com.pandawork.mapper.PersonMapper;
import com.pandawork.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.util.Collections;
import java.util.List;
/**
 * @author : kongyy
 * @time : 2018/7/29 15:23
 */
@Service("personService")
public class PersonServiceImpl implements PersonService {

    @Autowired
    PersonMapper personMapper;

    @Autowired
    protected CommonDao commonDao;

    @Override
    public List<Person> listAllPerson() throws SSException{
        List<Person> personlist = Collections.emptyList();
        try {
           personlist = personMapper.listAllPerson();
        } catch (Exception e) {
            LogClerk.errLog.error(e);
            throw SSException.get(NFException.ListStudentAll, e);
        }
        return personlist;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = {SSException.class, Exception.class, RuntimeException.class})
    public boolean addPerson(Person person) throws SSException {
        if(Assert.isNull(person)){
            return false;
        }
        Assert.isNotNull(person.getName(), NFException.NameNotNull);
        Assert.isNotNull(person.getSex(), NFException.SexNotNull);
        Assert.isNotNull(person.getAge(), NFException.AgeLessOrEqualZero);
        try {
             return personMapper.addPerson(person);
        } catch (Exception e) {
            LogClerk.errLog.error(e);
            throw SSException.get(NFException.SystemException, e);
        }
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = {SSException.class, Exception.class, RuntimeException.class})
    public boolean delPerson(int id) throws SSException {
        if (Assert.lessOrEqualZero(id)) {
            return false;
        }
        try {
            return personMapper.delPerson(id);
        } catch (Exception e) {
            LogClerk.errLog.error(e);
            throw SSException.get(NFException.DelPersonNull, e);
        }
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = {SSException.class, Exception.class, RuntimeException.class})
    public boolean updatePerson(Person person) throws SSException {
        if (Assert.isNull(person)) {
            return false;
        }
        try {
            return personMapper.updatePerson(person);
        } catch (Exception e) {
            LogClerk.errLog.error(e);
            throw SSException.get(NFException.UpdatePersonFailed, e);
        }
    }

    @Override
    public Person selectById(int id) throws SSException {
        if (Assert.lessOrEqualZero(id)) {
            return null;
        }
        try {
            return personMapper.selectById(id);
        } catch (Exception e) {
            LogClerk.errLog.error(e);
            throw SSException.get(NFException.queryStudentByIdFailed, e);
        }
    }

    @Override
    public List<Person> searchPerson(String keyword) throws SSException {
        if (Assert.isNull(keyword)) {
            return null;
        }
        try {
            return personMapper.searchPerson(keyword);
        } catch (Exception e) {
            LogClerk.errLog.error(e);
            throw SSException.get(NFException.QueryByNameFailed, e);
        }
    }
}


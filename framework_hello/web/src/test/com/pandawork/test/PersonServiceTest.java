package com.pandawork.test;

import com.pandawork.common.entity.person.Person;
import com.pandawork.core.common.exception.SSException;
import com.pandawork.service.PersonService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.sql.SQLException;

/**
 * @author : kongyy
 * @time : 2018/7/29 16:32
 */
public class PersonServiceTest extends AbstractTestCase{

    @Autowired
    PersonService personService;

    @Test
    public void testListAllPerson() throws SSException,SQLException {
        System.out.print(personService.listAllPerson());
    }

//    @Test
//    public void testDelPerson() throws SSException{
//        Person person = new Person();
//        person.setId(5);
//        personService.delPerson(person.getId());
//        System.out.println("O的K");
//    }
//    @Test
//    public void testDelPerson() throws SSException{
//        Person person = new Person();
//        person.setId(3);
//        personService.delPerson(person.getId());
//        System.out.println("删除成功");
//    }
    @Test
    public void testDelPerson() throws SSException{
        Person person = new Person();
        person.setId(11);
        personService.delPerson(person.getId());
        System.out.println("16");
    }

    @Test
    public void testUpdatePerson() throws SSException{
        Person person = new Person();
        person.setId(16);
        person.setName("老王");
        person.setAge(6);
        person.setSex("男");
        personService.updatePerson(person);
        System.out.println("修改成功");
    }

    @Test
    public void testSelectById() throws SSException {
        Person person = new Person();
        person.setId(16);
        System.out.println(personService.selectById(1));
    }

    @Test
    public void testsearchPerson() throws SSException{
        System.out.println(personService.searchPerson("李"));
    }
    @Test
    public void testAddPerson() throws SSException{
        Person person = new Person();
        person.setId(10);
        person.setName("胖狗");
        person.setAge(4);
        person.setSex("女");
        personService.addPerson(person);
        System.out.println("添加成功");
    }

}

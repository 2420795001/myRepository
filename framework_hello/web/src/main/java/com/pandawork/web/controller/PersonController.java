package com.pandawork.web.controller;

import com.pandawork.common.entity.person.Person;
import com.pandawork.core.common.exception.SSException;
import com.pandawork.core.common.log.LogClerk;
import com.pandawork.core.common.util.Assert;
import com.pandawork.service.PersonService;
import com.pandawork.web.spring.AbstractController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.script.ScriptContext;
import java.util.Collections;
import java.util.List;

/**
 * @author : kongyy
 * @time : 2018/7/29 23:57
 */
@Controller
@RequestMapping("/person")
public class PersonController extends AbstractController {

    ScriptContext response;

    @Autowired
    PersonService personService;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String personList(Model model) {
        try {
            List<Person> list = Collections.emptyList();
            list = personService.listAllPerson();
            model.addAttribute("personList", list);
            //此即为foreach循环的item
            return "home";
        } catch (SSException e) {
            LogClerk.errLog.error(e);
            sendErrMsg(e.getMessage());
            return ADMIN_SYS_ERR_PAGE;
        }
    }


    @RequestMapping(value = "del/{id}", method = RequestMethod.GET)
    public String delPerson(@PathVariable("id") int id) {
        try {
            personService.delPerson(id);
            return "redirect:/person/list";
            //删除后还需重定向页面才可获取最新列表
        } catch (SSException e) {
            LogClerk.errLog.error(e);
            sendErrMsg(e.getMessage());
            return ADMIN_SYS_ERR_PAGE;
        }
    }

    @RequestMapping(value = "/toAdd",method = RequestMethod.GET)
    public String toAddPerson(Model model){
        return "add";
    }

    @RequestMapping(value ="/add", method = RequestMethod.POST)
    public String addPerson(Person person,RedirectAttributes redirectAttributes){
        try {
            personService.addPerson(person);
            redirectAttributes.addFlashAttribute("message", "添加成功！");
            return "redirect:/person/list";
        } catch (SSException e){
            LogClerk.errLog.error(e);
            sendErrMsg(e.getMessage());
            return ADMIN_SYS_ERR_PAGE;
        }
    }

    @RequestMapping(value = "/toUpdate", method = RequestMethod.GET)
    public String toUpdatePerson(@PathVariable("id") int id, Model model){
        try{
            Person person ;
            person = personService.selectById(id);
            model.addAttribute("person", person);
            return "update";
        }catch (SSException e){
            LogClerk.errLog.error(e);
            sendErrMsg(e.getMessage());
            return ADMIN_SYS_ERR_PAGE;
        }
    }

    @RequestMapping(value = "update/{id}", method = RequestMethod.GET)
    public String updatePerson(Person person, @PathVariable("id") int id , Model model) {
        try {
            if(Assert.isNotNull(person)){
                return null;
            }
            person.setId(id);
            model.addAttribute("person",person);
            personService.updatePerson(person);
            return "redirect:/person/list";
        } catch (SSException e){
            LogClerk.errLog.error(e);
            sendErrMsg(e.getMessage());
            return ADMIN_SYS_ERR_PAGE;
        }
    }


    @RequestMapping(value ="/search",method = RequestMethod.GET)
    public String searchPerson(@RequestParam("keyword") String keyword, Model model) {
        try {
            List<Person> list = Collections.emptyList();
            list = personService.searchPerson(keyword);
            model.addAttribute("list", list);
            return "search";
        } catch (SSException e ){
            LogClerk.errLog.error(e);
            sendErrMsg(e.getMessage());
            return ADMIN_SYS_ERR_PAGE;
        }
    }
}

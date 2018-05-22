package com.ty.controller;

import com.ty.excption.AppoinException;
import com.ty.excption.NoNumberException;
import com.ty.excption.RepeatAppointException;
import com.ty.po.*;
import com.ty.service.BookService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author pc
 * @create 2018-05-21 下午7:50
 * @desc bookcontroller
 **/

@Controller
public class BookController {
    private Logger logger=LoggerFactory.getLogger(this.getClass());

    @Autowired
    private BookService bookService;

    //获取图书列表
    @RequestMapping(value = "/list",method = RequestMethod.GET)
    private String list(Model model){
        List<Book> list = bookService.getList();
        model.addAttribute("list",list);
        return "list";
    }

    //搜索是否有图书
    @RequestMapping(value = "/search",method = RequestMethod.POST)
    private void search(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse)throws ServletException,IOException {
        //接受页面的值
        String name = httpServletRequest.getParameter("name");
        name = name.trim();
        //向页面传值
        httpServletRequest.setAttribute("name",name);
        httpServletRequest.setAttribute("list",bookService.getSomeList(name));
        httpServletRequest.getRequestDispatcher("/WEB-INF/jsp/list.jsp").forward(httpServletRequest,httpServletResponse);
    }

    //查询某些图书的详细情况
    @RequestMapping(value = "/{bookId}/detail",method = RequestMethod.GET)
    private String detail(@PathVariable("bookId")int bookId,Model model){
        if(bookId == null){
            return "redict:/book/list";
        }
        Book book = bookService.getById(bookId);
        if(bookId == null){
            return "forward:/book/list";
        }
        model.addAttribute("book",book);
        System.out.println(book);
        return "detail";
    }

    //验证输入的用户名密码是否正确
    @RequestMapping(value = "verify",method = RequestMethod.POST,produces = {"application/json; charset = utf-8"})
    @ResponseBody
    private Map vaildate(int studentId,int password){
        Map resultMap = new HashMap();
        Student student = null;
        System.out.println("验证函数");
        student = bookService.validateStu(studentId,password);

        System.out.println("输入的学号,密码:" + studentId + ":" + password);
        System.out.println("查询到的:" + student.getStudentId() + ":" + student.getPassword());

        if(student != null){
            System.out.println("SUCCESS");
            resultMap.put("result","SUCCESS");
            return resultMap;
        }else{
            resultMap.put("result","FAILED");
            return resultMap;
        }
    }

    //执行预约的逻辑
    @RequestMapping(value = "/{bookId}/appoin",method = RequestMethod.POST,produces = {"application/json; charset = utf-8"})
    @ResponseBody
    private Result<AppointExecution> execute (@PathVariable("bookId")int bookId,@RequestParam("student")int studentId) {
            Result<AppointExecution> result;
            AppointExecution execution = null;

            try{//在调用appoint方法时可能会报错
                execution = bookService.appoint(bookId, studentId);
                result = new Result<AppointExecution>(true,execution);
                         return result;
            }catch (NoNumberException e1) {
                execution = new AppointExecution(bookId,AppointStateEnum.NO_NUMBER);
                result = new Result<AppointExecution>(true,execution);
                return result;
            } catch (RepeatAppointException e2){
                execution = new AppointExecution(bookId,AppointStateEnum.REPEAT_APPOINT);
                result = new Result<AppointExecution>(true,execution);
                return result;
            } catch (Exception e){
                execution = new AppointExecution(bookId,AppointStateEnum.INNER_ERROR);
                result = new Result<AppointExecution>(true,execution);
                return result;
            }
    }

    @RequestMapping(value = "/appoint")
    private String appointBooks(@RequestParam("studentId")int studentId,Model model){
        List<Appointment> appointmentList = new ArrayList<Appointment>();
        appointmentList = bookService.getAppointByStu(studentId);
        model.addAttribute("appointmentList",appointmentList);

        return "appointBookList";

    }
}

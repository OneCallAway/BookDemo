package com.ty.mapper;

import com.ty.po.Book;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author pc
 * @create 2018-05-21 下午12:20
 * @desc bookDao
 **/

public interface BookMapper {

    /**
     * 根据id查询图书
     */

    Book queryById(int id);

    List<Book> querySome(String name);

    List<Book> queryAll(@Param("offset")int offset,@Param("limit")int limit);

    /**
     * 减少图书数量
     */

    int reduceNumber(int bookId);
}

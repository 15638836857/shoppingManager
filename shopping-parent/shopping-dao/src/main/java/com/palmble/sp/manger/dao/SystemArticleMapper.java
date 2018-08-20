package com.palmble.sp.manger.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.palmble.sp.manger.model.SystemArticle;
@Mapper
public interface SystemArticleMapper {
	List<SystemArticle> getArticleList(Map<String, Object> map);
    int deleteByPrimaryKey(Integer id);

    int insert(SystemArticle record);

    int insertSelective(SystemArticle record);

    SystemArticle selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SystemArticle record);

    int updateByPrimaryKey(SystemArticle record);
	SystemArticle selectByName(SystemArticle systemArticle);
}
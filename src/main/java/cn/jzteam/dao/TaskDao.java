package cn.jzteam.dao;

import cn.jzteam.dao.mybatis.BaseDao;
import cn.jzteam.dao.entity.TaskEntity;

import org.springframework.stereotype.Repository;

@Repository
public interface TaskDao extends BaseDao<TaskEntity,Integer>{

}
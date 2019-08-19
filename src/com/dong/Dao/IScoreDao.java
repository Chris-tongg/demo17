package com.dong.Dao;

import com.dong.entity.Score;

import java.util.List;

public interface IScoreDao {
    //通过s_id获取成绩单
    List<Score> getListBySid(Integer s_id);
    //通过s_score中id更新成绩
    Integer updateScoreById(Score score);
    //通过_score中的id删除成绩
    Integer deleteScore(Integer id);
    //通过s_score中的id获取单行成绩，用于修改
    Score getScoreById(Integer id);
    //添加成绩
    Integer addScore(Score score);
}

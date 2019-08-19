package com.dong.Dao.Impl;

import com.dong.Dao.IScoreDao;
import com.dong.entity.Score;
import com.dong.utils.DBClose;
import com.dong.utils.DBUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ScoreDaoImpl implements IScoreDao {

    @Override
    public List<Score> getListBySid(Integer s_id) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rSet = null;
        List<Score> list = new ArrayList<>();
        try {
            conn = DBUtils.getConnection();
            ps = conn.prepareStatement("select * from s_score where s_id=? and is_delete=1");
            ps.setInt(1,s_id);
            rSet = ps.executeQuery();
            Score s_score;
            while (rSet.next()){
                Integer id =rSet.getInt("id");
                String subject = rSet.getString("subject");
                Double score = rSet.getDouble("score");
                Integer sid = rSet.getInt("s_id");
                s_score = new Score(id,subject,score,sid);
                list.add(s_score);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBClose.closeAll(rSet,ps,conn);
        }
        return list;
    }

    @Override
    public Integer updateScoreById(Score score) {
        Connection conn = null;
        PreparedStatement ps = null;
        int rSet = 0;
        try {
            conn = DBUtils.getConnection();
            ps = conn.prepareStatement("update s_score set subject=?,score=? where id=?");
            ps.setString(1,score.getSubject());
            ps.setDouble(2,score.getScore());
            ps.setInt(3,score.getId());
            rSet = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBClose.closeAll(ps,conn);
        }
        return rSet;
    }

    @Override
    public Integer deleteScore(Integer id) {
        Connection conn = null;
        PreparedStatement ps = null;
        int rSet = 0;
        try {
            conn = DBUtils.getConnection();
            ps = conn.prepareStatement("update s_score set is_delete = 0 where id=?");
            ps.setInt(1,id);
            rSet = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rSet;
    }

    @Override
    public Score getScoreById(Integer id) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rSet = null;
        Score s_score = null;
        try {
            conn = DBUtils.getConnection();
            ps = conn.prepareStatement("select * from s_score where id = ?");
            ps.setInt(1,id);
            rSet = ps.executeQuery();
            if (rSet.next()){
                int id1 = rSet.getInt("id");
                String subject = rSet.getString("subject");
                double score = rSet.getDouble("score");
                s_score = new Score(id1,subject,score);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return s_score;
    }

    @Override
    public Integer addScore(Score score) {
        Connection conn = null;
        PreparedStatement ps = null;
        int rSet = 0;
        try {
            conn = DBUtils.getConnection();
            ps = conn.prepareStatement("insert into s_score(subject,score,s_id) values (?,?,?)");
            ps.setString(1,score.getSubject());
            ps.setDouble(2,score.getScore());
            ps.setInt(3,score.getS_id());
            rSet = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBClose.closeAll(ps,conn);
        }
        return rSet;
    }

}

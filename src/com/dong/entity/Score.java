package com.dong.entity;

public class Score {
    private Integer id;
    private String subject;
    private Double score;
    private Integer s_id;
    private Integer is_delete;

    public Score() {
    }

    public Score(Integer id, String subject, Double score, Integer s_id, Integer is_delete) {
        this.id = id;
        this.subject = subject;
        this.score = score;
        this.s_id = s_id;
        this.is_delete = is_delete;
    }

    public Score( String subject, Double score, Integer s_id) {
        this.subject = subject;
        this.score = score;
        this.s_id = s_id;
    }

    public Score(Integer id, String subject, Double score, Integer s_id) {
        this.id = id;
        this.subject = subject;
        this.score = score;
        this.s_id = s_id;
    }

    public Score(Integer id, String subject, Double score) {
        this.id = id;
        this.subject = subject;
        this.score = score;
    }

    public Score(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public Double getScore() {
        return score;
    }

    public void setScore(Double score) {
        this.score = score;
    }

    public Integer getS_id() {
        return s_id;
    }

    public void setS_id(Integer s_id) {
        this.s_id = s_id;
    }

    public Integer getIs_delete() {
        return is_delete;
    }

    public void setIs_delete(Integer is_delete) {
        this.is_delete = is_delete;
    }

    @Override
    public String toString() {
        return "Score{" +
                "id=" + id +
                ", subject='" + subject + '\'' +
                ", score=" + score +
                ", s_id=" + s_id +
                ", is_delete=" + is_delete +
                '}';
    }
}

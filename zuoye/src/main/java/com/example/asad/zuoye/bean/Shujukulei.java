package com.example.asad.zuoye.bean;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Created by 13768 on 2019/5/15.
 */
@Entity
public class Shujukulei {
    @Id(autoincrement = true)
    private Long id;
    private int tupian;
    private String title;
    @Generated(hash = 64213014)
    public Shujukulei(Long id, int tupian, String title) {
        this.id = id;
        this.tupian = tupian;
        this.title = title;
    }
    @Generated(hash = 1023519989)
    public Shujukulei() {
    }
    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public int getTupian() {
        return this.tupian;
    }
    public void setTupian(int tupian) {
        this.tupian = tupian;
    }
    public String getTitle() {
        return this.title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
}

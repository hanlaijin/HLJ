package com.hlj.thrift.dao;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by hanlaijin@xiaomi.com on 18-7-18.
 */
@Entity
@Table(name = "ti")
public class TI {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "a", nullable = true)
    private int a;

    @Column(name = "b", nullable = true)
    private int b;

    public TI(int a, int b) {
        this.a = a;
        this.b = b;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }

    public int getB() {
        return b;
    }

    public void setB(int b) {
        this.b = b;
    }
}

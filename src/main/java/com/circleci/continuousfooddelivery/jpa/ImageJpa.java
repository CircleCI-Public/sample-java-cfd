package com.circleci.continuousfooddelivery.jpa;

import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.awt.*;

@Entity
@Table(name = "image")
public class ImageJpa {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "image_seq")
    private Integer id;

    @Column(name = "data")
    @Type(type = "org.hibernate.type.BinaryType")
    private byte[] data;

    @Column(name = "contentType")
    private String contentType;

    public ImageJpa(String contentType, byte[] data) {
        this.contentType = contentType;
        this.data = data;
    }

    public ImageJpa() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public byte[] getData() {
        return data;
    }

    public void setData(byte[] data) {
        this.data = data;
    }

    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }
}

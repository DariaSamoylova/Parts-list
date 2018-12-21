package com.study.model;


import javax.persistence.*;


@Entity
@Table(
        name = "part",
        schema = "test"
)

public class Part {


    private String detail;
    private boolean required;
    private int count;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    public Part() {
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }


    public boolean getRequired() {
        return required;
    }

    public void setRequired(boolean required) {
        this.required = required;
    }


    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Part)) return false;
        Part part = (Part) o;
        return id == part.id &&
                required == part.required &&
                count == part.count &&
                detail.equals(part.detail);
    }

    @Override
    public String toString() {
        return "Part{" +
                "id=" + id +
                ", detail='" + detail + '\'' +
                ", required=" + required +
                ", count=" + count +
                '}';
    }
}

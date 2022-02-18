package com.quickreview.interviews.entity;

import javax.persistence.*;

@Entity
@Table(name = "release")
public class Release {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "release_id")
    private Integer id;

    @Column(name = "release_date")
    private String releaseDate;

    private String description;

    public Release() {
    }

    public Release(String releaseDate, String description) {
        this.releaseDate = releaseDate;
        this.description = description;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Release{" +
                "id=" + id +
                ", releaseDate='" + releaseDate + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}

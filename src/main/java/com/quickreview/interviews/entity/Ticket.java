package com.quickreview.interviews.entity;

import javax.persistence.*;

@Entity
@Table(name = "ticket")
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ticket_id")
    private Integer id;

    private String title;

    private String description;

    @ManyToOne
    @JoinColumn(name = "application_id")
    private Application application;

    @ManyToOne
    @JoinTable(name = "release_id", joinColumns = @JoinColumn(name = "ticket_fk"), inverseJoinColumns = @JoinColumn(name = "release_fk"))
    private Release release;

    private String status;

    public Ticket() {
    }

    public Ticket(String title, String description, Application application, Release release, String status) {
        this.title = title;
        this.description = description;
        this.application = application;
        this.release = release;
        this.status = status;
    }

    public Release getRelease() {
        return release;
    }

    public Application getApplication() {
        return application;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setApplication(Application application) {
        this.application = application;
    }

    public void setRelease(Release release) {
        this.release = release;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", application=" + application +
                ", release=" + release +
                ", status='" + status + '\'' +
                '}';
    }
}
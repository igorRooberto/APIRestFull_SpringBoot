package com.example.Post.Author.entities;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.Instant;

@Entity
@Table(name = "Posts")
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "content",nullable = true)
    private String content;

    @CreationTimestamp
    private Instant createTimeStamp;

    @UpdateTimestamp
    private Instant UpdateTimeStamp;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "author_id",nullable = false)
    private Author author;

    public Post() {
    }

    public Post(Author author, String content, Instant createTimeStamp, Long id, Instant updateTimeStamp) {
        this.author = author;
        this.content = content;
        this.createTimeStamp = createTimeStamp;
        this.id = id;
        UpdateTimeStamp = updateTimeStamp;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Instant getCreateTimeStamp() {
        return createTimeStamp;
    }

    public void setCreateTimeStamp(Instant createTimeStamp) {
        this.createTimeStamp = createTimeStamp;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Instant getUpdateTimeStamp() {
        return UpdateTimeStamp;
    }

    public void setUpdateTimeStamp(Instant updateTimeStamp) {
        UpdateTimeStamp = updateTimeStamp;
    }
}


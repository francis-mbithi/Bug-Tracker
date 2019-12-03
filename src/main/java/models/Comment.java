package models;

import java.sql.Timestamp;
import java.util.Objects;

public class Comment {
    private int id;
    private String content;
    private Timestamp time_post;
    private int user_id;

    public Comment(String content, Timestamp time_post, int user_id) {
        this.content = content;
        this.time_post = time_post;
        this.user_id = user_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Timestamp getTime_post() {
        return time_post;
    }

    public void setTime_post(Timestamp time_post) {
        this.time_post = time_post;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Comment comment = (Comment) o;
        return id == comment.id &&
                user_id == comment.user_id &&
                Objects.equals(content, comment.content) &&
                Objects.equals(time_post, comment.time_post);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, content, time_post, user_id);
    }
}

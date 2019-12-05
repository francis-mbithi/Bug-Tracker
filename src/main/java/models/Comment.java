package models;

import java.sql.Timestamp;
import java.util.Objects;

public class Comment {
    private int id;
    private String username;
    private String content;
    private Timestamp time_post;
    private int upvote;
    private int downvote;
    private int bug_id;

    public Comment(String username,String content,int upvote, int downvote, int bug_id) {
        this.username = username;
        this.content = content;
        this.upvote = upvote;
        this.downvote = downvote;
        this.bug_id = bug_id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getUpvote() {
        return upvote;
    }

    public void setUpvote(int upvote) {
        this.upvote = upvote;
    }

    public int getDownvote() {
        return downvote;
    }

    public void setDownvote(int downvote) {
        this.downvote = downvote;
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

    public int getBug_id() {
        return bug_id;
    }

    public void setBug_id(int user_id) {
        this.bug_id = user_id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Comment comment = (Comment) o;
        return id == comment.id &&
                upvote == comment.upvote &&
                downvote == comment.downvote &&
                bug_id == comment.bug_id &&
                Objects.equals(username, comment.username) &&
                Objects.equals(content, comment.content) &&
                Objects.equals(time_post, comment.time_post);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, username, content, time_post, upvote, downvote, bug_id);
    }
}

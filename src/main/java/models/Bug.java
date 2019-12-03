package models;

import java.util.Objects;

public class Bug {
    private int id;
    private String content;
    private String category;
    private int user_id;

    public Bug(String content, String category, int user_id,int id) {
        this.content = content;
        this.category = category;
        this.user_id = user_id;
        this.id =id;
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

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
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
        Bug bug = (Bug) o;
        return id == bug.id &&
                user_id == bug.user_id &&
                Objects.equals(content, bug.content) &&
                Objects.equals(category, bug.category);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, content, category, user_id);
    }
}

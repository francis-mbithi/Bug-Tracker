package models;

import java.util.Objects;

public class Bug {
    private int id;
    private String content;
    private String category;

    public Bug(String content, String category) {
        this.content = content;
        this.category = category;
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


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Bug bug = (Bug) o;
        return id == bug.id &&
                Objects.equals(content, bug.content) &&
                Objects.equals(category, bug.category);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, content, category);
    }
}

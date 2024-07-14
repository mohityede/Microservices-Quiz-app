package org.themohit.quiz_service.model;

public class UserReqBody {
    private String title;
    private String category;
    private int quesCount;

    public UserReqBody() {
    }

    public UserReqBody(String title, String category, int quesCount) {
        this.title = title;
        this.category = category;
        this.quesCount = quesCount;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getQuesCount() {
        return quesCount;
    }

    public void setQuesCount(int quesCount) {
        this.quesCount = quesCount;
    }

    @Override
    public String toString() {
        return "UserReqBody{" +
                "title='" + title + '\'' +
                ", category='" + category + '\'' +
                ", quesCount=" + quesCount +
                '}';
    }
}

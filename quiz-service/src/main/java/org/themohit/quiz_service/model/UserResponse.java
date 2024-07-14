package org.themohit.quiz_app.model;

public class UserResponse {
    private int id;
    private char response;

    public UserResponse(int id, char response) {
        this.id = id;
        this.response = response;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public char getResponse() {
        return response;
    }

    public void setResponse(char response) {
        this.response = response;
    }

    @Override
    public String toString() {
        return "UserResponse{" +
                "id=" + id +
                ", response=" + response +
                '}';
    }
}

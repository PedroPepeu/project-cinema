package projCin.CircularList.UsersNodes;

import projCin.Users.*;

public class UserNode {
    
    private User user;
    private Critical critical;
    private Student student;
    private UserNode previous;
    private UserNode next;
    private int codeAcess;

    public UserNode(User user, UserNode previous, UserNode next) {
        this.user = user;
        this.next = next;
        this.previous = previous;
    }

    public UserNode(Critical critical, UserNode previous, UserNode next) {
        this.critical = critical;
        this.next = next;
        this.previous = previous;
    }

    public UserNode(Student student, UserNode previous, UserNode next) {
        this.student = student;
        this.next = next;
        this.previous = previous;
    }

    public void setPrevious(UserNode previous) {
        this.previous = previous;
    }

    public UserNode getPrevious() {
        return this.previous;
    }

    public void setNext(UserNode next) {
        this.next = next;
    }

    public UserNode getNext() {
        return this.next;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Critical getCritical() {
        return critical;
    }

    public void setCritical(Critical critical) {
        this.critical = critical;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public int getCodeAcess() {
        return codeAcess;
    }

    public void setCodeAcess(int codeAcess) {
        this.codeAcess = codeAcess;
    }

}

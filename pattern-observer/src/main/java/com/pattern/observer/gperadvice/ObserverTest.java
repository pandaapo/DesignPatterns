package com.pattern.observer.gperadvice;

public class ObserverTest {
    public static void main(String[] args) {
        Teacher teacher = new Teacher("wudaifu");

        Question question = new Question();
        question.setUserName("小明");
        question.setContent("观察者设计模式适用哪些场景？");
        GPer gper = GPer.getInstance();
        gper.addObserver(teacher);
        gper.publishQuestion(question);
    }
}

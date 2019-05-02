package com.pattern.observer.guavaGPeradvice;

import com.google.common.eventbus.EventBus;

public class ObserverTest {
    public static void main(String[] args) {
        Teacher teacher = new Teacher("wudaifu");
        EventBus eventBus = new EventBus();
        eventBus.register(teacher);

        GPer gPer = GPer.getInstance();
        Question question = new Question();
        question.setUsername("小明");
        question.setContent("观察者设计模式适用哪些场景？");
        gPer.publishQuestion(question);

        eventBus.post(gPer);
        eventBus.post(question);
    }
}

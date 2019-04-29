package com.pattern.decorator.passport;

import com.pattern.decorator.passport.old.SigninService;
import com.pattern.decorator.passport.upgrade.ISignForThirdService;
import com.pattern.decorator.passport.upgrade.SignForThirdService;

public class DecoratorTest {
    public static void main(String[] args) {
        //一种静态代理？？？但不是为了原有方法的增强，而是为了扩展
        //而且装饰者模式最终是不能改变原有的性质，怎么包装都是“煎饼”；代理最终可以是不一样的结果。
        ISignForThirdService signForThirdService = new SignForThirdService(new SigninService());
        signForThirdService.loginForQQ("");
    }

}

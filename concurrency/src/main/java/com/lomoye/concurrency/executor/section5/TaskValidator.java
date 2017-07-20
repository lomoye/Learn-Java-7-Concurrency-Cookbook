package com.lomoye.concurrency.executor.section5;

import java.util.concurrent.Callable;

/**
 * Created by lomoye on 2017/7/19.
 *
 */
public class TaskValidator implements Callable<String> {

    private UserValidator validator;

    private String user;

    private String password;

    public TaskValidator(UserValidator validator, String user, String password) {
        this.validator = validator;
        this.user = user;
        this.password = password;
    }


    @Override
    public String call() throws Exception {
        if (!validator.validate(user, password)) {
            System.out.printf("%s: 验证没通过~~~", validator.getName());
            throw new Exception("验证没通过~~~");
        }

        System.out.printf("%s: 验证通过啦~~~", validator.getName());
        return validator.getName();
    }
}

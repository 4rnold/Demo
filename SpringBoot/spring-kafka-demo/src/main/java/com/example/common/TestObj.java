package com.example.common;

import lombok.Data;

@Data
public class TestObj {
    private Foo1 foo1;
    private String name;

    public TestObj() {
    }

    public TestObj(Foo1 foo1, String name) {
        this.foo1 = foo1;
        this.name = name;
    }
}

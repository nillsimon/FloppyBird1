package com.example.mvp_mosby.model;

public interface MyAction<T> {
    void call(T t);
}

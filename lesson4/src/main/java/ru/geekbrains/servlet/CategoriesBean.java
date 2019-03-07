package ru.geekbrains.servlet;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@SessionScoped
@ManagedBean(name = "categories")
public class CategoriesBean {
    private Logger logger = LoggerFactory.getLogger(CategoriesBean.class);

    private String [] categories = {"Канцтовары", "Одежда", "Бытовая электроника"};

    public String[] getCategories() {
        return categories;
    }
}

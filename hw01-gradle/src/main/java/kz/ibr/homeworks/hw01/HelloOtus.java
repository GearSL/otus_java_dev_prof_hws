package kz.ibr.homeworks.hw01;

import com.google.common.collect.Lists;

import java.util.List;

public class HelloOtus {
    public static void main(String[] args) {
        List<String> names = Lists.newArrayList("John", "Adam", "Jane");
        System.out.println("List before reverse:" + names);

        List<String> reversed_names = Lists.reverse(names);
        System.out.println("List after reverse:" + reversed_names);
    }
}

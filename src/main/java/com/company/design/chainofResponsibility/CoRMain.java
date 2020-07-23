package com.company.design.chainofResponsibility;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 拌面
 * @date 2020/7/13
 * @description 责任链模式
 */

public class CoRMain {
    //模拟对消息发送到服务器过程中的文字过滤处理

    public static void main(String[] args) {
        Msg msg = new Msg();
        msg.str = "大家好,:),我是你们的领导，qzw";

        MarkFilter markFilter = new MarkFilter();
        EmoticonFilter emoticonFilter = new EmoticonFilter();
        RuleFilter ruleFilter = new RuleFilter();
        FilterChain filterChain = new FilterChain();

        FilterChain filterChain1 = new FilterChain();
        filterChain1.add(ruleFilter);


        filterChain.add(markFilter).add(emoticonFilter).add(filterChain1);
        filterChain.doFilter(msg);
        System.out.println(msg.str);
    }
}

class Msg {
    String str;
}


interface Filter {

    boolean doFilter(Msg msg);//设置boolean返回值，是为了给下个过滤器是否执行加的判断标识
}


class MarkFilter implements Filter {//特殊符号过滤器

    @Override
    public boolean doFilter(Msg msg) {
        String s = msg.str;

        msg.str = s.replaceAll("qzw", "秦振武");
        return true;
    }
}

class EmoticonFilter implements Filter {//表情符号过滤

    @Override
    public boolean doFilter(Msg msg) {
        String s = msg.str;
        msg.str = s.replace(":)", "^_^");
        return false;
    }
}

class RuleFilter implements Filter {

    @Override
    public boolean doFilter(Msg msg) {
        String s = msg.str;
        msg.str = s.replace("领导", "朋友");
        return true;
    }
}

class FilterChain implements Filter {//具体的责任链对象

    private List<Filter> filters = new ArrayList<>();//需要执行的过滤器


    public FilterChain add(Filter filter) {
        this.filters.add(filter);
        return this;//面向链编程，如果有新的Filter加入，直接在原来的对象上add即可。
    }

    @Override
    public boolean doFilter(Msg msg) {//实现方法
        for (Filter f : filters) {
            if (!f.doFilter(msg)) {//如果有一个链条返回false，则不执行后续的过滤
                return false;
            }
        }
        return true;
    }

}











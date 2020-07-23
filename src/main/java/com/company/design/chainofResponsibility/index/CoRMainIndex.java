package com.company.design.chainofResponsibility.index;


import java.util.ArrayList;
import java.util.List;

/**
 * @author 拌面
 * @date 2020/7/14
 * @description 另一种实现责任链的方式
 */

public class CoRMainIndex {

    public static void main(String[] args) {
        RequestM requestM = new RequestM();
        requestM.str = "大家好,:),我是你们的领导，qzw";

        MarkFilter markFilter = new MarkFilter();
        EmoticonFilter emoticonFilter = new EmoticonFilter();

        TextFilterChain filterChain = new TextFilterChain();
        filterChain.add(markFilter).add(emoticonFilter);//把所有的请求放到责任链对象中

        ResponseM responseM = new ResponseM();
        responseM.str = "response";
        filterChain.doFilter(requestM, responseM);//执行时，会将当前责任链中的所有过滤器都执行一遍，chain中每doFilter一次，
        // 下标做加法运行获取到下一个需要处理的filter，filter持有chain。在做完业务处理后，再次调用chain的doFilter方法，执行下一个过滤器中的doFilter
        //依次类推，最后执行完所有的过滤器
        System.out.println(requestM.str);
    }


}

class RequestM {
    String str;
}

class ResponseM {
    String str;
}

interface Filter {

    void doFilter(RequestM requestM, ResponseM responseM, FilterChain filterChain);//设置boolean返回值，是为了给下个过滤器是否执行加的判断标识
}


class MarkFilter implements Filter {//特殊符号过滤器

    @Override
    public void doFilter(RequestM requestM, ResponseM responseM, FilterChain filterChain) {
        System.out.println("1、MarkFilter-请求信息：" + requestM.str);
        filterChain.doFilter(requestM, responseM);
        System.out.println("1、MarkFilter-response");
    }
}

class EmoticonFilter implements Filter {

    @Override
    public void doFilter(RequestM requestM, ResponseM responseM, FilterChain filterChain) {
        System.out.println("2、EmoticonFilter-请求信息：" + requestM.str);
        filterChain.doFilter(requestM, responseM);
        System.out.println("2、EmoticonFilter-response");
    }
}


interface FilterChain {//具体的责任链对象

    void doFilter(RequestM requestM, ResponseM responseM);

}

class TextFilterChain implements FilterChain {

    List<Filter> filters = new ArrayList<>();
    int count = 0;//list中过滤器的个数
    int index = 0;//当前处理的过滤器下标

    public TextFilterChain add(Filter filter) {
        filters.add(filter);
        count = filters.size();
        return this;
    }

    @Override
    public void doFilter(RequestM requestM, ResponseM responseM) {
        if (index < count) {
            Filter f = filters.get(index++);
            f.doFilter(requestM, responseM, this);
        }
    }
}
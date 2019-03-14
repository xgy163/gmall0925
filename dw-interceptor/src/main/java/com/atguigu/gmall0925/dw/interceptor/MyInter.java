package com.atguigu.gmall0925.dw.interceptor;

import com.google.gson.Gson;
import org.apache.flume.Context;
import org.apache.flume.Event;
import org.apache.flume.interceptor.Interceptor;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MyInter implements Interceptor {
    Gson gson=null;

    @Override
    public void initialize() {
        gson = new Gson();
    }

    @Override
    public Event intercept(Event event) {

        String jsonString = new String(event.getBody());
        HashMap hashMap = gson.fromJson(jsonString, HashMap.class);
        String type = (String) hashMap.get("type");
        Map<String, String> headers = event.getHeaders();
        headers.put("logType",type);

        return event;
    }

    @Override
    public List<Event> intercept(List<Event> list) {
        for (Event event : list) {
            intercept( event);
        }
        return list;
    }

    @Override
    public void close() {

    }
    public static class Builder implements Interceptor.Builder {
        /**
         * 该方法主要用来返回创建的自定义类拦截器对象
         * @return
         */
        @Override
        public Interceptor build() {
            return new MyInter();
        }

        @Override
        public void configure(Context context) {
            //可以通过context得到 flume.conf中设置的参数 ，传递给Interceptor
        }
    }


}

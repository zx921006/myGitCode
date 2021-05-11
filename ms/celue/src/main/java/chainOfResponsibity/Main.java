package chainOfResponsibity;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Message message = new Message();
        message.setMsg("大家好:),<script>,欢迎访问，大家都是996");
        //处理msg
        FilterChain fc = new FilterChain();
        fc.add(new HtmlFilter())
                .add(new SensitiveFilter());
        FilterChain fc2 = new FilterChain();
        fc2.add(new faceFilter());
        fc.add(fc2);
        Boolean aBoolean = fc.doFilter(message);
        System.out.println(aBoolean);
        System.out.println(message.msg);
    }
    interface Filter{
        Boolean doFilter(Message msg);
    }
    static class HtmlFilter implements Filter{
        @Override
        public Boolean doFilter(Message message) {
            String msg = message.getMsg();
            msg=msg.replace('<','[');
            msg=msg.replace('>',']');
            message.setMsg(msg);
            return true;
        }
    }
    static class SensitiveFilter implements Filter{
        @Override
        public Boolean doFilter(Message message) {
            String msg = message.getMsg();
            msg=msg.replace("996","955");
            message.setMsg(msg);
            return false;
        }
    }
    static class faceFilter implements Filter{
        @Override
        public Boolean doFilter(Message message) {
            String msg = message.getMsg();
            msg=msg.replace(":","^V^");
            message.setMsg(msg);
            return true;
        }
    }
    static class FilterChain implements Filter{
        List<Filter> filters = new ArrayList<Filter>();
        public FilterChain add(Filter f){
            filters.add(f);
            return this;
        }
        public Boolean doFilter(Message msg){
            for(Filter f:filters){
               if(!f.doFilter(msg))return false;
            }
            return true;
        }
    }
}

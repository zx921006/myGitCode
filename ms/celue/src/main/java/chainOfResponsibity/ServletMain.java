package chainOfResponsibity;

import java.util.ArrayList;
import java.util.List;

public class ServletMain {
    public void main(String[] args) {
        request req = new request();
        req.req="request";
        response res = new response();
        res.res="response";
        FilterChain fc = new FilterChain();
        fc.add(new HtmlFilter()).add(new SensitiveFilter());


    }
    interface Filter{
        Boolean doFilter(request req,response res);
    }
    static class HtmlFilter implements Filter {
        @Override
        public Boolean doFilter(request req,response res) {
            String msg = req.req;
            msg=msg.replace('<','[');
            msg=msg.replace('>',']');
            req.req=msg;
            return true;
        }
    }
    static class SensitiveFilter implements Filter {
        @Override
        public Boolean doFilter(request req,response res) {
            String msg = req.req;
            msg=msg.replace("996","955");
            req.req=msg;
            return false;
        }
    }
    static class FilterChain implements Filter {
        List<Filter> filters = new ArrayList<Filter>();
        public FilterChain add(Filter f){
            filters.add(f);
            return this;
        }
        public Boolean doFilter( request req,response res){
            for(Filter f:filters){
                if(!f.doFilter(req,res))return false;
            }
            return true;
        }
    }
    class request{
        String req;
    }
    class response{
        String res;
    }
}

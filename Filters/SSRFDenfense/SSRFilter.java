/**
 @ author: Drunkbaby
 @ usages: 用于 SSRF 的自定义防护
 去到对应的接口下面修改即可
 */

import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;


/**
 @ author: Drunkbaby
 @ usages: 用于 SSRF 的自定义防护
 @ ban 了几个协议，如果单纯全部阻挡什么 127.0.0.1，业务不一定过得去。
 */

@Component
@WebFilter(urlPatterns = "/system/role/list", filterName = "sqlInjectFilter")
public class sqlFilter implements Filter {
    public void destroy() {
    }

    public void init(FilterConfig arg0) throws ServletException {
    }

    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) res;
        // 获得所有请求参数名
        Enumeration params = request.getParameterNames();
        String sql = "";
        while (params.hasMoreElements()) {
            // 得到参数名
            String name = params.nextElement().toString();
            // 得到参数对应值
            String[] value = request.getParameterValues(name);
            for (int i = 0; i < value.length; i++) {
                sql = sql + value[i];
            }
        }
        if (sqlValidate(sql)) {
            throw new IOException("您发送请求中的参数中含有非法字符");
        } else {
            chain.doFilter(request, response);
        }
    }

    /**
     * 参数校验
     * @param str
     */
    public static boolean sqlValidate(String str) {
        str = str.toLowerCase();//统一转为小写
        String badStr = "file|http|jar|gopher|tar|war";
        String[] badStrs = badStr.split("\\|");
        for (int i = 0; i < badStrs.length; i++) {
            //循环检测，判断在请求参数当中是否包含SQL关键字
            if (str.indexOf(badStrs[i]) >= 0) {
                return true;
            }
        }
        return false;
    }
}
package FastjsonFilters;


import java.util.Objects;
import java.util.regex.Pattern;

/**
 @ author: Drunkbaby
 @ usages: 用于 Fastjson 的自定义防护
 @ 针对 1.2.24 版本，则只添加过滤即可，若针对其他版本
 ParserConfig.getGlobalInstance().setAutoTypeSupport(false); 将 autoTypeSupprt 设置为 false
 */

public class Fastjson1224Filter {
    public String Unserjson(@RequestParam String str, @RequestParam String input) throws Exception {
        if (str != null && Objects.hashCode(str) == secret.getKey().hashCode() && !secret.getKey().equals(str)) {
            String pattern = ".*rmi.*|.*jndi.*|.*ldap.*|.*\\\\x.*";
            Pattern p = Pattern.compile(pattern, 2);
            boolean StrMatch = p.matcher(input).matches();
            if (StrMatch) {
                return "Hacker get out!!!";
            }

            ParserConfig.getGlobalInstance().setAutoTypeSupport(true);
            JSON.parseObject(input);
        }

        return "hello";
    }
}

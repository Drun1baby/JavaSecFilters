# JavaSecFilters
> 为了准备 AWD/AWDP，写了个 Filter 的集合，希望能够帮助到各位师傅们

其中包括以下内容

- SQL 注入防护
- XSS 防护
- 文件上传黑名单的防护
- log4j2 的防护
- fastjson 的防护
- shiro 的防护 ———— 主要是自己设置 key
- SSRF 的防护
- 目录遍历的防护



```none
select|sleep|extractvalue|updatexml|floor|sleep|table|flag|union|update|and|or|delete|insert|truncate|char|substr|ascii|declare|exec|count|master|into|drop|execute|table|\\\\$|\'|\"|--|#|\\0|into|alert|img|prompt|set/is",$s)||strlen($s)>1000
```

# 更新于 2024/5/6

更新了 php 部分的 filter

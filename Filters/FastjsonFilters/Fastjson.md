# Fastjson 漏洞的 AWD Filter

- 出发点是过滤 rmi，ldap，jndi 三个关键词

## 对于 Fastjson 1.2.24

因为从原理上来说，Fastjson 历代版本的更新都在修改黑名单的这一块内容，所以我们这里加一些固定的黑名单我觉得意义不大。不如直接过滤 rmi，ldap，jndi

按照 Filter 所写即可。



## 对于 Fastjson 其他版本漏洞

首先是关闭 setAutoSupport，再加上 Filter 的防护即可。






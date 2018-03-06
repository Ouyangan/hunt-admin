**系统介绍**

包含通用模块的后台管理系统,名字来源于BBC的纪录片`The hunt` ,用的都是工作中比较主流的框架 , 主要特点

- 用redis实现`shiroCache`,`shiroSession`管理, 服务器重启不会影响用户状态信息 .
- 灵活的权限配置方案,可为某一角色统一配置权限也可为某一用户单独配置权限 ,最大化满足个性化权限需求 ,并且权限动态刷新,立即生效 ,无需重新登录,
-  职位信息由 部门,角色,权限组成, 基本满足各种变态人事组织需求 ,无限制上下级目录,身兼多职都不是问题....
- 终端登录限制 ,自动下线同类型终端异地账号 , 强制某终端用户下线 ,禁用启动账户 .
- ip拦截
- 数据字典: 查询自动走缓存, 拒绝硬编码....
- 请求日志,开发环境错误日志输出,方便分析和调试 .
- 统一异常处理,json请求返回json类型错误数据,普通web请求返回普通web错误页面.
- 生产,开发,本地环境分离, 便于持续集成 ,例如 `mvn clean install -Pprod`
- 集成`springfox`文档管理 , 接口调试非常方便 , 解决文档维护痛点....


**系统部署**

- 创建`mysql`数据库 ,运行`doc`文件夹下的`hunt-admin-initdb.sql`, 安装`Redis`(port:6379)... 可根据自身环境修改`env.properties`的数据库和redis属性.
- IDE导入maven工程 ,等待依赖下载 .
- 设置访问端口为:8086 ,不然极限验证通不过(绑定了127.0.0.1:8086端口) , 当然你可以自己申请极限验证账号绑定自己设置的端口,然后替换调数据字典的值
- `run` , `用户名`:admin/admin2 `密码`:111111,,然后就随意折腾吧

**技术方案**

- Spring
- Springmvc
- Shiro
- Springfox
- Mybatis
- Mysql
- Redis
- Jquery
- EasyUi
- Maven

**License**

- apache license 2.0


**系统截图**
![](https://ws1.sinaimg.cn/large/005FPDgcgy1fp2xf2bg5lj30jg0a1gmd.jpg)
![](https://ws1.sinaimg.cn/large/005FPDgcgy1fp2xf29ixoj30jg0a10th.jpg)
![](https://ws1.sinaimg.cn/large/005FPDgcgy1fp2xf2kd8dj30jg0a1mzg.jpg)
![](https://ws1.sinaimg.cn/large/005FPDgcgy1fp2xf2a4qoj30jg0a1ta7.jpg)
![](https://ws1.sinaimg.cn/large/005FPDgcgy1fp2xf2mzohj30jg0a1n16.jpg)
![](https://ws1.sinaimg.cn/large/005FPDgcgy1fp2xf2a90pj30jg0a1q3i.jpg)
![](https://ws1.sinaimg.cn/large/005FPDgcgy1fp2xf2aujtj30jg0a0jsn.jpg)
![](https://ws1.sinaimg.cn/large/005FPDgcgy1fp2xf2jvuoj30jg0a1dhu.jpg)
![](https://ws1.sinaimg.cn/large/005FPDgcgy1fp2xf2chegj30jg0a1q3u.jpg)
![](https://ws1.sinaimg.cn/large/005FPDgcgy1fp2xf2fkvkj30jg0a13zd.jpg)
![](https://ws1.sinaimg.cn/large/005FPDgcgy1fp2xf2fkd7j30jg0a175e.jpg)
![](https://ws1.sinaimg.cn/large/005FPDgcgy1fp2xf2ey8rj30jg0a175e.jpg)
![](https://ws1.sinaimg.cn/large/005FPDgcgy1fp2xf2fr5sj30jg0a1q3i.jpg)
![](https://ws1.sinaimg.cn/large/005FPDgcgy1fp2xf2ii7xj30jg0a174g.jpg)



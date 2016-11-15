**系统介绍**
写了一个包含通用模块的后台管理系统,名字来源于BBC的纪录片`The hunt` ,用的都是工作中比较主流的框架 , 主要特点

- redis实现`shiroCache`,`shiroSession`管理 , 服务器重启不会影响用户状态信息 .
- 灵活的权限配置方案,可为某一角色统一配置权限也可为某一用户单独配置权限 ,最大化满足个性化权限需求 ,并且权限动态刷新,立即生效 ,无需重新登录,
-  职位信息由 部门,角色,权限组成, 基本满足各种变态人事组织需求 ,无限制上下级目录,身兼多职都不是问题....
- 终端登录限制 ,自动下线同类型终端异地账号 , 强制某终端用户下线 ,禁用启动账户 .
- ip拦截
- 数据字典: 查询自动走缓存, 拒绝硬编码....
- 请求日志 , 方便安全分析和调试 .
- 生产,开发,本地环境分离, 便于持续集成 ,例如 `mvn clean install -Pprod`
- 集成`springfox`文档管理 , 接口调试非常方便 , 解决文档维护痛点....
- 前端渣渣 , 请见谅 ,方便的话有问题可以加群`234700542`或者直接提`issue` .
- 最重要的是!!!! 希望能给大家带来点帮助 ,一起来完善这个项目 .

**系统部署**

- 创建`mysql`数据库 ,运行`doc`文件下有`init-mysql-data.sql`, 安装`Redis`(port:6379)... 根据自身环境修改`env.properties`的数据库和redis属性.
- IDE导入maven工程 ,等待依赖下载 .
- 设置访问端口为:8086 ,不然验证码通不过 , 当然你可以自己申请极限验证账号,然后替换调数据字典的值
- `run`.......

**技术方案**

- Spring
- Springmvc
- Shiro
- Springfox
- Mybatis
- Redis
- Jquery
- EasyUi
- Maven


**系统截图**
![替代文字](http://p1.bqimg.com/4851/4a6a222a29b1d4c1.png)
![替代文字](http://p1.bqimg.com/4851/6a30506afe02caa2.png)
![替代文字](http://p1.bqimg.com/4851/9dbcd8135b7b9cb1.png)
![替代文字](http://p1.bqimg.com/4851/afe209af02550a34.png)
![替代文字](http://p1.bqimg.com/4851/66e82ce59fb03549.png)
![替代文字](http://p1.bqimg.com/4851/e24fef8561511726.png)
![替代文字](http://p1.bqimg.com/4851/db2808f33d551d37.png)
![替代文字](http://p1.bqimg.com/4851/9cc5071731aa3c18.png)
![替代文字](http://p1.bqimg.com/4851/62293ece6299db68.png)
![替代文字](http://p1.bqimg.com/4851/896e1bc570dd3e45.png)
![替代文字](http://p1.bqimg.com/4851/a7e3a4b73f160607.png)
![替代文字](http://p1.bqimg.com/4851/7096c16da9922919.png)
![替代文字](http://p1.bqimg.com/4851/9513db5d2381aa20.png)



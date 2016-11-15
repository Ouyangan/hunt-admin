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
![替代文字](https://box.worktile.com/view/76ad7299001b463984c319216574312d?pid=ea3ba2f9b5834cdca4a533587ea0725b)
![替代文字](https://box.worktile.com/view/8dccf1498b5845fcbd1bc76155a47835?pid=ea3ba2f9b5834cdca4a533587ea0725b)
![替代文字](https://box.worktile.com/view/f428fa3e1bb64508bac1205fd10261f9?pid=ea3ba2f9b5834cdca4a533587ea0725b)
![替代文字](https://box.worktile.com/view/341f35c0f4e54c4a8acd49217349c4ed?pid=ea3ba2f9b5834cdca4a533587ea0725b)
![替代文字](https://box.worktile.com/view/fbf5ec474cea4bd4a32de44e690f2a11?pid=ea3ba2f9b5834cdca4a533587ea0725b)
![替代文字](https://box.worktile.com/view/407b241a11e2437b9f5a057bc49aaa8b?pid=ea3ba2f9b5834cdca4a533587ea0725b)
![替代文字](https://box.worktile.com/view/8f8d2b9b82fb437da5962343ff97b5d3?pid=ea3ba2f9b5834cdca4a533587ea0725b)
![替代文字](https://box.worktile.com/view/93b4385bbe6d46de9250e98d9be007cd?pid=ea3ba2f9b5834cdca4a533587ea0725b)
![替代文字](https://box.worktile.com/view/d571f8ec5c4942fbb6330f432f24939d?pid=ea3ba2f9b5834cdca4a533587ea0725b)
![替代文字](https://box.worktile.com/view/429683b34db645ad9670f857737f2e7e?pid=ea3ba2f9b5834cdca4a533587ea0725b)
![替代文字](https://box.worktile.com/view/6cbbe50fa5c84d4b9401f9c5d44c2edd?pid=ea3ba2f9b5834cdca4a533587ea0725b)
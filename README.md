# NOIOJ 

### 基于Spring+Mybatis的后台接口

OJ核心判题功能由开源项目hustoj实现，在hustoj的基础上对数据库进行了修改

### 使用
1、配置 resources 底下的 application.properties 文件中的数据库连接属性
```
spring.datasource.url=jdbc:mysql://localhost:3306/jol?useUnicode=true&characterEncoding=utf8&rewriteBatchedStatements=true
spring.datasource.username=root
spring.datasource.password=
```
2、在Linux系统上安装hustoj https://github.com/zhblue/hustoj

3、启动项目
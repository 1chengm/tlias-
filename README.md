# Tlias Web 管理系统

## 项目简介
Tlias Web 管理系统是一个基于Spring Boot开发的企业级Web应用管理系统，主要用于管理企业部门、员工、班级和学生信息。系统采用前后端分离架构，提供完整的RESTful API接口。

## 技术栈
- 后端框架：Spring Boot
- 数据库：MySQL
- ORM框架：MyBatis
- 分页插件：PageHelper
- 日志框架：Logback
- 安全认证：JWT
- 其他工具：Lombok, AOP等

## 主要功能模块
1. 用户认证模块
   - 用户登录
   - JWT令牌认证
   - 全局拦截器

2. 部门管理模块
   - 部门列表查询
   - 部门新增
   - 部门修改
   - 部门删除（包含关联检查）

3. 员工管理模块
   - 员工信息分页查询
   - 员工信息新增
   - 员工信息修改
   - 员工信息删除
   - 员工登录认证

4. 班级管理模块
   - 班级信息分页查询
   - 班级信息新增
   - 班级信息修改
   - 班级信息删除

5. 学生管理模块
   - 学生信息分页查询
   - 学生信息新增
   - 学生信息修改
   - 学生信息删除
   - 学生违规记录

6. 系统日志模块
   - 操作日志记录
   - 日志分页查询
   - AOP切面实现

## 项目结构
```
src/main/java/com/mcc/
├── anno/           # 自定义注解
├── aop/            # 切面类
├── config/         # 配置类
├── controller/     # 控制器
├── exception/      # 异常处理
├── interceptor/    # 拦截器
├── mapper/         # MyBatis映射接口
├── pojo/           # 实体类
├── service/        # 服务接口
│   └── impl/      # 服务实现类
└── utils/          # 工具类
```

## 快速开始

### 环境要求
- JDK 1.8+
- MySQL 5.7+
- Maven 3.6+

### 数据库配置
1. 创建数据库：tlias
2. 修改 `application.yml` 中的数据库连接信息：
```yaml
spring:
  datasource:
    driver-class-name: com.mysql.cj.jdbc.Driver
    url: jdbc:mysql://localhost:3306/tlias
    username: your_username
    password: your_password
```

### 运行项目
1. 克隆项目到本地
2. 使用Maven安装依赖：`mvn clean install`
3. 运行主类：`TliasWebManagementApplication`
4. 访问接口：`http://localhost:8080`

## API接口说明

### 认证接口
- POST `/login` - 用户登录

### 部门管理接口
- GET `/depts` - 获取部门列表
- POST `/depts` - 新增部门
- PUT `/depts` - 修改部门
- DELETE `/depts` - 删除部门
- GET `/depts/{id}` - 获取部门详情

### 员工管理接口
- GET `/emps` - 获取员工列表（分页）
- POST `/emps` - 新增员工
- PUT `/emps` - 修改员工
- DELETE `/emps` - 删除员工
- GET `/emps/{id}` - 获取员工详情

### 班级管理接口
- GET `/clazzs` - 获取班级列表（分页）
- POST `/clazzs` - 新增班级
- PUT `/clazzs` - 修改班级
- DELETE `/clazzs/{id}` - 删除班级
- GET `/clazzs/{id}` - 获取班级详情

### 学生管理接口
- GET `/students` - 获取学生列表（分页）
- POST `/students` - 新增学生
- PUT `/students` - 修改学生
- DELETE `/students/{ids}` - 删除学生
- GET `/students/{id}` - 获取学生详情
- PUT `/students/violation/{id}/{score}` - 记录学生违规

### 日志管理接口
- GET `/log/page` - 获取操作日志（分页）

## 特色功能
1. 统一响应处理
   - 使用 `Result` 类封装所有接口响应
   - 统一的成功/失败返回格式

2. 全局异常处理
   - 使用 `@RestControllerAdvice` 实现全局异常捕获
   - 统一的异常响应格式

3. 操作日志记录
   - 使用自定义注解 `@LogOperation` 标记需要记录日志的方法
   - 通过AOP实现自动日志记录
   - 记录操作人、操作时间、操作内容等信息

4. 文件上传功能
   - 支持文件上传
   - 自动生成唯一文件名
   - 文件大小限制配置

## 注意事项
1. 所有接口（除登录接口外）都需要在请求头中携带JWT令牌
2. 文件上传大小限制为10MB
3. 删除部门时会检查是否存在关联员工
4. 所有时间字段使用LocalDateTime类型

## 开发团队
- 开发者：MCC

## 许可证
本项目采用 MIT 许可证 
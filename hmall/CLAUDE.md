# CLAUDE.md

This file provides guidance to Claude Code (claude.ai/code) when working with code in this repository.

## Build & Run

```bash
# 编译整个项目
mvn clean compile -f hmall/pom.xml

# 编译并打包
mvn clean package -f hmall/pom.xml -DskipTests

# 启动 hmall-service（需先启动 Nacos 和 MySQL）
mvn spring-boot:run -f hmall/hmall-service/pom.xml

# 或者直接运行启动类
# com.hmall.service.HmallServiceApplication
```

**启动依赖**: MySQL (localhost:3306/hmall) + Nacos Server (localhost:8848)

**API 文档**: 启动后访问 `http://localhost:8080/doc.html`

## 项目架构

```
hmall (父 POM)
├── hmall-api          # API 模块 — 微服务间共享的契约层
│   ├── entity/        # 数据库实体（MyBatis-Plus @TableName 映射）
│   ├── dto/           # 通用 DTO（如 PageDTO）
│   └── client/        # OpenFeign 接口（服务间调用的 REST 契约）
└── hmall-service      # 服务模块 — 可独立运行的 Spring Boot 应用
    ├── mapper/        # MyBatis-Plus BaseMapper
    ├── service/       # IService 接口
    │   └── impl/      # ServiceImpl 实现
    ├── controller/    # REST 控制器（同时是 Feign 接口的实现）
    └── config/        # 配置类
```

- `hmall-api` 不独立运行，作为 jar 被其他微服务依赖，提供实体类 + Feign 契约
- `hmall-service` 是 Spring Boot 可执行应用，实现具体业务逻辑
- 其他微服务引入 `hmall-api` 后，通过 `@EnableFeignClients(basePackages = "com.hmall.api.client")` 注入 Feign Client 调用接口

## 技术栈

| 组件 | 版本 | 用途 |
|---|---|---|
| Spring Boot | 2.7.18 | 基础框架 |
| Spring Cloud | 2021.0.9 | 微服务体系 |
| Alibaba Nacos | 2021.0.5.0 | 服务注册发现 |
| OpenFeign | — | 服务间 REST 调用 |
| MyBatis-Plus | 3.5.5 | ORM |
| Knife4j | 4.5.0 | API 文档（/doc.html） |
| Java | 1.8 | 运行时 |

## 数据库（hmall 库，共 8 张表）

user、item、address、cart、order、order_detail、order_logistics、pay_order

- MyBatis-Plus 自动映射下划线转驼峰（`map-underscore-to-camel-case: true`）
- `pay_order` 表使用 `@TableLogic` 逻辑删除（字段 `is_delete`）
- `create_time` / `update_time` 由 `MetaObjectHandler` 自动填充，无需手动设值
- 分页查询通过 `PaginationInnerInterceptor` + `PageDTO.of(page)` 返回统一分页结构

## 代码约定

- **依赖注入**: 使用 `@Resource`（非 `@Autowired`）
- **实体类**: 实现 `Serializable`，使用 `@Accessors(chain = true)` 支持链式调用
- **CRUD 模式**: Controller 直接调用 MyBatis-Plus 的 `IService` 方法（`save`、`updateById`、`removeById`、`getById`、`page`）
- **Controller ↔ Feign 路径一致**: 例如 `@FeignClient(path = "/api/user")` 和 `@RequestMapping("/api/user")` 保持路径同步
- **每个 Feign Client 必须有 `contextId`**: 防止多客户端时注册冲突
- **分页接口**: 返回 `PageDTO<T>`，参数 `pageNum`（默认 1）、`pageSize`（默认 10）

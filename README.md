# GoodsPool
# 1. 项目结构概述
- MCV结构简图
    - model对应`src/com/example/model`中的代码，其代表意义是现实中的实体，比如学生或者商品
    - controller对应`src/com/example/web`下的代码，控制界面的显示逻辑
    - view对应`web/`下的代码，对应各种html/jsp文件，用于展示网页
- 第一步：请求表单结构及流程
    1. 客户端请求`Result.html`页面，图中有错，应该是html
        - 注意，请求`request`在该过程中是一个对象，拥有自己的实例变量和相关方法
    1. 容器（就是Tomcat）检索`Result.html`页面
    1. 容器将所请求的页面返回给浏览器，该页面是一张表单，为了收集用户所填写的信息
- 第二步：告诉服务器填了什么
    4. 浏览器向容器发送一个`request`
    5. 容器根据URL找到合适的Servlet，并将该`request`传给Servlet
    6. Servlet调用模型对象进行相关数据的处理
    7. 模型对象返回答案，并将之放到`request`中
    8. Servlet将`request`传给JSP
    9. JSP从`request`对象获得答案
    10. JSP根据答案产生一个页面给容器
    11. 容器将页面给到客户端

# 2. 网页逻辑概述

- 每一个矩形框表示一个单独的网页，网页格式（html或者jsp）根据是否需要动态加载确定
- 表头表示该页类别、表中每一行表示该页能够超链接到的其它页面
- 页中需要的元素未在表中添加，由开发人员决定

# 3. 文件结构概述
- 源码部分：
    - goodsPool：根目录
    - goodsPool/src/com/example/model：用于存放模型类的源码文件
    - goodsPool/src/com/example/web：存放用于web逻辑控制的源码以及生成页面的jsp文件
    - goodsPool/src/com/example/listener：存放用于数据库操作相关的代码
    - goodsPool/lib：外部依赖包
    - goodsPool/web：存放static html文件
    - goodsPool/etc：存放deployment descriptor（部署描述符）
    - goodsPool/classes：存放编译后生成的class文件，子目录结构会自动生成
- 编译后部分：
    <img src="assets/compiled-str.svg" width=20%/>
    - goodsPool：根目录，同时存放index.html、result.jsp等网页文件
    - WEB-INF：存放web.xml和classes文件，后者是源码编译的结果

# 4. 模式设计
- Servlet设计
    - 登录
        - servlet-name:`GLogin`
        - servlet-class:`com.example.web.GLogin`
        - url-pattern:`/Login.do`
    - 注册
        - servlet-name:`GRegister`
        - servlet-class:`com.example.web.GRegister`
        - url-pattern:`/Register.do`
    - 购物
        - servlet-name:`GShop`
        - servlet-class:`com.example.web.GShop`
        - url-pattern:`/Shop.do`
    - 结账
        - servlet-name:`GCheck out`
        - servlet-class:`com.example.web.GCheck`
        - url-pattern:`/Check.do`
- 数据库设计(MySQL 8.0.29)  // 需要重新设计
    - Table 1 `g_goods`
        |Instance|Type|Is NULL|Other|
        |--------|----|-------|-----|
        |goods_id|INT UNSIGNED|NOT NULL|AUTO_INCREMENT|
        |goods_name|VARCHAR(100)|NOT NULL|-|
        |goods_price|DOUBLE|NOT NULL|-|
        |goods_description|VARCHAR(1000)|-|-|
        |submission_date|DATE|NOT NULL|-|
    - Table 2 `g_users`
        |Instance|Type|Is NULL|Other|
        |--------|----|-------|-----|
        |user_id|INT UNSIGNED|NOT NULL|AUTO_INCREMENT|
        |user_name|VARCHAR(100)|NOT NULL|-|
        |user_password|VARCHAR(100)|NOT NULL|-|
        |register_date|DATE|NOT NULL|-|
- Model 设计
    - g_user
    - g_goods
- View 设计
- Controller 设计

# 5. 问题解决
- 幂等性问题
  - 碰巧发现，搜索解决

# 6. 由上引申出的任务列表
1. 数据库模块
  1. 实体设计（建议规范化，没时间就直接设计，生成SQL脚本）
     1. 用户（id、用户名、密码、对应的学生）
     2. 学生（学号、姓名、性别、生日等，均非必填，开始为空，后期选择补充） 
     3. 商品（id、名字、类别、购入价格、预期价格、是否已出、购入日期、描述）
     4. 购物车（商品、对应的日期）
     5. 购买记录（id、日期、卖家、买家（用用户id表示）、备注）
  2. 细节完善（指定适当的类型、是否自增、主键是什么等等）
2. 服务器和数据库的连接
   1. 将初始化连接的代码放到`com/example/listener`包中
   2. 将数据库连接对象（类似游标）的引用放到ServletContext对象中供所需对象使用
   3. （或者、先在需要连接的地方都连接一次，最后再重构代码）
3. 服务器对页面的逻辑控制及数据存储
   1. 各个页面的跳转
      1. 设计Servlet用于页面的重定向
      2. 设计JSP判断跳转的逻辑
   2. 对用户数据的临时保存
      1. 学习并使用Cookie和Session的关系，以及相关数据的交互方式
      2. 将用户的临时数据存在Session中
   3. 对用户数据的长久保存
      1. 设计SessionListener对象，在Sesssion被invalidated的时候能够将用户的数据保存到数据库中
      2. 研究存储图像的方法
4. 美化页面
   1. 学习CSS、HTML等前端知识
   2. 运用所学的前端知识丰满相关的JSP、HTML页面
   3. 添加页面重定向动态效果

# 7.另一种文件目录框架
dao层（直接与数据库对接，处理数据库的增删改查等操作），service层（提供相应的业务，如添加用户，修改用户信息等。调用dao层，并为servlet层提供接口），servlet层（与前端对接，处理请求和发出响应）

- 1.逻辑框架图
  ![image](https://user-images.githubusercontent.com/86513588/189508437-78f490e8-d9d3-47de-b3c9-7cf8f70e1339.png)
- 2.文件目录图

  <img width="165" alt="image" src="https://user-images.githubusercontent.com/86513588/189508441-98989e6f-a1de-4911-a5a9-154d256ddd92.png">


# 备注
1. Listener的部分解释
  - Functions
      - Get notified when the context is intialized(app is being deployed).
          - Get the context init parameters from the ServletContext.
          - Use the Init parameter lookup name to make a database connection.
          - Store the database connection as an attribute, so that all parts of the web app can access it.
      - Get notified when the context is destoryed(the app is undeployed or goes down).
          - close the database connection.
  - 

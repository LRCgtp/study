#####项目运行
a. 通过id查询组织详情，并插入该条数据到数据库
访问：http://localhost:8080/my/org/v1/organizations/1（数据库只有id为1有数据）
b.获取刚才插入成功的组织信息
网址：http://localhost:8080/my/org/v1/organizations/selectOriginalById
c.通过组织id和用户id查询某个组织下的某个用户信息,并插入信息到数据库
网址：http://localhost:8080/my/user/v1/organizations/1}/users/1

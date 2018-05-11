namespace java com.hlj.thrift

struct User {
    1: required i64 id;
    2: required string mobile;
    3: required string password;
}

struct UserRole {
    1: required i64 id;
    2: required i64 userId;
    3: required i64 roleId;
}

struct Role {
    1: required i64 id;
    2: required string name;
    3: required i32 status;
}

struct RoleFunction {
    1: required i64 id;
    2: required i64 roleId;
    3: required i64 functionId;
}

struct Function {
    1: required i64 id;
    2: required string name;
    3: required i32 status;
    4: required string url;
    5: required i64 parentId
}



service HljService {
    //mysql
    string ping();
    User getUserFromDB(1:string mobile);

    //redis
    string getFromRedis(1:string key);
    bool saveUserToRedis(1:User user);
    User getUserFromRedis(1:string mobile);
}
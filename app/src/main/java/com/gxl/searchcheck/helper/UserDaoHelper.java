package com.gxl.searchcheck.helper;

import com.gxl.searchcheck.greendao.DaoManager;
import com.gxl.searchcheck.greendao.User;
import com.gxl.searchcheck.greendao.UserDao;

import org.greenrobot.greendao.query.QueryBuilder;

/**
 * @author Tomze
 * @time 2018年12月23日 22:51
 * @desc
 */
public class UserDaoHelper extends DaoManager{

    private static volatile UserDaoHelper mInstance;
    private UserDaoHelper() {}

    /**
     * 获取DaoManager的实例
     */
    public static UserDaoHelper getInstance() {
        if (mInstance == null) {
            synchronized (UserDaoHelper.class) {
                if (mInstance == null) {
                    mInstance = new UserDaoHelper();
                }
            }
        }
        return mInstance;
    }

    public void insertUser(User user) {
        getDaoSession().getUserDao().insert(user);
    }

    public User getUserInfo(){
        QueryBuilder<User> queryBuilder = getDaoSession().getUserDao().queryBuilder().where(UserDao.Properties.Age.eq(12));
        User user =  queryBuilder.unique();
        return user;
    }

}

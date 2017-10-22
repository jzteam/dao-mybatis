package cn.jzteam.dao.mybatis;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.transaction.TransactionException;

import cn.jzteam.dao.TaskDao;
import cn.jzteam.dao.entity.TaskEntity;
import cn.jzteam.dao.util.SpringTransactionUtil;

public class MybatisTest {

    private ClassPathXmlApplicationContext ioc = new ClassPathXmlApplicationContext("config/applicationContext.xml");
    
    public static void main(String[] args) {
    	MybatisTest main = new MybatisTest();
    	TaskDao dao = main.ioc.getBean(TaskDao.class);
        
//    	Class<? extends TaskDao> clazz = dao.getClass();
//    	System.out.println(clazz.getSimpleName());
//    	Class<?>[] interfaces = clazz.getInterfaces();
//    	for (Class<?> c : interfaces) {
//    		System.out.println(c.getName());			
//		}
    	
        main.create(dao);
        
    }

    public void create(TaskDao mapper) {
    	
    	SpringTransactionUtil.begin();
    	TaskEntity entity = new TaskEntity();
        try {
            // 操作数据库
            entity.setTask("first");
            entity.setTime("20171012");
            entity.setUserId(100);
            long insert2 = mapper.insert(entity);
            System.out.println("插入entity111,insert="+insert2+",id="+entity.getId());
            
            // 操作数据库
            entity.setTime("20171013");
            long insert = mapper.insert(entity);
            System.out.println("执行插入222,insert="+insert+",id="+entity.getId());
            
//            insert(mapper);
            
//            System.out.println(1/0);
            
            // 提交事务
            SpringTransactionUtil.commit();
            System.out.println("更新后commit");
        } catch (Exception e) {
            System.out.println("异常回滚");
            e.printStackTrace();
            // 回滚事务
            try {
            	SpringTransactionUtil.rollback();
            } catch (TransactionException e1) {
            }
        }
        
        System.out.println("entity.id="+entity.getId());
        return;
    }
    

}

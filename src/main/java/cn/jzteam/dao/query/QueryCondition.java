package cn.jzteam.dao.query;


/**
 * 条件查询的基类
 */
public class QueryCondition {

    // 希望获取的字段，以逗号分隔。
    protected String queryStr;

    // 排序字段。需要包含排序方式。e.g.: " out_nation ASC, in_nation DESC "
    protected String orderStr;
    
    public String getQueryStr() {
        return queryStr;
    }

    public void setQueryStr(String queryStr) {
        this.queryStr = queryStr;
    }

    public String getOrderStr() {
        return orderStr;
    }

    public void setOrderStr(String orderStr) {
        this.orderStr = orderStr;
    }

}

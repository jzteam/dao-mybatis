package cn.jzteam.dao.mybatis;


/**
 * 分页查询的基类。
 */
public class QueryCondition {

    /**
     * 是否查询记录总数
     */
    private boolean hasCount = false;
    
    /**
     * 是否分页查询
     */
    private boolean isPageQuery = true;

    // 当前页码，默认为第一页。
    private int currentPage = 1;

    // 每页记录数，默认20。
    private int pageSize = 20;

    // 希望获取的字段，以逗号分隔。
    private String queryStr;

    // 排序字段。需要包含排序方式。e.g.: " out_nation ASC, in_nation DESC "
    private String orderStr;
    
    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

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

    /**
     * 返回当前页的初始记录序号。
     *
     * @return
     */
    public long getStartIndex() {
        if (this.currentPage <= 1) {
            return 0;
        }
        return (this.currentPage - 1) * this.pageSize;
    }

	public boolean isHasCount() {
		return hasCount;
	}

	public void setHasCount(boolean hasCount) {
		this.hasCount = hasCount;
	}

	public boolean isPageQuery() {
		return isPageQuery;
	}

	public void setPageQuery(boolean isPageQuery) {
		this.isPageQuery = isPageQuery;
	}
    
}

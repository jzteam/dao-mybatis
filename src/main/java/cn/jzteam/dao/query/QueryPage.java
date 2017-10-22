package cn.jzteam.dao.query;


/**
 * 分页查询的基类
 */
public class QueryPage extends QueryCondition {
	 // 是否查询记录总数
    protected boolean hasCount = false;

    // 当前页码，默认为第一页。
    protected int currentPage = 1;

    // 每页记录数，默认20。
    protected int pageSize = 20;
    
    /**
     * mapper文件使用，返回当前页的初始记录序号。
     *
     * @return
     */
    public long getStartIndex() {
        if (this.currentPage <= 1) {
            return 0;
        }
        return (this.currentPage - 1) * this.pageSize;
    }

	public boolean getHasCount() {
		return hasCount;
	}

	public void setHasCount(boolean hasCount) {
		this.hasCount = hasCount;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
    
    
}

package cn.gov.util;

/**
 * Created by 412 on 2017/5/18.
 */
public class Pager {
    //第几页，从1开始
    private int index = 1;
    private int size = 10;
    private boolean getCount = true;
    private int count = -1;
    private String sortFields=null;
    private String whereCondition = null;


    public int getIndex()
    {
        return index;
    }
    public void setIndex(int value)
    {
        if (value < 0) return;
        index = value ;
    }


    /**
     * 获取页面大小
     * @return 页面大小
     */
    public int getSize() {
        return size;
    }

    /**
     * 设置页面大小
     * @param size 页面大小
     */
    public void setSize(int size) {
        this.size = size;
    }

    /**
     * 是否刷新记录总数
     * @return
     */
    public boolean isGetCount() {
        return getCount;
    }

    /**
     * 是否刷新记录总数
     * @param getCount
     */
    public void setGetCount(boolean getCount) {
        this.getCount = getCount;
    }

    /**
     * 记录总数
     * @return
     */
    public int getCount() {
        return count;
    }

    /**
     * 记录总数
     * @param count
     */
    public void setCount(int count) {
        this.count = count;
    }


    public String getSortFields() {
        return sortFields;
    }

    public void setSortFields(String sortFields) {
        this.sortFields = sortFields;
    }
    public  int getStartRow()
    {
        return (index-1)*size;
    }
    /**
     * 总页数，根据页面大小和记录总数计算得到
     * @return
     */
    public int getPageCount()
    {
        if (getCount() <= 0) return 0; return (getCount() - 1) / getSize() + 1;
    }

    public String getWhereCondition() {
        return whereCondition;
    }

    public void setWhereCondition(String whereCondition) {
        this.whereCondition = whereCondition;
    }
}
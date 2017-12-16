package cn.gov.util;

/**
 * Created by MANAGER_ROLEID on 2017-04-12. 查询数据
 */
public class JsonData {
        private int total;
        private Object rows;
        private Object other;

        public int getTotal() {
                return total;
        }

        public void setTotal(int total) {
                this.total = total;
        }

        public Object getRows() {
                return rows;
        }

        public void setRows(Object rows) {
                this.rows = rows;
        }

        public Object getOther() {
                return other;
        }

        public void setOther(Object other) {
                this.other = other;
        }
}

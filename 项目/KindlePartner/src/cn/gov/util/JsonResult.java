package cn.gov.util;

public class JsonResult {

	public boolean success; // ״̬��
	public String message; // ������Ϣ
	public Object data; // ��������

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

}

package mx.com.udes.metaphorceResponses;

import java.text.SimpleDateFormat;
import java.util.Date;

public class CustomResponse {
	private boolean exito;
	private String msg;
	private String timestamp;

	public CustomResponse(boolean exito, String msg) {

		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

		this.exito = exito;
		this.msg = msg;
		this.timestamp = format.format(new Date());
	}

	public boolean isExito() {
		return exito;
	}

	public void setExito(boolean exito) {
		this.exito = exito;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public String getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}
}

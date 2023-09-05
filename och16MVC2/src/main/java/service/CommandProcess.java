package service;

import java.io.IOException;
import java.rmi.ServerException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface CommandProcess {
	public String reqeuestPro(HttpServletRequest request ,
							HttpServletResponse response
							) throws ServerException,IOException;							

}

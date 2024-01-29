package com.javalec.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Command {
	
	public void execute(HttpServletRequest request, HttpServletResponse response);

	public boolean execute2(HttpServletRequest request, HttpServletResponse response);
}

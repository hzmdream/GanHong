package com.ganhong.controller.test;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("mytest/")
public class VerifyCodeTest {

	@RequestMapping("image/")
	public void getImage(HttpServletRequest request, HttpServletResponse response) throws IOException{
		System.out.println("-----------------------------------------------nidaye----------------------------------");
		/*
		 * 1. 生成图片
		 * 2. 保存图片上的文本到session域中
		 * 3. 把图片响应给客户端
		 */
		VerifyCode vc = new VerifyCode();
		BufferedImage image = vc.getImage();
		request.getSession().setAttribute("session_vcode", vc.getText());//保存图片上的文本到session域
		
		VerifyCode.output(image, response.getOutputStream());
	}
	
}

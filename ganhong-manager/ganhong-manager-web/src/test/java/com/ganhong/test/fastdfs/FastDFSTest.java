package com.ganhong.test.fastdfs;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.csource.common.MyException;
import org.csource.fastdfs.ClientGlobal;
import org.csource.fastdfs.StorageClient;
import org.csource.fastdfs.StorageServer;
import org.csource.fastdfs.TrackerClient;
import org.csource.fastdfs.TrackerServer;
import org.junit.Test;

public class FastDFSTest {

	@Test
	public void testFastDFS() throws FileNotFoundException, IOException, MyException{
		//1.将FastDFS提供的jar包添加到工程中
		//2.加载配置文件,初始化全局配置
		ClientGlobal.init("D:\\ganhong\\gh_workspace\\GanHong\\ganhong-manager\\ganhong-manager-web\\src\\main\\resources\\properties\\client.conf");
		//3.创建TrackerClient对象
		TrackerClient trackerClient = new TrackerClient();
		//4.创建TrackerServer对象
		TrackerServer trackerServer = trackerClient.getConnection();
		//5.创建StorageServer对象
		StorageServer storageServer = null;
		//6.获得StorageClient对象
		StorageClient storageClient = new StorageClient(trackerServer, storageServer);
		//7.直接调用StorageClient对象方法上传文件
		String[] upload_file = storageClient.upload_file("C:\\Users\\usky\\Desktop\\image\\lufei.jpg", "jpg", null);
		for (String string : upload_file) {
			System.out.println(string);
		}
		/**
		 * 返回String数组中有两个元素
		 * 第一个元素为group名称--group1
		 * 第二个元素为二级目录+随机生成的文件名称--M00/00/00/wKhPhFgjuECADxcoAADoXOW8Evo684.jpg
		 */
	}
	
	@Test
	public void testFastDFSClient() throws Exception{
//		FastDFSClient client = new FastDFSClient("D:\\ganhong\\gh_workspace\\GanHong\\ganhong-manager\\ganhong-manager-web\\src\\main\\resources\\properties\\client.conf");
		FastDFSClient client = new FastDFSClient("properties/client.conf");
		String uploadFile = client.uploadFile("C:\\Users\\usky\\Desktop\\image\\gundan.jpg", "jpg");
		System.out.println(uploadFile);
		
	}
}

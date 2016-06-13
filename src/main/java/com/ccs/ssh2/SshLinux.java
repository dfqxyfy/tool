//package com.ccs.ssh2;
//
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStream;
//import java.io.InputStreamReader;
//import java.io.OutputStream;
//
//import ch.ethz.ssh2.Connection;
//import ch.ethz.ssh2.SCPClient;
//import ch.ethz.ssh2.Session;
//
//public class SshLinux {
//
//
//	public static void main(String[] args) throws Exception {
//		String IP = "101.200.171.112";
//		int PORT = 22;
//		Connection con = new Connection(IP, PORT);
//
//		//连接
//
//		con.connect();
//
//		//远程服务器的用户名密码
//
//		String remoteUser = "root";
//		String remotePass = "Youyou200609";
//		boolean isAuthed = con.authenticateWithPassword(remoteUser,remotePass);
//
//		//建立SCP客户端
//		SCPClient scpClient = con.createSCPClient();
//
//		Session openSession = con.openSession();
//		openSession.execCommand("nohup /usr/local/mongodb/bin/mongod &");
//		InputStream stdout = openSession.getStdout();
//		BufferedReader br = new BufferedReader(new InputStreamReader(stdout));
//		String str = null;
//		while((str=br.readLine())!=null){
//			System.out.println(str);
//		}
//		openSession.close();
//	}
//}

package com.soft.pes.server;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

import java.net.InetAddress;

/**
 * @author Maixianglei
 * @time 2016-7-21
 */
public class ServerHandler extends SimpleChannelInboundHandler<String> {

	protected void channelRead0(ChannelHandlerContext ctx, String msg) throws Exception {
		// 收到消息直接打印输出
		System.out.println(ctx.channel().remoteAddress() + " 发来消息 : " + msg);

		// 返回客户端消息 - 我已经接收到了你的消息
		ctx.writeAndFlush("服务器已收到!\n");
	}

	/**
	 * 
	 * 覆盖 channelActive 方法 在channel被启用的时候触发 (在建立连接的时候)
	 * 
	 * channelActive 和 channelInActive 在后面的内容中讲述，这里先不做详细的描述
	 */
	public void channelActive(ChannelHandlerContext ctx) {
		System.out.println("发现客户端 : " + ctx.channel().remoteAddress() + " 接入 !");
		try {
			ctx.writeAndFlush("这里是 " + InetAddress.getLocalHost().getHostName() + " 服务器!\n");
			super.channelActive(ctx);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}

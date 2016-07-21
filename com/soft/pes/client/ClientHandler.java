package com.soft.pes.client;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

/**
 * @author Maixianglei
 * @time 2016-7-21
 */
public class ClientHandler extends SimpleChannelInboundHandler<String> {

	protected void channelRead0(ChannelHandlerContext ctx, String msg) throws Exception {
		System.out.println("服务器发来消息: " + msg);
	}

	public void channelActive(ChannelHandlerContext ctx) throws Exception {
		System.out.println("客户端启动");
		super.channelActive(ctx);
	}

	public void channelInactive(ChannelHandlerContext ctx) throws Exception {
		System.out.println("客户端结束");
		super.channelInactive(ctx);
	}
}

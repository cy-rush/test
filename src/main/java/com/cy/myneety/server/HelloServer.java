package com.cy.myneety.server;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;

/**
 * Netty服务端
 */
public class HelloServer {

    public static void main(String[] args) {
        //定义一对线程组
        //主线程组，用于接收客户端的连接，但是不做任何处理，跟老板一样
        EventLoopGroup bossGroup = new NioEventLoopGroup();
        //从线程组，老板线程组会把任务交给他处理，让他手下线程去做任务
        EventLoopGroup workerGroup = new NioEventLoopGroup();

        ServerBootstrap serverBootstrap = new ServerBootstrap();
        serverBootstrap.group(bossGroup,workerGroup)
                        .channel(NioServerSocketChannel.class)
                        .childHandler(null);
    }
}

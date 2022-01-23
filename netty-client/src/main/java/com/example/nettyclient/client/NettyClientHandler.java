package com.example.nettyclient.client;


import com.alibaba.fastjson.JSONObject;

import java.io.ByteArrayOutputStream;
import java.io.ObjectOutputStream;
import java.nio.charset.StandardCharsets;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class NettyClientHandler extends ChannelInboundHandlerAdapter {

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        // 建立链接的时候发送密码

        JSONObject map=new JSONObject();
        map.put("url","admin");

        //对象流序列化Map
        ByteArrayOutputStream os = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(os);
        oos.writeObject(map);
        byte[] bytes=os.toByteArray();

        //关闭流
        oos.close();
        os.close();

        //发送
        ctx.channel().writeAndFlush(Unpooled.copiedBuffer(bytes));

    }

    // 接受服务端响应时触发的事件
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        ByteBuf buffer = (ByteBuf) msg;
        byte[] bytes = new byte[buffer.readableBytes()];
        buffer.readBytes(bytes);
        String res = new String(bytes, StandardCharsets.UTF_8);

        log.info("服务端响应：" + res);
    }
}

package com.example.nettyserver.netty03;

import com.example.nettyserver.netty03.filter.HeaderHttpRequestFilter;
import com.example.nettyserver.netty03.filter.HttpRequestFilter;
import com.example.nettyserver.netty03.outbound.HttpOutboundHandler;

import java.util.List;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.handler.codec.http.FullHttpRequest;
import io.netty.util.ReferenceCountUtil;


public class HttpHandler extends ChannelInboundHandlerAdapter {

    private final List<String> proxyServer;
    private HttpOutboundHandler handler;
    private HttpRequestFilter filter = new HeaderHttpRequestFilter();

    public HttpHandler(List<String> proxyServer) {
        this.proxyServer = proxyServer;
        this.handler = new HttpOutboundHandler(this.proxyServer);
    }
    
    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) {
        ctx.flush();
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) {
        try {
            // 转换为 ByteBuf 缓冲区
//            ByteBuf buffer = (ByteBuf) msg;
//            byte[] bytes = new byte[buffer.readableBytes()];
//            // 缓冲区数据写到byte数组
//            buffer.readBytes(bytes);
//
//            ByteArrayInputStream is = new ByteArrayInputStream(bytes);
//            ObjectInputStream iss = new ObjectInputStream(is);
//
//            JSONObject jsonObject = (JSONObject) iss.readObject();
//
//            is.close();
//            iss.close();
            FullHttpRequest fullRequest = (FullHttpRequest) msg;
            String obj = handler.handle(fullRequest, ctx, filter);

//            String url = jsonObject.getString("url");
//            if(url.contains("/test") ){
//                ctx.channel().writeAndFlush(Unpooled.copiedBuffer("hello,fangwen".getBytes(StandardCharsets.UTF_8)));
//            }else{
//                ctx.channel().writeAndFlush(Unpooled.copiedBuffer("hello,others".getBytes(StandardCharsets.UTF_8)));
//                ctx.channel().closeFuture();
//            }
    
        } catch(Exception e) {
            e.printStackTrace();
        } finally {
            ReferenceCountUtil.release(msg);
        }
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
        cause.printStackTrace();
        ctx.close();
    }

}

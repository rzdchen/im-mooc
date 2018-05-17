package net.qiujuer.web.italker.push.service;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

/**
 * Created by CC on 2018/5/17.
 */
@Path("/account")
public class AccountService {
    @GET
    @Path("/login")
    public String get(){
        return "you get login";
    }
    @POST
    @Path("/login")
    //指定请求与返回的相应体为Json
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String post(){
        return "you get login";
    }
}

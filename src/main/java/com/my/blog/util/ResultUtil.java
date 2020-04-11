package com.my.blog.util;

/**
 * @author jiaomingyu5778@gmail.com
 * @date 2020/4/9 19:29
 */
public class ResultUtil {

    /**成功且带数据**/
    public static ResultBean success(Object object){
        ResultBean result = new ResultBean();
        result.setSucc(true);
        result.setCode(ResultEnum.SUCCESS.getCode());
        result.setMsg(ResultEnum.SUCCESS.getMsg());
        result.setData(object);
        return result;
    }
    /**成功但不带数据**/
    public static ResultBean success(){

        return success(null);
    }
    /**失败**/
    public static ResultBean error(Integer code,String msg){
        ResultBean result = new ResultBean();
        result.setSucc(false);
        result.setCode(code);
        result.setMsg(msg);
        return result;
    }
}
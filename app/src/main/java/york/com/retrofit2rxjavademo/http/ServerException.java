package york.com.retrofit2rxjavademo.http;

/**
 * @author YorkYu
 * @version V1.0
 * @Project: Supplier
 * @Package mall.b2b.meixun.com.supplier.net
 * @Description:
 * @time 2016/8/11 9:20
 */
public class ServerException extends RuntimeException{
    // 异常处理，为速度，不必要设置getter和setter
    public int code;
    public String message;
}

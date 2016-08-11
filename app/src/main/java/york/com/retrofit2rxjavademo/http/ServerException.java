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
    public int code;
    public String message;
}

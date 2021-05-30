package lib.net;

import java.util.Map;

import io.reactivex.rxjava3.core.Observable;
import okhttp3.RequestBody;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.HTTP;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by jcs on 2021/5/26.
 * Describe
 */
public interface API {
    /**https://api.apiopen.top/getJoke?page=1&count=2&type=video
     * 获取笑话列表
     * @return
     */
    @GET("getJoke")
    Observable<Object> getJoke(@Query("page") String page,@Query("count") String count,@Query("type") String type);

    /**
     * 获取天气信息
     * http://t.weather.itboy.net/api/weather/city/101030100
     */
    @GET("api/weather/city/{cityid}")
    Observable<Object> weather(@Path("cityid") String cityid);

}

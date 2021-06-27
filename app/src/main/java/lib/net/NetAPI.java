package lib.net;

import com.base.pj.model.JokeData;
import com.base.pj.model.PictureData;

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
public interface NetAPI {


    /**
     * 获取图片
     * http://api.btstu.cn/sjbz/api.php?lx=dongman&format=images
     * @return
     */
    @GET("sjbz/api.php")
    Observable<PictureData> getPicture(@Query("lx") String lx, @Query("format") String format);

    /**
     * https://api.apiopen.top/getJoke?page=1&count=2&type=video
     * http://api.btstu.cn/yan/api.php?charset=utf-8&encode=json
     */
    @GET("yan/api.php")
    Observable<JokeData> getJoke(@Query("charset") String charset, @Query("encode") String encode);

}

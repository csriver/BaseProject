package lib.util;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Build;

import androidx.core.content.FileProvider;

import java.io.File;
import java.util.List;

/**
 * Created by jcs on 2020/8/16.
 * Describe
 */
public class UriUtil {
   public static Uri getUri(Context context,Intent intent, String path){
       Uri uri;
       if (Build.VERSION.SDK_INT <= Build.VERSION_CODES.M) {
           uri = Uri.fromFile(new File(path));
       } else {
           /**
            * 7.0 调用系统相机拍照不再允许使用Uri方式，应该替换为FileProvider
            * 并且这样可以解决MIUI系统上拍照返回size为0的情况
            */
           uri = FileProvider.getUriForFile(context,"com.cs.libskotlin.FileProvider", new File(path));
           //加入uri权限 要不三星手机不能拍照
           List<ResolveInfo> resInfoList = context.getPackageManager().queryIntentActivities(intent, PackageManager.MATCH_DEFAULT_ONLY);
           for (ResolveInfo resolveInfo : resInfoList) {
               String packageName = resolveInfo.activityInfo.packageName;
               context.grantUriPermission(packageName, uri, Intent.FLAG_GRANT_WRITE_URI_PERMISSION | Intent.FLAG_GRANT_READ_URI_PERMISSION);
           }
       }
       return uri;
   }
}

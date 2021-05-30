package lib.util;


import android.content.Context;
import android.widget.Toast;

/**
 * Describe
 */
public class ToastUtil {
    public static void toastShort(Context context,String text){
        Toast.makeText(context,text,Toast.LENGTH_SHORT).show();
    }
    public static void toastLong(Context context,String text){
        Toast.makeText(context,text,Toast.LENGTH_LONG).show();
    }
//    public static void toast(Activity activity, int dur, String msg){
//        View toastRoot =activity.getLayoutInflater().inflate(R.layout.search_toast, null);
//        Toast toast = new Toast(activity);
//        toast.setView(toastRoot);
//        TextView tv = (TextView) toastRoot.findViewById(R.id.message);
//        tv.setText(msg);
//        toast.setDuration(dur);
//        toast.setGravity(Gravity.CENTER, 0, 0);
//        toast.show();
//    }
}

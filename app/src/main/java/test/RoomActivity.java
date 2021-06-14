package test;

import android.os.Bundle;
import android.provider.Settings;
import android.view.View;

import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;

import com.base.pj.R;
import com.base.pj.base.BaseActivity;
import com.base.pj.databinding.ActivityRoomBinding;
import com.base.pj.databinding.ActivityWelcomeBinding;
import com.base.pj.util.RoomUtil;

import java.util.List;

import lib.room.Person;
import lib.util.JLog;


public class RoomActivity extends BaseActivity {
    private ActivityRoomBinding binding;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_room);

        String androidId = Settings.System.getString(getContentResolver(), Settings.Secure.ANDROID_ID);
        binding.textView.setText(androidId);

        update();
        binding.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        binding.button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Person person = new Person(RoomUtil.key_phone,"132000002");
                RoomUtil.insertOrUpdatePerson(person);
            }
        });

        binding.button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Person person = new Person(RoomUtil.key_phone,"1320033333");
                RoomUtil.insertOrUpdatePerson(person);
            }
        });

        binding.button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RoomUtil.deletePerson(RoomUtil.key_phone);
            }
        });
    }

    private void update(){
        JLog.d("update","update()");
        RoomUtil.getAllPersonLive().observe(this, new Observer<List<Person>>() {
            @Override
            public void onChanged(List<Person> persons) {
                JLog.d("onChanged","persons="+persons.size());
                StringBuilder text = new StringBuilder();
                binding.textView.setText("");
                for (Person person: persons) {
                    binding.textView.append(String.valueOf(person.getId()));
                    binding.textView.append("、");
                    binding.textView.append(person.getPersonKey());
                    binding.textView.append(":");
                    binding.textView.append(person.getPersonValue());
                    binding.textView.append("\n");
                }
            }
        });
    }

    @Override
    public void onClick(View v) {
    }
}
package com.example.nttr.schedulebook;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import io.realm.Realm;
import io.realm.RealmResults;

public class MainActivity extends AppCompatActivity {

    private Realm mRealm;
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Realm開始
        mRealm = Realm.getDefaultInstance();
        // 表示先のListView
        listView = (ListView) findViewById(R.id.listView);

        // Realmからデータ取得
        RealmResults<Schedule> schedules
                = mRealm.where(Schedule.class).findAll();
        // アダプタを生成
        ScheduleAdapter adapter = new ScheduleAdapter(schedules);

        // ListViewへアダプタを登録
        listView.setAdapter(adapter);

        Button dbTest = (Button) findViewById(R.id.db_test_button);
        dbTest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,RealmTestActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onDestroy() {
        // Real クローズ
        mRealm.close();

        super.onDestroy();
    }
}

package com.bluetoothmicrecord;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bluetoothmicrecord.activity.AddBlueToothDevicesActivity;
import com.bluetoothmicrecord.fragment.AppSetFragment;
import com.bluetoothmicrecord.fragment.BlueListFragment;
import com.bluetoothmicrecord.fragment.RecordAudioListFragment;
import com.bluetoothmicrecord.utils.BluetoothUtil;
import com.bluetoothmicrecord.utils.DaoUtils;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView mTitleNameTv;
    private ImageView mTitleRightPicIv;
    private FrameLayout mMainFl;
    private ImageView mBluetoothListIv;
    private TextView mBluetoothListNameTv;
    private LinearLayout mBluetoothListLl;
    private ImageView mRecordAudioIv;
    private TextView mRecordAudioNameTv;
    private LinearLayout mRecordAudioLl;
    private ImageView mAppSetIv;
    private TextView mAppSetTv;
    private LinearLayout mAppSetLl;
    private DaoUtils greenDaoUtil;
    FragmentManager fragmentManager = getSupportFragmentManager();
    private BlueListFragment blueListFragment;

    private int bottomBtPress = 1;//1代表蓝牙列表被点击，2代表录音设备被点击，3代表设置被点击
    private AppSetFragment appSetFragment;
    private RecordAudioListFragment recordAudioListFragment;
    private BluetoothUtil bluetoothUtil;
    private String TAB_TAG = "tab0";
    private ImageView mTitleLeftBackIv;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_layout);
        initView();
        initBottomButtonStatus(0);
        greenDaoUtil = new DaoUtils(this);
        bluetoothUtil = new BluetoothUtil();


    }

    @Override
    protected void onResume() {
        super.onResume();
        loadBlueListFragment(TAB_TAG);
    }

    /**
     * 加载BlueListFragment
     */
    private void loadBlueListFragment(String tag) {
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        switch (tag) {
            case "tab0":
                if (blueListFragment == null) {
                    blueListFragment = new BlueListFragment();
                }
                fragmentTransaction.replace(R.id.main_fl, blueListFragment);
                break;
            case "tab1":
                if (recordAudioListFragment == null) {
                    recordAudioListFragment = new RecordAudioListFragment();
                }
                fragmentTransaction.replace(R.id.main_fl, recordAudioListFragment);
                break;
            case "tab2":
                if (appSetFragment == null) {
                    appSetFragment = new AppSetFragment();
                }
                fragmentTransaction.replace(R.id.main_fl, appSetFragment);
                break;
            default:
                break;
        }

        fragmentTransaction.commitAllowingStateLoss();
    }


    /**
     * 初始化底部按钮状态
     */

    private void initBottomButtonStatus(int position) {
        mBluetoothListIv.setImageResource(R.drawable.bluetooth_list_normal);
        mBluetoothListNameTv.setTextColor(getResources().getColor(R.color.white));
        mRecordAudioIv.setImageResource(R.drawable.record_his_normal);
        mRecordAudioNameTv.setTextColor(getResources().getColor(R.color.white));
        mAppSetIv.setImageResource(R.drawable.app_set_normal);
        mAppSetTv.setTextColor(getResources().getColor(R.color.white));
        switch (position) {
            case 0://蓝牙列表
                bottomBtPress = 1;
                initTopToolBar(0);
                mBluetoothListIv.setImageResource(R.drawable.bluetooth_list_press);
                mBluetoothListNameTv.setTextColor(getResources().getColor(R.color.bottomBtTextColor));
                break;
            case 1://录制音频
                bottomBtPress = 2;
                initTopToolBar(1);
                mRecordAudioIv.setImageResource(R.drawable.record_his_press);
                mRecordAudioNameTv.setTextColor(getResources().getColor(R.color.bottomBtTextColor));
                break;
            case 2://设置
                bottomBtPress = 3;
                initTopToolBar(2);
                mAppSetIv.setImageResource(R.drawable.app_set_press);
                mAppSetTv.setTextColor(getResources().getColor(R.color.bottomBtTextColor));
                break;
            default:
                break;
        }
    }

    /**
     * 初始化顶部布局
     */
    private void initTopToolBar(int i) {
        switch (i) {
            case 0:
                mTitleNameTv.setText("侦控列表");
                mTitleRightPicIv.setVisibility(View.VISIBLE);
                mTitleLeftBackIv.setVisibility(View.INVISIBLE);
                mTitleRightPicIv.setImageResource(R.drawable.add_device_selector);
                break;
            case 1:
                mTitleNameTv.setText("录制音频");
                mTitleRightPicIv.setVisibility(View.INVISIBLE);
                mTitleLeftBackIv.setVisibility(View.INVISIBLE);
                break;
            case 2:
                mTitleNameTv.setText("设置");
                mTitleRightPicIv.setVisibility(View.INVISIBLE);
                mTitleLeftBackIv.setVisibility(View.INVISIBLE);
                break;
            default:
                break;
        }

    }

    private void initView() {
        mTitleNameTv = (TextView) findViewById(R.id.title_name_tv);
        mTitleRightPicIv = (ImageView) findViewById(R.id.title_right_add_iv);
        mTitleRightPicIv.setOnClickListener(this);
        mMainFl = (FrameLayout) findViewById(R.id.main_fl);
        mBluetoothListIv = (ImageView) findViewById(R.id.BluetoothList_iv);
        mBluetoothListNameTv = (TextView) findViewById(R.id.BluetoothListName_tv);
        mBluetoothListLl = (LinearLayout) findViewById(R.id.BluetoothList_ll);
        mBluetoothListLl.setOnClickListener(this);
        mRecordAudioIv = (ImageView) findViewById(R.id.recordAudio_iv);
        mRecordAudioNameTv = (TextView) findViewById(R.id.recordAudioName_tv);
        mRecordAudioLl = (LinearLayout) findViewById(R.id.recordAudio_ll);
        mRecordAudioLl.setOnClickListener(this);
        mAppSetIv = (ImageView) findViewById(R.id.appSet_iv);
        mAppSetTv = (TextView) findViewById(R.id.appSet_tv);
        mAppSetLl = (LinearLayout) findViewById(R.id.appSet_ll);
        mAppSetLl.setOnClickListener(this);
        mTitleLeftBackIv = (ImageView) findViewById(R.id.title_left_back_iv);
    }

    @Override
    public void onClick(View v) {
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        switch (v.getId()) {
            case R.id.title_right_add_iv://添加蓝牙设备
                startActivityForResult(new Intent(this, AddBlueToothDevicesActivity.class), 0);
                break;
            case R.id.BluetoothList_ll://底部蓝牙列表
                TAB_TAG = "tab0";
                initBottomButtonStatus(0);
                if (blueListFragment == null) {
                    blueListFragment = new BlueListFragment();
                }
                fragmentTransaction.replace(R.id.main_fl, blueListFragment);
                break;
            case R.id.recordAudio_ll://底部录制音频
                TAB_TAG = "tab1";
                initBottomButtonStatus(1);
                if (recordAudioListFragment == null) {
                    recordAudioListFragment = new RecordAudioListFragment();
                }
                fragmentTransaction.replace(R.id.main_fl, recordAudioListFragment);
                break;
            case R.id.appSet_ll://底部设置
                TAB_TAG = "tab2";
                initBottomButtonStatus(2);
                if (appSetFragment == null) {
                    appSetFragment = new AppSetFragment();
                }
                fragmentTransaction.replace(R.id.main_fl, appSetFragment);
                break;
        }
        fragmentTransaction.commit();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        switch (resultCode) {
            case 0://该结果码要与Fragment中的一致,0代表不同意打开蓝牙
                super.onActivityResult(requestCode, resultCode, data);
                break;
            case -1://该结果码要与Fragment中的一致,-1代表同意打开蓝牙
                super.onActivityResult(requestCode, resultCode, data);
                break;
            case 99:
                Toast.makeText(getApplicationContext(), "设备添加成功", Toast.LENGTH_LONG).show();
                break;
        }


    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        bluetoothUtil.appToFinish();
    }
}

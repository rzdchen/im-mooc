package net.qiujuer.italker.common.app;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;

import java.util.List;


public abstract class Activity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initWindows();
        if (initArgs(getIntent().getExtras())) {
            getContentLayoutId();
            initWidget();
            initData();
        } else {
            finish();
        }
    }

    protected abstract int getContentLayoutId();

    /**
     * 初始化窗口
     */
    protected void initWindows() {

    }

    /**
     * 初始化控件
     */
    protected void initWidget() {

    }

    /**
     * 初始化数据
     */
    protected void initData() {

    }

    /**
     * 初始化相关参数
     *
     * @param bundle 参数
     * @return 成功 true
     */
    protected boolean initArgs(Bundle bundle) {
        return true;
    }

    @Override
    public boolean onSupportNavigateUp() {
        //当点击界面导航返回时，Finish当前界面
        finish();
        return super.onSupportNavigateUp();
    }

    @Override
    public void onBackPressed() {
        //得到当前activity下的所有fragment
        List<Fragment> fragments = getSupportFragmentManager().getFragments();
        if (fragments != null && fragments.size() > 0) {
            for (Fragment f : fragments) {
                //判断是否为我们能处理的fragment类型
                if (f instanceof net.qiujuer.italker.common.app.Fragment) {
                    //判断是否拦截了返回按钮
                    if (((net.qiujuer.italker.common.app.Fragment) f).onBackPressed()) {
                        //如果有直接return
                        return;
                    }
                }
            }
        }

        super.onBackPressed();
        finish();
    }
}

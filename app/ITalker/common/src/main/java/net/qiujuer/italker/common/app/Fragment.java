package net.qiujuer.italker.common.app;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public abstract class Fragment extends android.support.v4.app.Fragment {
    protected View mRoot;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        initArgs(getArguments());
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (mRoot == null) {

            View root = inflater.inflate(getLayoutId(), container, false);
            initWidget(root);
            mRoot = root;
        } else {
            if (mRoot.getParent() != null) {
                //把当前root从其父控件中移除
                ((ViewGroup) mRoot.getParent()).removeView(mRoot);
            }
        }

        return mRoot;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        //view创建完成后创建数据
        initData();
    }

    protected abstract int getLayoutId();
    /**
     * 初始化相关参数
     * @param bundle 参数
     * @return 成功 true
     */
    protected void initArgs(Bundle bundle){
    }
    /**
     * 初始化控件
     */
    protected void initWidget(View view) {

    }

    /**
     * 初始化数据
     */
    protected void initData() {

    }

    /**
     * 返回按键触发时调用
     */
    public boolean onBackPressed(){
        return false;
    }

}

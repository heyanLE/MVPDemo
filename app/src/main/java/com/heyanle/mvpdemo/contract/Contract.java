package com.heyanle.mvpdemo.contract;


import com.heyanle.mvpdemo.presenter.IPresenter;
import com.heyanle.mvpdemo.view.IView;

/**
 * 契约类 - 指定一个 V 层和 P 层
 * Created by HeYanLe on 2020/8/8 0008 17:36.
 * https://github.com/heyanLE
 */
public abstract class Contract<V extends IView, P extends IPresenter<V>> {

    private V iView;
    private P iPresenter;


    public V getView() {
        return iView;
    }

    public P getPresenter() {
        return iPresenter;
    }

    abstract P newPresenter();

    public P bind(V iView){
        this.iView  = iView;
        if (null == iPresenter){
            iPresenter = newPresenter();
            iPresenter.onInit();
        }else{
            iPresenter.onUnbind();
        }
        iPresenter.onBind(iView);
        return iPresenter;
    }

    public void unbind(IView iView1){
        if (iView1 == iView) {
            if (null != iPresenter) {
                iPresenter.onUnbind();
                iView = null;
            }
        }
    }


}

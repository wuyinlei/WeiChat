package com.example.mychat.widget;

import android.app.Dialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.example.mychat.R;

/**
 * Created by wuyinlei on 2015/12/9.
 */
public class LoadingDialog {

    private Context mContext;

    private TextView mTextMsg;
    private Dialog mDialog;
    private View mDialogView;
    public LoadingDialog(Context context){
        mContext = context;
        mDialogView = LayoutInflater.from(mContext).inflate(R.layout.dialog_loading,null);
        mTextMsg = (TextView) mDialogView.findViewById(R.id.txtMsg);
        initDialog();
    }

    public void setMessage(CharSequence msg){
        mTextMsg.setText(msg);
    }

    public void setMessage(int msg){
        mTextMsg.setText(msg);
    }

    private void initDialog(){
        mDialog = new Dialog(mContext,R.style.dialog);
        mDialog.setContentView(mDialogView);
        mDialog.setCanceledOnTouchOutside(true);
    }

    public void show(){
        if (mDialog != null)
            mDialog.show();
    }

    public void dismiss(){
        if (mDialog != null)
            mDialog.dismiss();
    }
}

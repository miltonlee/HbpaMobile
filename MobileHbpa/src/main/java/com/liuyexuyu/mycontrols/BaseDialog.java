package com.liuyexuyu.mycontrols;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;

public class BaseDialog extends Dialog implements DialogInterface {

	public BaseDialog(Context context) {
		super(context);
		
	}
	public BaseDialog(Context context,int srcTheme) {
		super(context, srcTheme);
	}
}

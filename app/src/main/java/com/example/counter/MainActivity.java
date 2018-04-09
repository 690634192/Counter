package com.example.counter;

import android.app.Activity;
import android.content.Context;
import android.icu.math.BigDecimal;
import android.icu.text.NumberFormat;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

//	新添加的注释
public class MainActivity extends Activity implements View.OnClickListener {
	private Button one_btn,two_btn,three_btn,four_btn,five_btn,six_btn,seven_btn;
	private Button eight_btn,night_btn,zero_btn,add_btn,minus_btn,ride_btn,divide_btn;
	private Button C_btn,back_btn,equals_btn,dot_btn;
	private TextView info_tv_bottom,mark_tv;
	private EditText info_tv_top;
	private StringBuilder mstringbulider = new StringBuilder();
	private Context context;
	private double result;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		context = this;
		//绑定控件
		binding();
		
	}

	/**
	 * @Time:2017年11月20日 下午3:40:31
	 * @author: Oldsboy
	 * @Todo:
	 */
	private void binding() {
		// TODO Auto-generated method stub
		one_btn = (Button)findViewById(R.id.one_btn);
		two_btn = (Button)findViewById(R.id.two_btn);
		three_btn = (Button)findViewById(R.id.three_btn);
		four_btn = (Button)findViewById(R.id.four_btn);
		five_btn = (Button)findViewById(R.id.five_btn);
		six_btn = (Button)findViewById(R.id.six_btn);
		seven_btn = (Button)findViewById(R.id.seven_btn);
		eight_btn = (Button)findViewById(R.id.eight_btn);
		night_btn = (Button)findViewById(R.id.night_btn);
		zero_btn = (Button)findViewById(R.id.zero_btn);
		add_btn = (Button)findViewById(R.id.add_btn);
		minus_btn = (Button)findViewById(R.id.minus_btn);
		ride_btn = (Button)findViewById(R.id.ride_btn);
		divide_btn = (Button)findViewById(R.id.divide_btn);
		C_btn = (Button)findViewById(R.id.C_btn);
		back_btn = (Button)findViewById(R.id.back_btn);
		equals_btn = (Button)findViewById(R.id.equals_btn);
		dot_btn = (Button)findViewById(R.id.dot_btn);
		info_tv_top = (EditText)findViewById(R.id.info_tv_top);
		info_tv_bottom = (TextView)findViewById(R.id.info_tv_bottom);
		mark_tv = (TextView)findViewById(R.id.mark_tv);
		
		
		one_btn.setOnClickListener(this);
		two_btn.setOnClickListener(this);
		three_btn.setOnClickListener(this);
		four_btn.setOnClickListener(this);
		five_btn.setOnClickListener(this);
		six_btn.setOnClickListener(this);
		seven_btn.setOnClickListener(this);
		eight_btn.setOnClickListener(this);
		night_btn.setOnClickListener(this);
		zero_btn.setOnClickListener(this);
		add_btn.setOnClickListener(this);
		minus_btn.setOnClickListener(this);
		divide_btn.setOnClickListener(this);
		ride_btn.setOnClickListener(this);
		C_btn.setOnClickListener(this);
		back_btn.setOnClickListener(this);
		equals_btn.setOnClickListener(this);
		dot_btn.setOnClickListener(this);
	}

	/**
	 * @Time:2017年11月21日 上午9:59:57
	 * @author: Oldsboy
	 * @Todo:按钮点击事件
	 */
	@Override
	public void onClick(View view) {
		switch(view.getId()) {
		case R.id.one_btn:
			clickNumber(one_btn.getText().toString()); 
			break;
		case R.id.two_btn:
			clickNumber(two_btn.getText().toString()); 
			break;
		case R.id.three_btn:
			clickNumber(three_btn.getText().toString()); 
			break;
		case R.id.four_btn:
			clickNumber(four_btn.getText().toString()); 
			break;
		case R.id.five_btn:
			clickNumber(five_btn.getText().toString()); 
			break;
		case R.id.six_btn:
			clickNumber(six_btn.getText().toString()); 
			break;
		case R.id.seven_btn:
			clickNumber(seven_btn.getText().toString()); 
			break;
		case R.id.eight_btn:
			clickNumber(eight_btn.getText().toString()); 
			break;
		case R.id.night_btn:
			clickNumber(night_btn.getText().toString()); 
			break;
		case R.id.zero_btn:
			clickNumber(zero_btn.getText().toString()); 
			break;
		case R.id.add_btn:
			clickMark(add_btn.getText().toString());
			break;
		case R.id.minus_btn:
			clickMark(minus_btn.getText().toString());
			break;
		case R.id.ride_btn:
			clickMark(ride_btn.getText().toString());
			break;
		case R.id.divide_btn:
			clickMark(divide_btn.getText().toString());
			break;
		case R.id.dot_btn:
			if(info_tv_bottom.getText().toString().length() > 0) {
				if(!mstringbulider.toString().contains(".")) 
					mstringbulider.append(".");
			}
			info_tv_bottom.setText(mstringbulider);	//显示
			break;
		case R.id.C_btn:
			//全清
			mstringbulider.delete(0, mstringbulider.length());
			info_tv_bottom.setText("");
			info_tv_top.setText("");
			mark_tv.setText("");
			break;
		case R.id.back_btn:
			//如果下行有数字，删除
			if(info_tv_bottom.getText().toString().length() > 0) {
				mstringbulider.delete(mstringbulider.length() - 1, mstringbulider.length());
				info_tv_bottom.setText(mstringbulider);
			}
			break;
		case R.id.equals_btn:
			if(info_tv_bottom.getText().toString().length() > 0 &&	info_tv_top.getText().toString().length() > 0 && mark_tv.getText().toString().length() > 0)
				countResult(mark_tv.getText().toString());//计算结果
			//当需要负数时
			if(info_tv_bottom.getText().toString().length() > 0 && mark_tv.getText().toString().equals("-")) {
				mstringbulider.insert(0, "-");	//把负号插入到数字前
				info_tv_top.setText(mstringbulider);
				mark_tv.setText("");
				mstringbulider.delete(0, mstringbulider.length());
				info_tv_bottom.setText("");
			}
			
			break;
		}
	}


	/**
	 * @Time:2017年11月23日 下午3:12:48
	 * @author: Oldsboy
	 * @param mark 
	 * @Todo:计算结果
	 */
	private void countResult(String mark) {
		// TODO Auto-generated method stub
		switch(mark) {
		case "+":
			result = Double.valueOf(info_tv_top.getText().toString()) + Double.valueOf(info_tv_bottom.getText().toString());
			afterCountResult(result);
			break;
		case "-":
			result = Double.valueOf(info_tv_top.getText().toString()) - Double.valueOf(info_tv_bottom.getText().toString());
			afterCountResult(result);
			break;
		case "*":
			result = Double.valueOf(info_tv_top.getText().toString()) * Double.valueOf(info_tv_bottom.getText().toString());
			afterCountResult(result);
			break;
		case "/":
			result = Double.valueOf(info_tv_top.getText().toString()) / Double.valueOf(info_tv_bottom.getText().toString());
			afterCountResult(result);
			break;
		}
	}

	/**
	 * @Time:2017年11月23日 下午4:08:30
	 * @author: Oldsboy
	 * @param result 
	 * @Todo:
	 */
	private void afterCountResult(double result) {
		Log.d("content", "结果为" + result);
		//如果结果大于12位数，自动缩小字体
		String str = String.valueOf(result);
		Log.d("content", result + str + "长度为" + str.length());
		if(str.length() > 12) {
			info_tv_top.setTextSize(25);
		}else {
			info_tv_top.setTextSize(50);
		}
		info_tv_top.setText(str);
		info_tv_bottom.setText("");
		mark_tv.setText("");
		mstringbulider.delete(0, mstringbulider.length());
	}

	/**
	 * @Time:2017年11月21日 上午10:08:35
	 * @author: Oldsboy
	 * @Todo:符号按钮点击事件
	 */
	private void clickMark(CharSequence mark) {
		//如果三个view都有数据，则先进行计算
		if(info_tv_bottom.getText().toString().length() > 0 &&	info_tv_top.getText().toString().length() > 0 && mark_tv.getText().toString().length() > 0) {
			countResult(mark_tv.getText().toString());
		}
		if(info_tv_bottom.getText().toString().length() > 0 && mark_tv.getText().toString().equals("-")) {
			mstringbulider.insert(0, "-");	//把负号插入到数字前
			info_tv_top.setText(mstringbulider);
			mark_tv.setText("");
			mstringbulider.delete(0, mstringbulider.length());
			info_tv_bottom.setText("");
		}
		mark_tv.setText(mark);
		//如果下行有数字，则把下行数字转移至上行
		if(mstringbulider.length() > 0) {
			info_tv_top.setText(info_tv_bottom.getText().toString());
			info_tv_bottom.setText("");
			mstringbulider.delete(0, mstringbulider.length());
		}
	}

	/**
	 * @Time:2017年11月21日 上午10:04:05
	 * @author: Oldsboy
	 * @Todo:数字按钮点击事件
	 */
	private void clickNumber(CharSequence num) {
		if(info_tv_bottom.getText().length() > 8) {
			Toast.makeText(context, "最大文本限制9位", Toast.LENGTH_SHORT).show();
		}else {
			mstringbulider.append(num);
			info_tv_bottom.setText(mstringbulider);	//添加一位数并显示
		}
		
		//如果有结果但没符号,刷新StringBuilder,把结果放入上行
		if(info_tv_top.getText().toString().length() > 0 && mark_tv.getText().toString() == "") {
			mstringbulider.delete(0, mstringbulider.length());
			info_tv_top.setText("");
			mstringbulider.append(num);
			info_tv_bottom.setText(mstringbulider);	//添加一位数并显示
		}
	}

	
}

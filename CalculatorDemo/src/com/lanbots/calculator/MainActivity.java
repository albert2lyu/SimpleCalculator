package com.lanbots.calculator;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.renderscript.Type;
import android.test.PerformanceTestCase.Intermediates;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;
/**
 * ʵսС��Ŀ֮���׼�����
 * ��Դ���Լ���ѧԺ
 * @author LinBots
 *
 */
public class MainActivity extends Activity implements OnClickListener {
	//0~9
	private Button btnZero;
	private Button btnOne;
	private Button btnTwo;
	private Button btnThree;
	private Button btnFour;
	private Button btnFive;
	private Button btnSix;
	private Button btnSeven;
	private Button btnEight;
	private Button btnNine;
	//�� �� �� �� = ���
	private Button btnAdd;
	private Button btnMinus;
	private Button btnTake;
	private Button btnDiv;
	private Button btnEqual;
	private Button btnClear;
	private TextView result;
	//����һ��Item���͵�����
	private List<Item> items = new ArrayList<Item>();



	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_main);

		//��ʼ���ؼ�Ԫ��
		initView();

	}

	private void initView(){
		btnZero = (Button) findViewById(R.id.btnZero);
		btnOne = (Button) findViewById(R.id.btnOne);
		btnTwo = (Button) findViewById(R.id.btnTwo);
		btnThree = (Button) findViewById(R.id.btnThree);
		btnFour = (Button) findViewById(R.id.btnFour);
		btnFive = (Button) findViewById(R.id.btnFive);
		btnSix = (Button) findViewById(R.id.btnSix);
		btnSeven = (Button) findViewById(R.id.btnSeven);
		btnEight = (Button) findViewById(R.id.btnEight);
		btnNine = (Button) findViewById(R.id.btnNine);
		btnAdd = (Button) findViewById(R.id.btnAdd);
		btnMinus = (Button) findViewById(R.id.btnMinus);
		btnTake = (Button) findViewById(R.id.btnTake);
		btnDiv = (Button) findViewById(R.id.btnDiv);
		btnClear = (Button) findViewById(R.id.btnClear);
		btnEqual = (Button) findViewById(R.id.btnEqual);
		result = (TextView) findViewById(R.id.result);

		btnZero.setOnClickListener(this);
		btnOne.setOnClickListener(this);
		btnTwo.setOnClickListener(this);
		btnThree.setOnClickListener(this);
		btnFour.setOnClickListener(this);
		btnFive.setOnClickListener(this);
		btnSix.setOnClickListener(this);
		btnSeven.setOnClickListener(this);
		btnEight.setOnClickListener(this);
		btnNine.setOnClickListener(this);
		btnAdd.setOnClickListener(this);
		btnMinus.setOnClickListener(this);
		btnTake.setOnClickListener(this);
		btnDiv.setOnClickListener(this);
		btnEqual.setOnClickListener(this);
		btnClear.setOnClickListener(this);
	}


	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.btnZero:
			result.append("0");
			break;
		case R.id.btnOne:
			result.append("1");
			break;
		case R.id.btnTwo:
			result.append("2");
			break;
		case R.id.btnThree:
			result.append("3");
			break;
		case R.id.btnFour:
			result.append("4");
			break;
		case R.id.btnFive:
			result.append("5");
			break;
		case R.id.btnSix:
			result.append("6");
			break;
		case R.id.btnSeven:
			result.append("7");
			break;
		case R.id.btnEight:
			result.append("8");
			break;
		case R.id.btnNine:
			result.append("9");
			break;
		case R.id.btnAdd:
			//�������ָ��ӵ�������
			items.add(new Item(Double.parseDouble(result.getText().toString()) , Types.NUM));
			checkAndCompute();
			//����������µĲ�����.��ʱValue����Ҫ��
			items.add(new Item(0, Types.ADD));
			//���TextVew
			result.setText("");
			break;
		case R.id.btnMinus:
			items.add(new Item(Double.parseDouble(result.getText().toString()) , Types.NUM));
			checkAndCompute();
			items.add(new Item(0, Types.MINUS));
			result.setText("");
			break;
		case R.id.btnTake:
			items.add(new Item(Double.parseDouble(result.getText().toString()) , Types.NUM));
			checkAndCompute();
			items.add(new Item(0, Types.TAKE));
			result.setText("");
			break;
		case R.id.btnDiv:
			items.add(new Item(Double.parseDouble(result.getText().toString()) , Types.NUM));
			checkAndCompute();
			items.add(new Item(0, Types.DIV));
			result.setText("");
			break;
		case R.id.btnClear:
			//���TextView
			result.setText("");
			//�������
			items.clear();
			break;
		case R.id.btnEqual:
			items.add(new Item(Double.parseDouble(result.getText().toString()) , Types.NUM));
			checkAndCompute();
			//��������ںź󣬾Ͳ�ִ�����������ˣ������ֵ�ͷ�����items����ĵ�һ��λ��
			result.setText(items.get(0).value+"");
			//�������
			items.clear();
			break;
		default:
			break;
		}
	}
	//��������Ƿ���3�����ǣ������,Ȼ��Ѽ���ǹ�����ӵ�������
	public void checkAndCompute(){
		if (items.size() >= 3){

			double a = items.get(0).value;
			double b = items.get(2).value;
			int op = items.get(1).type;
			//���items
			items.clear();
			switch (op) {
			case Types.ADD:
				items.add(new Item(a+b, Types.MINUS));
				break;
			case Types.MINUS:
				items.add(new Item(a-b, Types.MINUS));
				break;
			case Types.TAKE:
				items.add(new Item(a*b, Types.MINUS));
				break;
			case Types.DIV:
				items.add(new Item(a/b, Types.MINUS));
				break;
			default:
				break;
			}
		}
	}
}

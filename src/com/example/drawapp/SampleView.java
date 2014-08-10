package com.example.drawapp;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;

public class SampleView extends View {

	private static final int RED = 0;
	private Paint paint = new Paint();
	private int color = Color.RED;
	private int		bx = 500;
	private int		by = 500;
	private	int 	dx = 2;
	private	int 	dy = 2;
	private static int margin = 20;
	private Bitmap item;
	
	public SampleView(Context context) {
		super(context);
		setBackgroundColor(Color.WHITE); // static ������@new ����Ȃ�
		Resources res = context.getResources();
		//�����`���[�A�C�R���擾
		item = BitmapFactory.decodeResource(res, R.drawable.ic_launcher);
	}
	@Override
	public void onDraw(Canvas canvas){
		paint.setColor(color);
		canvas.drawCircle(bx,by ,20, paint);
		canvas.drawCircle(dx*by, dx+by, 30, paint);
		canvas.drawBitmap(item,bx+1 ,by+1, null);
		/* ���[�A�E�[�A��[�A���[�ɗ����Ƃ��̏��� */
        /* ���[�ɗ����甽�] */
        if (bx < 0 + margin ) {
            dx = 2;
        }
        /* �E�[�ɗ����甽�] */
        if (bx > getWidth() - margin) {
            dx = -2;
        }
        /* ��[�ɗ����甽�] */
        if (by < 0 + margin) {
            dy = 2;
        }		
        /* �E�[�ɗ����甽�] */
        if (by  > getHeight() - margin) {
            dy = -2;
        }                
        bx = bx + dx;
        by = by + dy;
	}
	@Override
	public boolean onTouchEvent(MotionEvent event){
		
			int action = event.getAction();
			if((action & MotionEvent.ACTION_MASK) == MotionEvent.ACTION_DOWN) {
			// �^�b�`���ꂽ���Ƃ𔻒�
				int ex = (int)event.getX();
				int ey = (int)event.getY();
				if((bx - ex)*(bx - ex)+(by - ey)*(by - ey) <= 20*20){
				Toast.makeText(getContext(), 
				"Touch����܂���", Toast.LENGTH_SHORT).show();
				//�����ς���B��������ԂɁA�Ԃ��������
				if(color == Color.BLUE){
					color = Color.RED;
				} else{
					color = Color.BLUE;
				}
				
				invalidate(); //�ĕ`��
				}
			}
			
		
		return true;
	}
	}

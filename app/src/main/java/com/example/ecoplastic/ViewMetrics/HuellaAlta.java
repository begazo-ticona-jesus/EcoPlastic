package com.example.ecoplastic.ViewMetrics;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;

public class HuellaAlta extends View {
    Paint barPaint;
    Paint contPaint;
    Paint textPaint;

    public HuellaAlta(Context context) {
        super(context);
    }
    public HuellaAlta(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }
    public HuellaAlta(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    protected  void onDraw(Canvas canvas){
        super.onDraw(canvas);
        int width = getMeasuredWidth();
        int alto = 500;
        int widthCont = 160;
        int widthElem = 100;
        int topC = 50;
        int topE = 80;
        int bottonC = topC+alto+(topE-topC)*2;
        int bottonE = topE+alto;

        int leftC= (width-widthCont)/2;
        int rigthC= (width+widthCont)/2;

        int leftE= (width-widthElem)/2;
        int rigthE= (width+widthElem)/2;

        Rect container = new Rect(leftC, topC, rigthC, bottonC);
        Rect elementCal = new Rect(leftE, topE, rigthE, bottonE);
        canvas.drawRect(container,barPaint);
        canvas.drawRect(elementCal, contPaint);

        canvas.drawText("Bajo",rigthC+10,bottonE-(alto/8),textPaint);
        canvas.drawText("Regular",rigthC+10,bottonE-(alto*3/8),textPaint);
        canvas.drawText("Frecuente",rigthC+10,bottonE-(alto*5/8),textPaint);
        canvas.drawText("Alto",rigthC+10,bottonE-(alto*7/8),textPaint);


        canvas.drawLine(leftE,(topE+alto*3/4),rigthE,(topE+alto*3/4),textPaint);
        canvas.drawLine(leftE,(topE+alto/2),rigthE,(topE+alto/2),textPaint);
        canvas.drawLine(leftE,(topE+alto/4),rigthE,(topE+alto/4),textPaint);

    }

    private void init(){
        barPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        barPaint.setColor(Color.BLACK);
        contPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        contPaint.setColor(Color.RED);
        textPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        textPaint.setColor(Color.BLACK);
        textPaint.setStrokeWidth(10);
        textPaint.setTextSize(40);
    }
}
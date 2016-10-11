package com.wangly.defineview.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

/**
 * Created by wangly on 2016/10/10.
 */

public class CircleProgressView extends View {

    private Paint paint;
    private Context mContext;
    private Rect mTextRect;
    private Paint mTextPaint;
    private String progressText = "50%";
    private Rect mImageRect;
    private Paint mLinePaint;

    public CircleProgressView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public CircleProgressView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.mContext = context;
        this.paint = new Paint();
        this.paint.setAntiAlias(true); //消除锯齿
        this.paint.setStyle(Paint.Style.STROKE); //绘制空心圆


        // 绘制进度 初始化
        mTextPaint = new Paint();
        mTextPaint.setAntiAlias(true); //消除锯齿
        mTextRect = new Rect();


        // 不规则图形初始化

        mImageRect = new Rect();

        mLinePaint = new Paint();
        mLinePaint.setAntiAlias(true); //消除锯齿

    }

    public CircleProgressView(Context context) {
        super(context);

    }

    @Override
    protected void onDraw(Canvas canvas) {
        Log.i("wangly", "onDraw()");
        int center = getWidth() / 2;
        int innerCircle = dip2px(mContext, 83); //设置内圆半径
        int ringWidth = dip2px(mContext, 5); //设置圆环宽度

        //绘制外圆
        this.paint.setARGB(155, 167, 190, 206);
        this.paint.setStrokeWidth(4);
        canvas.drawCircle(center, center, innerCircle + ringWidth, this.paint);


        // 绘制中心的进度值
        mTextPaint.setColor(Color.BLACK);
        mTextPaint.setTextSize(dip2px(mContext, 16));
        mTextPaint.getTextBounds(progressText, 0, progressText.length(),
                mTextRect);
        canvas.drawText(progressText, center - mTextRect.width() / 2, center + mTextRect.height() / 2, mTextPaint);


        // 绘制 不规制图片
//        drawableWaveView(canvas);

        super.onDraw(canvas);


    }












    private boolean isRun = true;
    private double angle;

    public void drawableWaveView(Canvas canvas) {
        Paint paint3 = new Paint();
        int height = getHeight();
        int width = getWidth();
        paint3.setAlpha(150);
        paint3.setColor(Color.rgb(89, 186, 231));
        double lineX = 0;
        double lineY3 = 0;
        for (int i = 0; i < width; i++) {
            lineX = i;
            if (isRun) {
                lineY3 = 20 * Math.sin((i + angle) * Math.PI / 180) + 50;
            } else {
                lineY3 = 50;
            }
            canvas.drawLine((int) lineX, (int) (lineY3 + height - getHeight() / 1.5),
                    (int) lineX + 1, height - getHeight() /3, paint3);
        }
        invalidate();
    }

    Runnable runnable = new Runnable() {
        @Override
        public void run() {
            while (isRun) {
                angle++;
                if (angle == 360) {
                    angle = 0;
                }
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }
    };

    public void start() {
        isRun = true;
//        new Thread(runnable).start();
    }

    public void setProgress(String progress) {
        this.progressText = progress;
    }


    /**
     * 根据手机的分辨率从 dp 的单位 转成为 px(像素)
     */
    public static int dip2px(Context context, float dpValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5f);
    }
}

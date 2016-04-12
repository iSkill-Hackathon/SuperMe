package ie.mylifesolutions.superme.utils;

import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;

public class ShadowSpan extends ClickableSpan{

    private int mRadius;
    private int mDx;
    private int mDy;
    private int mColor;

    public ShadowSpan(int radius, int dx, int dy, int color){
        this.mColor = color;
        this.mDx = dx;
        this.mDy = dy;
        this.mRadius = radius;
    }

    @Override
    public void updateDrawState(TextPaint textPaint){
        textPaint.setShadowLayer(mRadius, mDx, mDy, mColor);
    }
    @Override
    public void onClick(View view){
        //Needed to be implemented, do not need onClick I think...
    }
}

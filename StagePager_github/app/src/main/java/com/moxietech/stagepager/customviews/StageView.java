package com.moxietech.stagepager.customviews;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.moxietech.stagepager.R;

/**
 * Created by arun_a on 22/8/17.
 */

public class StageView extends View {

    private int noOfStages;

    public StageView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        TypedArray attrsArray = context.getTheme().obtainStyledAttributes(
                attrs, R.styleable.StageView, 0, 0);
        noOfStages = attrsArray.getInt(R.styleable.StageView_no_of_stages, 0);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        drawStages(canvas);
    }

    private void drawStages(Canvas canvas) {
        int cellCount = noOfStages + 2;
        int cellWidth = getMeasuredWidth() / cellCount;
        Paint bubblePaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        bubblePaint.setColor(getResources().getColor(R.color.colorAccent));
        bubblePaint.setStyle(Paint.Style.FILL_AND_STROKE);
        for (int i = 0; i < cellCount; i++) {
            canvas.drawRect(cellWidth * i, 0, cellWidth, getMeasuredHeight(), bubblePaint);
        }



    }
}

package com.moxietech.stagepager.customviews;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.moxietech.stagepager.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by arun_a on 22/8/17.
 */

public class StageView extends View {

    public static final int MARGIN_PERCENTAGE = 10;

    private int noOfStages;
    private int startPointTop;
    private int canvasWidth;
    private int stageCellWidth;

    public StageView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        TypedArray attrsArray = context.getTheme().obtainStyledAttributes(
                attrs, R.styleable.StageView, 0, 0);
        noOfStages = attrsArray.getInt(R.styleable.StageView_no_of_stages, 0);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        cutMarginInCanvas();
        int cellStartTop = startPointTop;
        for (int i = 0; i < noOfStages; i++) {
            canvas.drawRect(cellStartTop, 0, cellStartTop + canvasWidth, getMeasuredHeight(),
                    getEmptyStagePaint());
            cellStartTop = cellStartTop + stageCellWidth;
        }

    }

    /**
     * Cuts the specified percentage of margin in canvas width.
     */
    private void cutMarginInCanvas() {
        canvasWidth = getMeasuredWidth();
        int margin = (canvasWidth * MARGIN_PERCENTAGE) / 100;
        canvasWidth = canvasWidth - margin;
        startPointTop = margin / 2;
        stageCellWidth = canvasWidth/noOfStages;
    }

    private List<Rect> getStageRects() {
        List<Rect> stageRects = new ArrayList<>();

        return stageRects;
    }

    /**
     * Returns the filled color paint to draw finished and current stages.
     *
     * @return {@link Paint}
     */
    private Paint getFilledStagePaint() {
        Paint filledStagePaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        filledStagePaint.setColor(getResources().getColor(R.color.colorAccent));
        filledStagePaint.setStyle(Paint.Style.FILL);
        return filledStagePaint;
    }

    /**
     * Returns the empty color paint to draw upcoming stages.
     *
     * @return {@link Paint}
     */
    private Paint getEmptyStagePaint() {
        Paint emptyStagePaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        emptyStagePaint.setColor(getResources().getColor(R.color.colorPrimaryDark));
        emptyStagePaint.setStyle(Paint.Style.STROKE);
        return emptyStagePaint;
    }

}

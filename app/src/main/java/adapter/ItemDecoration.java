package adapter;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.view.View;

public class ItemDecoration extends RecyclerView.ItemDecoration {

    private Paint paintOfLine;
    private int offset;

    public ItemDecoration() {
        offset = 10;
        paintOfLine = new Paint(Paint.DITHER_FLAG);
        paintOfLine.setColor(Color.WHITE);
        paintOfLine.setStyle(Paint.Style.FILL);
        paintOfLine.setStrokeWidth(1);


    }

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        super.getItemOffsets(outRect, view, parent, state);
        outRect.set(offset, offset, offset, offset);
    }

    @Override
    public void onDraw(Canvas c, RecyclerView parent, RecyclerView.State state) {
        super.onDraw(c, parent, state);

        final RecyclerView.LayoutManager layoutManager = parent.getLayoutManager();

        for (int i = 0; i < parent.getChildCount(); i++) {
            final View child = parent.getChildAt(i);
            c.drawRect(
                    layoutManager.getDecoratedLeft(child),
                    layoutManager.getDecoratedTop(child),
                    layoutManager.getDecoratedRight(child),
                    layoutManager.getDecoratedBottom(child),
                    paintOfLine);


        }
    }
}